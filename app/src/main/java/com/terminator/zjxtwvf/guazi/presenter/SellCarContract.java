package com.terminator.zjxtwvf.guazi.presenter;

import com.terminator.zjxtwvf.guazi.model.entity.BannerAdsEntity;
import com.terminator.zjxtwvf.guazi.model.entity.CarListEntity;
import com.terminator.zjxtwvf.guazi.view.widget.LoadingPage;

/**
 * Created by Administrator on 2017/12/24.
 */

public interface SellCarContract {

    interface Presenter{
        void getCarList();
        void getBannerAds();
        void loadMoreData();
        void loadRereshData();
    }

    interface View{
        void onLoadMoreData(CarListEntity carListEntity);
        void onDisplayBannerAds(BannerAdsEntity bannerAdsEntity);
        void onDisplayCarList(CarListEntity carListEntity);
        void onUpdateLoadingPage(LoadingPage.ResultState resultState);
        void onLoadRereshData(CarListEntity carListEntity);
    }
}
