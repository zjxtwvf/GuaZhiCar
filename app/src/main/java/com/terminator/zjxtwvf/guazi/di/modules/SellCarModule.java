package com.terminator.zjxtwvf.guazi.di.modules;

import com.terminator.zjxtwvf.guazi.presenter.SellCarContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/12/24.
 */


@Module
public class SellCarModule {

    SellCarContract.View mView;

    public SellCarModule(SellCarContract.View view){
        mView = view;
    }

    @Provides
    public SellCarContract.View provideView(){
        return mView;
    }
}
