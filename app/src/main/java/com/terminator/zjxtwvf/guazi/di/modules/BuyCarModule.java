package com.terminator.zjxtwvf.guazi.di.modules;

import com.terminator.zjxtwvf.guazi.presenter.BuyCarContract;
import com.terminator.zjxtwvf.guazi.presenter.SellCarContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/12/24.
 */


@Module
public class BuyCarModule {

    BuyCarContract.View mView;

    public BuyCarModule(BuyCarContract.View view){
        mView = view;
    }

    @Provides
    public BuyCarContract.View provideView(){
        return mView;
    }
}
