package com.wizag.taxi.driver.events;

import com.wizag.taxi.common.events.BaseResultEvent;

public class ChangeStatusResultEvent extends BaseResultEvent {
    public ChangeStatusResultEvent(int code) {
        super(code);
    }
}
