package com.terminator.zjxtwvf.guazi.di.components;

import com.terminator.zjxtwvf.guazi.di.modules.HomeModule;
import com.terminator.zjxtwvf.guazi.di.scope.UserScope;
import com.terminator.zjxtwvf.guazi.view.activity.HomeActivity;
import com.terminator.zjxtwvf.guazi.view.fragment.HomeFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/24.
 */


@UserScope
@Component(modules = HomeModule.class,dependencies = NetComponent.class)
public interface HomeComponent {
    void Inject(HomeFragment homeFragment);
}
