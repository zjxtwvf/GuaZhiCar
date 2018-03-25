package com.terminator.zjxtwvf.guazi.model.entity;

/**
 * Created by Administrator on 2018/3/25.
 */

public class FragmentEvent {

    public static final int FRAGMENT_HOME_ID = 0;
    public static final int FRAGMENT_SELL_ID = 1;
    public static final int FRAGMENT_BUY_ID = 2;
    public static final int FRAGMENT_ME_ID = 3;


    int message;

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public FragmentEvent(int message){
        this.message = message;
    }
}
