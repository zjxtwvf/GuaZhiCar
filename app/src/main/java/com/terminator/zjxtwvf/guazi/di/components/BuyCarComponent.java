package com.terminator.zjxtwvf.guazi.di.components;

import com.terminator.zjxtwvf.guazi.di.modules.BuyCarModule;
import com.terminator.zjxtwvf.guazi.di.scope.UserScope;
import com.terminator.zjxtwvf.guazi.view.fragment.BuyCarFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/24.
 */


@UserScope
@Component(modules = BuyCarModule.class,dependencies = NetComponent.class)
public interface BuyCarComponent {
    void Inject(BuyCarFragment sellCarFragment);
}
