package com.terminator.zjxtwvf.guazi.presenter;

import com.terminator.zjxtwvf.guazi.model.entity.SourceDetailEntity;

/**
 * Created by Administrator on 2017/12/24.
 */

public interface SourceDetailContract {

    interface Presenter{
        void getSourceDetail();
    }

    interface View{
        void onDisplaySourceDetail(SourceDetailEntity sourceDetailEntity);
    }
}
