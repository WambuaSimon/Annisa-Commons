package com.wizag.taxi.driver.events;

import com.wizag.taxi.common.models.Travel;

public class SendTravelInfoEvent {
    public Travel travel;
    public SendTravelInfoEvent(Travel travel) {
        this.travel = travel;
    }
}
