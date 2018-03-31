package com.terminator.zjxtwvf.guazi.presenter;

/**
 * Created by Administrator on 2017/12/3.
 */

public interface SplashContract {
    interface  Presenter{
        void getSplash();
    }

    interface View{
        void onDisplay(String url);
        void onGetSplashError();
    }
}
