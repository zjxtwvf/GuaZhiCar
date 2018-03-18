package com.terminator.zjxtwvf.guazi.presenter;

import com.terminator.zjxtwvf.guazi.model.entity.SellRecordsEntity;
import com.terminator.zjxtwvf.guazi.model.entity.SellDetailInfoEntity;
import com.terminator.zjxtwvf.guazi.view.widget.LoadingPage;

/**
 * Created by Administrator on 2017/12/24.
 */

public interface BuyCarContract {

    interface Presenter{
        void getSelldetailInfo();
        void getSellRecords();
    }

    interface View{
        void onDisplaySellRecords(SellRecordsEntity sellRecordsEntity);
        void onDisplaySelldetailInfo(SellDetailInfoEntity sellDetailInfoEntity);
        void onUpdateLoadingPage(LoadingPage.ResultState resultState);
    }
}
