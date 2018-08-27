package com.wizag.taxi.driver.activities.main.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.wizag.taxi.common.models.Request;
import com.wizag.taxi.driver.activities.main.fragments.RequestCardFragment;
import com.wizag.taxi.common.ui.ArrayFragmentPagerAdapter;

import java.util.ArrayList;

public class RequestsFragmentPagerAdapter extends ArrayFragmentPagerAdapter<Request> {
    public RequestsFragmentPagerAdapter(FragmentManager fm, ArrayList<Request> requests) {
        super(fm,requests);
    }

    @Override
    public Fragment getFragment(Request item, int position) {
        return RequestCardFragment.newInstance(item);
    }
}