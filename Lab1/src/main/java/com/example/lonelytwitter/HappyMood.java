package com.example.lonelytwitter;

import java.util.Date;

public class HappyMood extends Mood {

    private Date date;

    public HappyMood() {
        this.date = new Date();
    }

    public HappyMood(Date date) {
        this.date = date;
    }

    @Override
    public String getMoodString() {
        return "Happy";
    }

}
