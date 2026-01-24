package com.example.lonelytwitter;

import java.util.Date;

public abstract class Tweet implements Tweetable {

    private Date date;
    private String message;

    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isImportant();

}
