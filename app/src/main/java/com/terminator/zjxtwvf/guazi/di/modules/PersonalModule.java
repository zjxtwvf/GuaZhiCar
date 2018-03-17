package com.terminator.zjxtwvf.guazi.di.modules;

import com.terminator.zjxtwvf.guazi.presenter.PersonalContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/12/24.
 */


@Module
public class PersonalModule {

    PersonalContract.View mView;

    public PersonalModule(PersonalContract.View view){
        mView = view;
    }

    @Provides
    public PersonalContract.View provideView(){
        return mView;
    }
}
