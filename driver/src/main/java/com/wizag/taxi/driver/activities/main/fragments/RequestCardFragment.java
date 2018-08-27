package com.wizag.taxi.driver.activities.main.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wizag.taxi.common.models.Request;
import com.wizag.taxi.common.utils.CommonUtils;
import com.wizag.taxi.driver.R;
import com.wizag.taxi.driver.databinding.FragmentRequestCardBinding;

public class RequestCardFragment extends Fragment {
    private Request request;
    FragmentRequestCardBinding binding;
    private CountDownTimer countDownTimer;
    private OnFragmentInteractionListener mListener;
    private static final String ARG_REQUEST = "request";

    public RequestCardFragment() {

    }

    public static RequestCardFragment newInstance(Request request) {
        RequestCardFragment fragment = new RequestCardFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_REQUEST, request);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            request = (Request) getArguments().getSerializable(ARG_REQUEST);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_request_card,container,false);
        binding.setRequest(request);
        binding.progressTimeout.setMax(CommonUtils.timeOut);
        countDownTimer = new CountDownTimer(CommonUtils.timeOut, 50) {
            @Override
            public void onTick(long millisUntilFinished) {
                binding.progressTimeout.setProgress((int) millisUntilFinished);
            }

            @Override
            public void onFinish() {
                mListener.onDecline(request);
            }
        };
        countDownTimer.start();
        binding.buttonAccept.setOnClickListener(view -> {
            countDownTimer.cancel();
            mListener.onAccept(request);
        });
        binding.buttonDecline.setOnClickListener(view -> {
            countDownTimer.cancel();
            mListener.onDecline(request);
        });
        return binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onAccept(Request request);
        void onDecline(Request request);
    }
}
