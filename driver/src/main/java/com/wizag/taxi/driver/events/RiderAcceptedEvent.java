package com.wizag.taxi.driver.events;

import com.wizag.taxi.common.models.Travel;

public class RiderAcceptedEvent {
    public Travel travel;

    public RiderAcceptedEvent(Object... args) {
        this.travel = Travel.fromJson(args[0].toString());
    }
}
