package com.terminator.zjxtwvf.guazi.di.components;

import com.terminator.zjxtwvf.guazi.di.modules.SellCarModule;
import com.terminator.zjxtwvf.guazi.di.scope.UserScope;
import com.terminator.zjxtwvf.guazi.view.fragment.SellCarFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/24.
 */


@UserScope
@Component(modules = SellCarModule.class,dependencies = NetComponent.class)
public interface SellCarComponent {
    void Inject(SellCarFragment sellCarFragment);
}
