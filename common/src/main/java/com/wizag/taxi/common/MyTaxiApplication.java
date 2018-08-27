package com.wizag.taxi.common;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatDelegate;

import com.google.firebase.FirebaseApp;
import com.wizag.taxi.common.utils.LocaleHelper;

public class MyTaxiApplication extends Application {
    @Override
    public void onCreate() {
        FirebaseApp.initializeApp(getApplicationContext());
        int nightMode = AppCompatDelegate.MODE_NIGHT_NO;
        AppCompatDelegate.setDefaultNightMode(nightMode);
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        LocaleHelper.setLocale(base,"en");
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
        MultiDex.install(this);
    }
}