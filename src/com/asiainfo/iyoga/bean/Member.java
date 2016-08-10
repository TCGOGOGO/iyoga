package com.asiainfo.iyoga.bean;

/**
 * Created by tcgogogo on 16/8/9.
 */
public class Member {

    private String name;
    private String address;
    private String job;

    public Member(String name, String address, String job) {
        this.name = name;
        this.address = address;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getJob() {
        return job;
    }
}
