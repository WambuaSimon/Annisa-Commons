package com.wizag.taxi.rider.activities.main.adapters;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.wizag.taxi.common.models.ServiceCategory;
import com.wizag.taxi.rider.activities.main.fragments.ServiceCarousalFragment;

import java.util.ArrayList;

public class ServiceCategoryViewPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<ServiceCategory> list;

    public ServiceCategoryViewPagerAdapter(FragmentManager manager, ArrayList<ServiceCategory> list) {
        super(manager);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return ServiceCarousalFragment.newInstance(list.get(position).getServices());
    }

    public void setItems(ArrayList<ServiceCategory> list){
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getCatTitle();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}