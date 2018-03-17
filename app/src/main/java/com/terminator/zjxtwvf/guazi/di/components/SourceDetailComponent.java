package com.terminator.zjxtwvf.guazi.di.components;

import com.terminator.zjxtwvf.guazi.di.modules.SourceDetailModule;
import com.terminator.zjxtwvf.guazi.di.scope.UserScope;
import com.terminator.zjxtwvf.guazi.view.activity.SourceDetailActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/24.
 */


@UserScope
@Component(modules = SourceDetailModule.class,dependencies = NetComponent.class)
public interface SourceDetailComponent {
    void Inject(SourceDetailActivity sourceDetailActivity);
}
