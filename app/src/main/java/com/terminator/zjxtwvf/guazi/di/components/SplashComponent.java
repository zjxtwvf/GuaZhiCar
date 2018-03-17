package com.terminator.zjxtwvf.guazi.di.components;

import com.terminator.zjxtwvf.guazi.di.modules.SplashModule;
import com.terminator.zjxtwvf.guazi.di.scope.UserScope;
import com.terminator.zjxtwvf.guazi.view.activity.SplashActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/5.
 */

@UserScope
@Component(modules = SplashModule.class,dependencies = NetComponent.class)
public interface SplashComponent {
    void inject(SplashActivity splashActivity);
}
