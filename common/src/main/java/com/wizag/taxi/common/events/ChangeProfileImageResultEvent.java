package com.wizag.taxi.common.events;

import com.google.gson.Gson;
import com.wizag.taxi.common.models.Media;

public class ChangeProfileImageResultEvent extends BaseResultEvent {
    public Media media;

    public ChangeProfileImageResultEvent(int code, String media) {
        super(code);
        this.media = new Gson().fromJson(media,Media.class);
    }
}
