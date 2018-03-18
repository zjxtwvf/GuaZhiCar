package com.terminator.zjxtwvf.guazi.presenter;

import com.terminator.zjxtwvf.guazi.model.entity.SourceDetailEntity;
import com.terminator.zjxtwvf.guazi.view.widget.LoadingPage;

/**
 * Created by Administrator on 2017/12/24.
 */

public interface SourceDetailContract {

    interface Presenter{
        void getSourceDetail();
    }

    interface View{
        void onDisplaySourceDetail(SourceDetailEntity sourceDetailEntity);
        void onUpdateLoadingPage(LoadingPage.ResultState resultState);
    }
}
