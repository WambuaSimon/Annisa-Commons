package com.wizag.taxi.driver.events;

import com.google.gson.Gson;
import com.wizag.taxi.common.events.BaseResultEvent;
import com.wizag.taxi.common.models.Media;

public class ChangeHeaderImageResultEvent extends BaseResultEvent {
    public Media media;
    public ChangeHeaderImageResultEvent(int code, String media) {
        super(code);
        this.media = new Gson().fromJson(media,Media.class);
    }
}
