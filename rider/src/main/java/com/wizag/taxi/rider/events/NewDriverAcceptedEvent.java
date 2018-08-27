package com.wizag.taxi.rider.events;

import com.google.gson.Gson;
import com.wizag.taxi.common.models.Driver;
import com.wizag.taxi.common.models.DriverInfo;

public class NewDriverAcceptedEvent {
    public DriverInfo info;
    public NewDriverAcceptedEvent(String json,int distance, int duration, Double cost){
        this.info = new DriverInfo(new Gson().fromJson(json,Driver.class),distance,duration,cost);
    }
}
