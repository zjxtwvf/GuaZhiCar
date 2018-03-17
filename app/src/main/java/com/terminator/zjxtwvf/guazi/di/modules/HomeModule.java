package com.terminator.zjxtwvf.guazi.di.modules;

import com.terminator.zjxtwvf.guazi.presenter.HomeContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/12/24.
 */


@Module
public class HomeModule {

    HomeContract.View mView;

    public HomeModule(HomeContract.View view){
        mView = view;
    }

    @Provides
    public HomeContract.View provideView(){
        return mView;
    }
}
