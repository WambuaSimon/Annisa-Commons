package com.wizag.taxi.rider.events;

import com.wizag.taxi.common.events.BaseRequestEvent;
import com.wizag.taxi.common.models.Review;
import com.wizag.taxi.common.utils.ServerResponse;

public class ReviewDriverEvent extends BaseRequestEvent {
    public Review review;
    public ReviewDriverEvent(Review review){
        super(new ReviewDriverResultEvent(ServerResponse.REQUEST_TIMEOUT.getValue()));
        this.review = review;
    }
}
