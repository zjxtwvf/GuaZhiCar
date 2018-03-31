package com.terminator.zjxtwvf.guazi.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.terminator.zjxtwvf.guazi.R;
import com.terminator.zjxtwvf.guazi.app.MyApplication;
import com.terminator.zjxtwvf.guazi.di.components.DaggerSplashComponent;
import com.terminator.zjxtwvf.guazi.di.modules.SplashModule;
import com.terminator.zjxtwvf.guazi.presenter.SplashContract;
import com.terminator.zjxtwvf.guazi.presenter.SplashPresenter;
import com.terminator.zjxtwvf.guazi.util.BitmapCacheUtils;

import javax.inject.Inject;
import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity implements SplashContract.View{
    @Bind(R.id.iv_splash)
    ImageView imageView;
    @Inject
    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerSplashComponent.builder()
                .netComponent(MyApplication.getContext().getNetComponent())
                .splashModule(new SplashModule(this))
                .build()
                .inject(this);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(SplashActivity.this);
        splashPresenter.getSplash();
    }

    @Override
    public void onDisplay(String url) {
        long time = 0;
        if(url != null && !url.equals("")){
            BitmapCacheUtils.getInstance().display(imageView,url);
            time = 2000;
        }else{
            time = 0;
        }

        MyApplication.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //无论能否加载SPLASH图片，都进入主页面
                Intent intent = new Intent(SplashActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },time);
    }

    @Override
    public void onGetSplashError() {
        Intent intent = new Intent(SplashActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
