package com.wizag.taxi.driver.events;

import com.wizag.taxi.common.events.BaseResultEvent;

public class PaymentRequestResultEvent extends BaseResultEvent {
    public PaymentRequestResultEvent(int code) {
        super(code);
    }
}
