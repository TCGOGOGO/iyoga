package com.asiainfo.iyoga.bean;

import com.asiainfo.iyoga.common.StringScript;

import java.sql.*;

/**
 * Created by tcgogogo on 16/8/9.
 */
public class Member {
    //private int id;
    private static String name;
    private static String address;
    private static String job;

    public  Member(String name, String address, String job) {
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
