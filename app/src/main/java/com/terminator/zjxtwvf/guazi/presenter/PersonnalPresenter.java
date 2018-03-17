package com.terminator.zjxtwvf.guazi.presenter;

import com.orhanobut.logger.Logger;
import com.terminator.zjxtwvf.guazi.model.api.ApiService;
import com.terminator.zjxtwvf.guazi.model.entity.BannerImageUrlEntity;
import com.terminator.zjxtwvf.guazi.model.entity.PersonalCenterEntity;
import com.terminator.zjxtwvf.guazi.model.entity.RecommendEntity;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/24.
 */

public class PersonnalPresenter implements PersonalContract.Presenter{

    ApiService mApiService;
    PersonalContract.View mView;

    @Inject
    PersonnalPresenter(PersonalContract.View view , ApiService apiService){
        mView = view;
        mApiService = apiService;
    }

    ///clientc/personal/personalCenter?cityId=45&screenWH=1080X1920&platform=armeabi-v7a&osv=7.0&
    /// deviceId=862007036501106&ca_n=meizu&sign=fa7e8b9d7526739f8a956ae5f0021bf2&dpi=3.0&
    /// customerId=879&mac=a4:44:d1:41:f3:14&guazi_city=45&versionId=3.9.6.0&model=m3%20note&ca_s=app_tg
    @Override
    public void getPersonalCenter() {
        mApiService.getPersonalCenter("45","1080X1920","armeabi-v7a","7.0",
                "862007036501106","meizu","fa7e8b9d7526739f8a956ae5f0021bf2",
                "3.0","879","a4:44:d1:41:f3:14","45",
                "3.9.6.0","m3 note","app_tg")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PersonalCenterEntity>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("getPersonalCenter onCompleted------------->");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.d("getPersonalCenter onError------------->");
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(PersonalCenterEntity personalCenterEntity) {
                        Logger.d("getPersonalCenter onNext------------->");
                        mView.onDisplayPersonalCenter(personalCenterEntity);
                    }
                });
    }

    ///clientc/recommend?city=45&screenWH=1080X1920&platform=armeabi-v7a&osv=7.0&deviceId=862007036501106&
    /// ca_n=meizu&sign=a477bfa17161cf1fa64cbf76ea531ad1&dpi=3.0&customerId=879&mac=a4:44:d1:41:f3:14&
    /// guazi_city=45&versionId=3.9.6.0&model=m3%20note&ca_s=app_tg
    @Override
    public void getRecommend() {
        mApiService.getRecommend("45","1080X1920","armeabi-v7a","7.0",
                "862007036501106","meizu","a477bfa17161cf1fa64cbf76ea531ad1",
                "3.0","879","a4:44:d1:41:f3:14","45",
                "3.9.6.0","m3 note","app_tg")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RecommendEntity>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("getRecommend onCompleted------------->");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.d("getRecommend onError------------->");
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(RecommendEntity recommendEntity) {
                        Logger.d("getRecommend onNext------------->");
                        mView.onDisplayRecommend(recommendEntity);
                    }
                });
    }
}
