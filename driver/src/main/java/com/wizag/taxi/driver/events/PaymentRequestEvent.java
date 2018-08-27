package com.wizag.taxi.driver.events;

import com.wizag.taxi.common.events.BaseRequestEvent;
import com.wizag.taxi.common.utils.ServerResponse;

public class PaymentRequestEvent extends BaseRequestEvent {
    public PaymentRequestEvent() {
        super(new PaymentRequestResultEvent(ServerResponse.REQUEST_TIMEOUT.getValue()));
    }
}
