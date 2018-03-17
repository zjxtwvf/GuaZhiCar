package com.terminator.zjxtwvf.guazi.presenter;

import com.orhanobut.logger.Logger;
import com.terminator.zjxtwvf.guazi.model.api.ApiService;
import com.terminator.zjxtwvf.guazi.model.entity.CarListEntity;
import com.terminator.zjxtwvf.guazi.model.entity.SellDetailInfoEntity;
import com.terminator.zjxtwvf.guazi.model.entity.SellRecordsEntity;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/24.
 */

public class BuyCarPresenter implements BuyCarContract.Presenter{

    ApiService mApiService;
    BuyCarContract.View mView;

    @Inject
    BuyCarPresenter(BuyCarContract.View view , ApiService apiService){
        mView = view;
        mApiService = apiService;
    }


    ///clientc/selldetail/records?screenWH=1080X1920&platform=armeabi-v7a&osv=7.0&
    /// deviceId=862007036501106&ca_n=meizu&sign=2262cc25d91b2d2fb1bb17508a3051df&dpi=3.0&
    /// customerId=879&mac=a4:44:d1:41:f3:14&guazi_city=45&versionId=3.9.6.0&model=m3%20note&ca_s=app_tg
    @Override
    public void getSellRecords() {
        mApiService.getSellRecords("1080X1920","armeabi-v7a","7.0",
                "862007036501106","meizu", "2262cc25d91b2d2fb1bb17508a3051df",
                "3.0","879","a4:44:d1:41:f3:14",
                "45","3.9.6.0","m3 note",
                "app_tg")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SellRecordsEntity>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("getSellRecords onCompleted------------->");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.d("getSellRecords onError------------->");
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(SellRecordsEntity sellRecordsEntity) {
                        Logger.d("getSellRecords onNext------------->");
                        mView.onDisplaySellRecords(sellRecordsEntity);
                    }
                });
    }

    ///clientc/selldetail/sellDetalInfo?city_id=45&screenWH=1080X1920&platform=armeabi-v7a&osv=7.0&
    /// deviceId=862007036501106&ca_n=meizu&sign=66f15ddba76d11fadb4c63da0b3ba0aa&dpi=3.0&
    /// customerId=879&mac=a4:44:d1:41:f3:14&guazi_city=45&versionId=3.9.6.0&model=m3%20note&ca_s=app_tg
    @Override
    public void getSelldetailInfo() {
        mApiService.getSelldetailInfo("45","1080X1920","armeabi-v7a","7.0"
            ,"862007036501106","meizu","66f15ddba76d11fadb4c63da0b3ba0aa","3.0",
                "879","a4:44:d1:41:f3:14","45","3.9.6.0","m3 note"
            ,"app_tg")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SellDetailInfoEntity>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("getSelldetailInfo onCompleted------------->");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.d("getSelldetailInfo onError------------->");
                        e.printStackTrace();
                    }
                    @Override
                    public void onNext(SellDetailInfoEntity sellDetailInfoEntity) {
                        Logger.d("getSelldetailInfo onNext------------->");
                        mView.onDisplaySelldetailInfo(sellDetailInfoEntity);
                    }
                });
    }
}
