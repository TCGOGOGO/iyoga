package com.asiainfo.iyoga.common;

/**
 * Created by tcgogogo on 16/8/10.
 */
public class StringScript {

    public static String changeIdFormat(int number) {
        StringBuilder result = new StringBuilder();
        if(number < 10) {
            result.append("00").append(String.valueOf(number));
        }
        else if(number < 100) {
            result.append("0").append(String.valueOf(number));
        }
        else {
            result.append(String.valueOf(number));
        }
        return result.toString();
    }
}
