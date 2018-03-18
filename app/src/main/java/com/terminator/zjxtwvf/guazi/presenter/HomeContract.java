package com.terminator.zjxtwvf.guazi.presenter;

import com.terminator.zjxtwvf.guazi.model.entity.BannerImageUrlEntity;
import com.terminator.zjxtwvf.guazi.model.entity.FastIndexEntity;
import com.terminator.zjxtwvf.guazi.model.entity.HomeEntity;
import com.terminator.zjxtwvf.guazi.model.entity.TopicEntity;
import com.terminator.zjxtwvf.guazi.view.widget.LoadingPage;

import java.util.List;

/**
 * Created by Administrator on 2017/12/24.
 */

public interface HomeContract {

    interface Presenter{
        void getBanner();
        void getFastIndex();
        void getHomeCar();
        void getHomeTopic();
    }

    interface View{
        void onDisplayBanner(List<BannerImageUrlEntity.DataBean> dataBeans);
        void onDisplayFastIndex(FastIndexEntity fastIndexEntity);
        void onDisplayHomeCar(HomeEntity homeEntity);
        void onDisplayHomeTopic(TopicEntity topicEntity);

        void onUpdateLoadingPage(LoadingPage.ResultState resultState);
    }
}
