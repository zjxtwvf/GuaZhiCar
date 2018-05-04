package com.terminator.zjxtwvf.guazi.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.terminator.zjxtwvf.guazi.R;
import com.terminator.zjxtwvf.guazi.model.entity.FragmentEvent;
import com.terminator.zjxtwvf.guazi.util.UIUtils;
import com.terminator.zjxtwvf.guazi.view.adapter.HomeViewPagerAdapter;
import com.terminator.zjxtwvf.guazi.view.fragment.BaseFragment;
import com.terminator.zjxtwvf.guazi.view.fragment.BuyCarFragment;
import com.terminator.zjxtwvf.guazi.view.fragment.HomeFragment;
import com.terminator.zjxtwvf.guazi.view.fragment.PersenalFragment;
import com.terminator.zjxtwvf.guazi.view.fragment.SellCarFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/12/24.
 */

public class HomeActivity extends AppCompatActivity{

    List<BaseFragment> mFragments = new ArrayList<BaseFragment>();
    private long firstTime = 0;

    @Bind(R.id.banner_home_content)
    ViewPager mBanner;
    @Bind(R.id.tv_item_tab_home)
    TextView mTvTabHome;
    @Bind(R.id.tv_item_tab_sell_car)
    TextView mTvTabSellCar;
    @Bind(R.id.tv_item_tab_buy_car)
    TextView mTvTabBuyCar;
    @Bind(R.id.tv_item_tab_me)
    TextView mTvTabMe;
    @Bind(R.id.iv_item_tab_home)
    ImageView mIvTabHome;
    @Bind(R.id.iv_item_tab_sell_car)
    ImageView mIvTabSellCar;
    @Bind(R.id.iv_item_tab_buy_car)
    ImageView mIvTabBuyCar;
    @Bind(R.id.iv_item_tab_me)
    ImageView mIvTabMe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(HomeActivity.this);
        EventBus.getDefault().register(this);

        BaseFragment homeFragment = new HomeFragment();
        mFragments.add(homeFragment);
        BaseFragment sellCarFragment = new SellCarFragment();
        mFragments.add(sellCarFragment);
        BaseFragment buyCarFragment = new BuyCarFragment();
        mFragments.add(buyCarFragment);
        BaseFragment mInforFragment = new PersenalFragment();
        mFragments.add(mInforFragment);

        mBanner.setAdapter(new HomeViewPagerAdapter(getSupportFragmentManager(),mFragments));
        mBanner.setCurrentItem(0);
    }

    public void setTabsNormal(){
        mIvTabHome.setImageDrawable(getResources().getDrawable(R.drawable.tab_home_normal));
        mIvTabBuyCar.setImageDrawable(getResources().getDrawable(R.drawable.tab_buy_normal));
        mIvTabSellCar.setImageDrawable(getResources().getDrawable(R.drawable.tab_sell_normal));
        mIvTabMe.setImageDrawable(getResources().getDrawable(R.drawable.tab_my_info_normal));
        mTvTabHome.setTextColor(getResources().getColor(R.color.colorTextBlak));
        mTvTabSellCar.setTextColor(getResources().getColor(R.color.colorTextBlak));
        mTvTabBuyCar.setTextColor(getResources().getColor(R.color.colorTextBlak));
        mTvTabMe.setTextColor(getResources().getColor(R.color.colorTextBlak));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    @OnClick({R.id.ll_main_home,R.id.ll_main_buy_car,R.id.ll_main_sell_car,R.id.ll_main_mine})
    public void onClick(View view){
        setTabsNormal();
        switch (view.getId()){
            case R.id.ll_main_home:
                mIvTabHome.setImageDrawable(getResources().getDrawable(R.drawable.tab_home_selected));
                mTvTabHome.setTextColor(getResources().getColor(R.color.colorTextMain));
                mBanner.setCurrentItem(0);
                break;
            case R.id.ll_main_buy_car:
                mIvTabBuyCar.setImageDrawable(getResources().getDrawable(R.drawable.tab_buy_selected));
                mTvTabBuyCar.setTextColor(getResources().getColor(R.color.colorTextMain));
                mBanner.setCurrentItem(1);
                break;
            case R.id.ll_main_sell_car:
                mIvTabSellCar.setImageDrawable(getResources().getDrawable(R.drawable.tab_sell_selected));
                mTvTabSellCar.setTextColor(getResources().getColor(R.color.colorTextMain));
                mBanner.setCurrentItem(2);
                break;
            case R.id.ll_main_mine:
                mIvTabMe.setImageDrawable(getResources().getDrawable(R.drawable.tab_my_info_selected));
                mTvTabMe.setTextColor(getResources().getColor(R.color.colorTextMain));
                mBanner.setCurrentItem(3);
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveEvent(FragmentEvent fragmentEvent){
        if(fragmentEvent.getMessage() == FragmentEvent.FRAGMENT_BUY_ID){
            Toast.makeText(UIUtils.getContext(),"请求连接失败，检查网络",Toast.LENGTH_SHORT).show();
            return;
        }
        setTabsNormal();
        mIvTabBuyCar.setImageDrawable(getResources().getDrawable(R.drawable.tab_buy_selected));
        mTvTabBuyCar.setTextColor(getResources().getColor(R.color.colorTextMain));
        mBanner.setCurrentItem(fragmentEvent.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();

        if ( secondTime - firstTime < 2000) {
            System.exit(0);
        } else {
            Toast.makeText(HomeActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            firstTime = System.currentTimeMillis();
        }
    }
}
