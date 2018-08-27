package com.wizag.taxi.common.components;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import org.greenrobot.eventbus.EventBus;

public class BaseFragment extends Fragment {
    public EventBus eventBus;
    boolean registerEventBus = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (registerEventBus)
            eventBus = EventBus.getDefault();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (registerEventBus)
            eventBus.register(this);
    }

    @Override
    public void onStop() {
        if (registerEventBus)
            eventBus.unregister(this);
        super.onStop();
    }

    public void setRegisterEventBus(boolean registerEventBus) {
        this.registerEventBus = registerEventBus;
    }
}
