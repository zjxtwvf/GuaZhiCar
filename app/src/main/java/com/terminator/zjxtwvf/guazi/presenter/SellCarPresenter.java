package com.terminator.zjxtwvf.guazi.presenter;

import com.orhanobut.logger.Logger;
import com.terminator.zjxtwvf.guazi.model.api.ApiService;
import com.terminator.zjxtwvf.guazi.model.entity.CarListEntity;
import com.terminator.zjxtwvf.guazi.view.widget.LoadingPage;


import javax.inject.Inject;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/24.
 */

public class SellCarPresenter implements SellCarContract.Presenter{

    ApiService mApiService;
    SellCarContract.View mView;

    @Inject
    SellCarPresenter(SellCarContract.View view , ApiService apiService){
        mView = view;
        mApiService = apiService;
    }

    ///clientc/post/getCarList?last_time=1515296982&lat=30.704263&page=1&lng=104.017556&pageSize=20&city=45
    /// &screenWH=1080X1920&platform=armeabi-v7a&osv=7.0&deviceId=862007036501106&ca_n=meizu&sign=8354b640c73730bb1182dc2d462a0f8a
    /// &dpi=3.0&customerId=879&mac=a4:44:d1:41:f3:14&guazi_city=45&versionId=3.9.6.0&model=m3%20note&ca_s=app_tg
    @Override
    public void getCarList() {
        mApiService.getCarList("1515296982","30.704263","1",
                "104.017556","20", "45","1080X1920","armeabi-v7a","7.0",
                "862007036501106","meizu","8354b640c73730bb1182dc2d462a0f8a",
                "3.0","879","a4:44:d1:41:f3:14","45",
                "3.9.6.0","m3 note","app_tg")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CarListEntity>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("getCarList onCompleted------------->");
                        mView.onUpdateLoadingPage(LoadingPage.ResultState.STATE_SUCCESS);
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.d("getCarList onError------------->");
                        mView.onUpdateLoadingPage(LoadingPage.ResultState.STATE_ERROR);
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(CarListEntity carListEntity) {
                        Logger.d("getCarList onNext------------->");
                        mView.onDisplayCarList(carListEntity);
                    }
                });
    }

    @Override
    public void loadMoreData() {
        // GET /clientc/post/getCarList?last_time=1521956542&lat=30.704457&page=2&lng=104.017312&
        // pageSize=20&city=45&screenWH=1080X1920&platform=armeabi-v7a&osv=7.0&deviceId=862007036501106&
        // ca_n=meizu&sign=9ec80cb03425b8666438abae29bf6993&dpi=3.0&customerId=879&mac=a4:44:d1:41:f3:14&
        // guazi_city=45&versionId=3.9.6.0&model=m3%20note&ca_s=app_tg
        mApiService.getCarList("1521956542","30.704457","2",
                "104.017312","20", "45","1080X1920","armeabi-v7a","7.0",
                "862007036501106","meizu","9ec80cb03425b8666438abae29bf6993",
                "3.0","879","a4:44:d1:41:f3:14","45",
                "3.9.6.0","m3 note","app_tg")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CarListEntity>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("getCarList onCompleted------------->");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.d("getCarList onError------------->");
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(CarListEntity carListEntity) {
                        Logger.d("getCarList onNext------------->");
                        mView.onLoadMoreData(carListEntity);
                    }
                });
    }
}
