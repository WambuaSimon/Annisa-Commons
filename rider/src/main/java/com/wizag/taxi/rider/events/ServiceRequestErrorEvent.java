package com.wizag.taxi.rider.events;

import com.wizag.taxi.common.events.BaseResultEvent;

public class ServiceRequestErrorEvent extends BaseResultEvent {
    public ServiceRequestErrorEvent(int response,String message) {
        super(response,message);
    }
    public ServiceRequestErrorEvent(int response) {
        super(response);
    }
}
