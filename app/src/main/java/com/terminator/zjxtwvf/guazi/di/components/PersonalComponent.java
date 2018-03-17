package com.terminator.zjxtwvf.guazi.di.components;

import com.terminator.zjxtwvf.guazi.di.modules.PersonalModule;
import com.terminator.zjxtwvf.guazi.di.scope.UserScope;
import com.terminator.zjxtwvf.guazi.view.fragment.PersenalFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/24.
 */


@UserScope
@Component(modules = PersonalModule.class,dependencies = NetComponent.class)
public interface PersonalComponent {
    void Inject(PersenalFragment persenalFragment);
}
