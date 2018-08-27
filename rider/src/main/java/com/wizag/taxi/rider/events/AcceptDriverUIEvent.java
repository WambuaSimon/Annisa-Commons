package com.wizag.taxi.rider.events;

import com.wizag.taxi.common.models.DriverInfo;

public class AcceptDriverUIEvent {
    public DriverInfo driverInfo;
    public AcceptDriverUIEvent(DriverInfo driverInfo){
        this.driverInfo = driverInfo;
    }
}
