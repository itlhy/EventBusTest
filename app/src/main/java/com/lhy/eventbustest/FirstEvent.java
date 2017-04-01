package com.lhy.eventbustest;

/**
 * Created by lhy on 2017/3/18.
 */

public class FirstEvent {
    private String mMsg;

    public FirstEvent(String msg) {
        mMsg = msg;
    }

    public String getMsg() {
        return mMsg;
    }
}
