package com.terminator.zjxtwvf.guazi.presenter;

import com.orhanobut.logger.Logger;
import com.terminator.zjxtwvf.guazi.model.api.ApiService;
import com.terminator.zjxtwvf.guazi.model.entity.SourceDetailEntity;
import com.terminator.zjxtwvf.guazi.view.widget.LoadingPage;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/24.
 */

public class SourceDetailPresenter implements SourceDetailContract.Presenter{

    ApiService mApiService;
    SourceDetailContract.View mView;

    @Inject
    SourceDetailPresenter(SourceDetailContract.View view , ApiService apiService){
        mView = view;
        mApiService = apiService;
    }

    ///clientc/post/getSourceDetail?puid=3002889995&lat=30.704434&lng=104.017464&screenWH=1080X1920
    /// &platform=armeabi-v7a&osv=7.0&deviceId=862007036501106&ca_n=meizu&sign=3beea967e88121487b78516addba72be
    /// &dpi=3.0&customerId=879&mac=a4:44:d1:41:f3:14&guazi_city=45&versionId=4.0.2.0&model=m3%20note&ca_s=app_tg

    //GET /clientc/post/getSourceDetail?puid=3003958625&lat=30.704536&lng=104.017556&screenWH=1080X1920&
    // platform=armeabi-v7a&osv=7.0&deviceId=862007036501106&ca_n=meizu&sign=3796c5942707a286ae02f424fc8021cd&
    // dpi=3.0&customerId=879&mac=a4:44:d1:41:f3:14&guazi_city=45&versionId=3.9.6.0&model=m3%20note&ca_s=app_tg
    @Override
    public void getSourceDetail() {
        mApiService.getSourceDetail("3003958625","30.704536","104.017556",
                "1080X1920","armeabi-v7a","7.0",
                "862007036501106","meizu","3796c5942707a286ae02f424fc8021cd",
                "3.0","879","a4:44:d1:41:f3:14","45",
                "3.9.6.0","m3 note","app_tg")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SourceDetailEntity>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("getSourceDetail onCompleted------------->");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.d("getSourceDetail onError------------->");
                        mView.onUpdateLoadingPage(LoadingPage.ResultState.STATE_ERROR);
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(SourceDetailEntity sourceDetailEntity) {
                        Logger.d("getSourceDetail onNext------------->");
                        mView.onUpdateLoadingPage(LoadingPage.ResultState.STATE_SUCCESS);
                        mView.onDisplaySourceDetail(sourceDetailEntity);
                    }
                });
        /*
        mApiService.getSourceDetail("3002889995","30.704434","104.017464",
                "1080X1920","armeabi-v7a","7.0",
                "862007036501106","meizu","3beea967e88121487b78516addba72be",
                "3.0","879","a4:44:d1:41:f3:14","45",
                "4.0.2.0","m3 note","app_tg")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SourceDetailEntity>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("getSourceDetail onCompleted------------->");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.d("getSourceDetail onError------------->");
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(SourceDetailEntity sourceDetailEntity) {
                        Logger.d("getSourceDetail onNext------------->");
                        mView.onDisplaySourceDetail(sourceDetailEntity);
                    }
                });
                */
    }
}
