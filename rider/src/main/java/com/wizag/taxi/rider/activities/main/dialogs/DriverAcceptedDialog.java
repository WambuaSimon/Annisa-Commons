package com.wizag.taxi.rider.activities.main.dialogs;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.wizag.taxi.common.models.Travel;
import com.wizag.taxi.common.utils.AlertDialogBuilder;
import com.wizag.taxi.rider.R;
import com.wizag.taxi.rider.activities.main.MainActivity;
import com.wizag.taxi.rider.activities.main.adapters.DriverAcceptedCardAdapter;
import com.wizag.taxi.rider.databinding.DialogRequestServiceBinding;
import com.wizag.taxi.rider.events.NewDriverAcceptedEvent;
import com.wizag.taxi.rider.events.ServiceRequestEvent;
import com.wizag.taxi.rider.events.ServiceRequestResultEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DriverAcceptedDialog extends AppCompatDialogFragment {
    private static final String ARG_TRAVEL = "travel";
    DriverAcceptedCardAdapter driversAdapter;
    DialogRequestServiceBinding binding;
    Travel travel;
    EventBus eventBus;

    public static DriverAcceptedDialog newInstance(Travel travel) {
        DriverAcceptedDialog driverAcceptedDialog = new DriverAcceptedDialog();
        Bundle args = new Bundle();
        args.putString(ARG_TRAVEL, travel.toJson());
        driverAcceptedDialog.setArguments(args);
        return driverAcceptedDialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null)
            travel = Travel.fromJson(getArguments().getString(ARG_TRAVEL));
        else {
            AlertDialogBuilder.show(getContext(),"Can't show driver's dialog without having travel info passed into.");
            dismiss();
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DialogRequestServiceBinding.inflate(inflater,container,false);
        binding.frameLayout.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
        driversAdapter = new DriverAcceptedCardAdapter(getContext());
        binding.swipeStack.setAdapter(driversAdapter);
        return binding.getRoot();
    }
    @Override
    public void onStart() {
        super.onStart();
        eventBus = EventBus.getDefault();
        eventBus.register(this);
        MainActivity parent = ((MainActivity)getActivity());
        eventBus.post(new ServiceRequestEvent(travel.getPickupPoint(), travel.getDestinationPoint(), travel.getPickupAddress(), travel.getDestinationAddress(), parent.selectedService.getId()));
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onServiceRequestResult(ServiceRequestResultEvent event) {
        if (event.hasError()) {
            event.showAlert(getContext());
            dismiss();
            return;
        }
        binding.textLoading.setText(getString(R.string.waiting_for_drivers, String.valueOf(event.driversSentTo)));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDriverAccepted(NewDriverAcceptedEvent event) {
        binding.driversAcceptedLoadingAnimation.pauseAnimation();
        binding.driversAcceptedCard.setVisibility(View.GONE);
        try {
            driversAdapter.addDriver(event.info);
            driversAdapter.notifyDataSetChanged();
        } catch (Exception ignored) {
        }
    }

    @Override
    public void onStop() {
        eventBus.unregister(this);
        super.onStop();
    }
}
