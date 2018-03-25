package com.terminator.zjxtwvf.guazi.presenter;

import com.terminator.zjxtwvf.guazi.model.entity.BannerImageUrlEntity;
import com.terminator.zjxtwvf.guazi.model.entity.CarListEntity;
import com.terminator.zjxtwvf.guazi.model.entity.FastIndexEntity;
import com.terminator.zjxtwvf.guazi.model.entity.HomeEntity;
import com.terminator.zjxtwvf.guazi.model.entity.TopicEntity;
import com.terminator.zjxtwvf.guazi.view.widget.LoadingPage;

import java.util.List;

/**
 * Created by Administrator on 2017/12/24.
 */

public interface SellCarContract {

    interface Presenter{
        void getCarList();
        void loadMoreData();
    }

    interface View{
        void onLoadMoreData(CarListEntity carListEntity);
        void onDisplayCarList(CarListEntity carListEntity);
        void onUpdateLoadingPage(LoadingPage.ResultState resultState);
    }
}
