package com.alex.watchlist.model.request;

public class MessageRequest {
    private String from;
    private String text;
    private String time;

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

    public String getFrom() {
        return from;
    }
}
