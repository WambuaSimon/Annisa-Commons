package com.wizag.taxi.common.events;

import com.wizag.taxi.common.utils.ServerResponse;

public class ServiceCancelEvent extends BaseRequestEvent {
    public ServiceCancelEvent(){
        super(new ServiceCallRequestResultEvent(ServerResponse.REQUEST_TIMEOUT.getValue()));

    }
}
