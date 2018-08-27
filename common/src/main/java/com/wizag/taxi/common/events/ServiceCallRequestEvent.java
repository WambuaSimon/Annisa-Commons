package com.wizag.taxi.common.events;

import com.wizag.taxi.common.utils.ServerResponse;

public class ServiceCallRequestEvent extends BaseRequestEvent {
    public ServiceCallRequestEvent() {
        super(new ServiceCallRequestResultEvent(ServerResponse.REQUEST_TIMEOUT.getValue()));
    }
}
