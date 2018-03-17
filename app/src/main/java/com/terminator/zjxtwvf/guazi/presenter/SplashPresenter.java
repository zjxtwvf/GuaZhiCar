package com.terminator.zjxtwvf.guazi.presenter;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.terminator.zjxtwvf.guazi.model.api.ApiService;
import com.terminator.zjxtwvf.guazi.model.entity.SplashEntity;
import com.terminator.zjxtwvf.guazi.model.entity.TrackingEntity;
import com.terminator.zjxtwvf.guazi.util.TrackingUtil;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/3.
 */

public class SplashPresenter implements SplashContract.Presenter{
    SplashContract.View view;
    private ApiService apiService;
    private Map<String,String> postBody = new HashMap<String, String>();

    @Inject
    public SplashPresenter(SplashContract.View view, ApiService apiService)
    {
        this.view = view;
        this.apiService = apiService;
    }

    //业务逻辑   获取Splash图片
    @Override
    public void getSplash() {
        TrackingEntity trackingEntity = new TrackingEntity();
        TrackingUtil.initWifiTrackingData(trackingEntity);
        Gson gson = new Gson();
        String trackingStr = gson.toJson(trackingEntity);
        RequestBody requestBody  = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),trackingStr);

        //doNext01();
        apiService.postBefore00GetSplash("https://t.guazi.com/tracking","1080X1920","armeabi-v7a",
                "7.0","862007036501106",
                "meizu","78cf2ea6fcefdadc9f7208e227dc296b","879","3.0","3.9.1.0","4g",
                "m3 note","app_tg",requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                        doNext01();
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(ResponseBody splashEntity) {
                        Logger.d("SplashEntity" + splashEntity.toString());
                        if(true){

                        }
                    }
                });

    }

    void doNext02(){
        apiService.getSplash("-1","1080X1920","armeabi-v7a","7.0",
                "862007036501106","meizu","a21c3e59b37b7fe138cf5d4878f4bd1f",
                "3.0","879","a4:44:d1:41:f3:14","-1",
                "3.9.1.0","m3 note","app_tg")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SplashEntity>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted------------->");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.d("doNext02 onError------------->");
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(SplashEntity splashEntity) {
                        view.onDisplay(splashEntity.getData().getImage());
                    }
                });
    }

    void doNext01(){
        String  model  = new String("m3 note");
        apiService.postBefore01GetSplash("1080X1920","armeabi-v7a","7.0",
                "862007036501106","meizu","17d140d78b009d173157b5bef37b5d7d",
                "3.0","879","a4:44:d1:41:f3:14","-1",
                "3.9.1.0",model,"app_tg")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<SplashEntity>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("doNext01 onCompleted------------->");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.d("doNext01 onError m3%20note------------->");
                        doNext02();
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(SplashEntity splashEntity) {
                        Logger.d("doNext01 onNext------------->");
                        doNext02();
                    }
                });
    }
}
