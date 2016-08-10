package com.asiainfo.iyoga.bean;

/**
 * Created by tcgogogo on 16/8/9.
 */
public class Card {
    private String type;
    private String startTime;
    private String endTime;
    private int times;

    public Card(String type, String startTime, String endTime, int times) {
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.times = times;
    }

    public String getType() {
        return type;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getTimes() {
        return times;
    }
}
