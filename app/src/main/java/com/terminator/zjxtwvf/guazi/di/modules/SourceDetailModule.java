package com.terminator.zjxtwvf.guazi.di.modules;

import com.terminator.zjxtwvf.guazi.presenter.SourceDetailContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/12/24.
 */


@Module
public class SourceDetailModule {

    SourceDetailContract.View mView;

    public SourceDetailModule(SourceDetailContract.View view){
        mView = view;
    }

    @Provides
    public SourceDetailContract.View provideView(){
        return mView;
    }
}
