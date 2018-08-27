package com.wizag.taxi.driver.events;

import com.wizag.taxi.common.events.BaseRequestEvent;
import com.wizag.taxi.common.utils.ServerResponse;

public class ChangeHeaderImageEvent extends BaseRequestEvent {
    public String path;
    public ChangeHeaderImageEvent(String path){
        super(new ChangeHeaderImageResultEvent(ServerResponse.REQUEST_TIMEOUT.getValue(),null));
        this.path = path;
    }
}
