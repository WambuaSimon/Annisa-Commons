package com.wizag.taxi.rider.events;

import com.wizag.taxi.common.events.BaseResultEvent;

public class ReviewDriverResultEvent extends BaseResultEvent {
    public ReviewDriverResultEvent(int response) {
        super(response);
    }
}
