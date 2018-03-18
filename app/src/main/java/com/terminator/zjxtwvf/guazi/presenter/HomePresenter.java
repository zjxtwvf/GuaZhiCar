package com.terminator.zjxtwvf.guazi.presenter;

import com.orhanobut.logger.Logger;
import com.terminator.zjxtwvf.guazi.model.api.ApiService;
import com.terminator.zjxtwvf.guazi.model.entity.BannerImageUrlEntity;
import com.terminator.zjxtwvf.guazi.model.entity.FastIndexEntity;
import com.terminator.zjxtwvf.guazi.model.entity.HomeEntity;
import com.terminator.zjxtwvf.guazi.model.entity.TopicEntity;
import com.terminator.zjxtwvf.guazi.view.widget.LoadingPage;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/24.
 */

public class HomePresenter implements HomeContract.Presenter{

    ApiService mApiService;
    HomeContract.View mView;

    @Inject
    HomePresenter(HomeContract.View view ,ApiService apiService){
        mView = view;
        mApiService = apiService;
    }

    @Override
    public void getBanner() {
        mApiService.getBannerImageUrl("-1","1080X1920","armeabi-v7a","7.0",
                "862007036501106","meizu","a21c3e59b37b7fe138cf5d4878f4bd1f",
                "3.0","879","a4:44:d1:41:f3:14","-1",
                "3.9.1.0","m3 note","app_tg")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BannerImageUrlEntity>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("getBannerImageUrl onCompleted------------->");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.d("getBannerImageUrl onError------------->");
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(BannerImageUrlEntity bannerImageUrlEntity) {
                        Logger.d("getBannerImageUrl onNext------------->");
                        mView.onDisplayBanner(bannerImageUrlEntity.getData());
                    }
                });
    }

    @Override
    public void getFastIndex() {
        mApiService.getFastIndex("45","1080X1920","armeabi-v7a","7.0",
                "862007036501106","meizu","a477bfa17161cf1fa64cbf76ea531ad1",
                "3.0","879","a4:44:d1:41:f3:14","45",
                "3.9.6.0","m3 note","app_tg")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FastIndexEntity>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("getFastIndex onCompleted------------->");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.d("getFastIndex onError------------->");
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(FastIndexEntity fastIndexEntity) {
                        Logger.d("getFastIndex onNext------------->");
                        mView.onDisplayFastIndex(fastIndexEntity);
                    }
                });
    }

    @Override
    public void getHomeCar() {
        mApiService.getHomeCar("-1","1080X1920","armeabi-v7a","7.0",
                "862007036501106","meizu","a21c3e59b37b7fe138cf5d4878f4bd1f",
                "3.0","879","a4:44:d1:41:f3:14","-1",
                "3.9.1.0","m3 note","app_tg")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HomeEntity>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("getHomeCar onCompleted------------->");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.d("getHomeCar onError------------->");
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(HomeEntity homeEntity) {
                        Logger.d("getHomeCar onNext------------->");
                        mView.onDisplayHomeCar(homeEntity);
                    }
                });
    }

    @Override
    public void getHomeTopic() {
        mApiService.getToplineorschool("-1","1080X1920","armeabi-v7a","7.0",
                "862007036501106","meizu","a21c3e59b37b7fe138cf5d4878f4bd1f",
                "3.0","879","a4:44:d1:41:f3:14","-1",
                "3.9.1.0","m3 note","app_tg")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TopicEntity>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("getHomeTopic onCompleted------------->");
                        mView.onUpdateLoadingPage(LoadingPage.ResultState.STATE_SUCCESS);
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.d("getHomeCar onError------------->");
                        e.printStackTrace();
                        mView.onUpdateLoadingPage(LoadingPage.ResultState.STATE_ERROR);
                    }
                    @Override
                    public void onNext(TopicEntity topicEntity) {
                        Logger.d("getHomeTopic onNext------------->");
                        mView.onDisplayHomeTopic(topicEntity);
                    }
                });
    }
}
