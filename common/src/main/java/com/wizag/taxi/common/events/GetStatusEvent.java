package com.wizag.taxi.common.events;

import com.wizag.taxi.common.utils.ServerResponse;

public class GetStatusEvent extends BaseRequestEvent {
    public GetStatusEvent() {
        super(new GetStatusResultEvent(ServerResponse.REQUEST_TIMEOUT));
    }
}
