package com.terminator.zjxtwvf.guazi.presenter;

import com.terminator.zjxtwvf.guazi.model.entity.PersonalCenterEntity;
import com.terminator.zjxtwvf.guazi.model.entity.RecommendEntity;
import com.terminator.zjxtwvf.guazi.view.widget.LoadingPage;

/**
 * Created by Administrator on 2017/12/24.
 */

public interface PersonalContract {

    interface Presenter{
        void getPersonalCenter();
        void getRecommend();
    }

    interface View{
        void onDisplayPersonalCenter(PersonalCenterEntity personalCenterEntity);
        void onDisplayRecommend(RecommendEntity recommendEntity);
        void onUpdateLoadingPage(LoadingPage.ResultState resultState);
    }
}
