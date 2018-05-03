package com.terminator.zjxtwvf.guazi.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
import butterknife.OnClick;

public class SplashActivity extends AppCompatActivity implements SplashContract.View{
    @Bind(R.id.iv_splash)
    ImageView imageView;
    @Bind(R.id.tv_splash_skip)
    TextView mSkip;
    @Bind(R.id.tv_splash_time)
    TextView mDelay;
    @Bind(R.id.tv_splash_more)
    TextView mKownMore;
    @Bind(R.id.ll_splash_skip)
    LinearLayout mLlDelaySkip;

    @Inject
    SplashPresenter splashPresenter;


    private  int delay = 2;

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
        delayGetSplash();
    }

    public void delayGetSplash(){
        splashPresenter.getSplash();
    }

    @Override
    public void onDisplay(String url) {
        if(url != null && !url.equals("")){
            BitmapCacheUtils.getInstance().display(imageView,url);
            mLlDelaySkip.setVisibility(View.VISIBLE);
            mKownMore.setVisibility(View.VISIBLE);
            MyApplication.getHandler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mDelay.setText("剩余"+delay+"秒");
                    delay--;
                    if(delay < 0){
                        onGetSplashError();
                    }else{
                        MyApplication.getHandler().postDelayed(this,1000);
                    }
                }
            },1000);
        }else{
            onGetSplashError();
        }
    }

    @Override
    public void onGetSplashError() {
        Intent intent = new Intent(SplashActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick({R.id.tv_splash_skip})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.tv_splash_skip:
                MyApplication.getHandler().removeCallbacksAndMessages(null);
                onGetSplashError();
                break;
        }
    }
}
