package com.terminator.zjxtwvf.guazi.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.terminator.zjxtwvf.guazi.R;
import com.terminator.zjxtwvf.guazi.view.adapter.HomeViewPagerAdapter;
import com.terminator.zjxtwvf.guazi.view.fragment.BaseFragment;
import com.terminator.zjxtwvf.guazi.view.fragment.BuyCarFragment;
import com.terminator.zjxtwvf.guazi.view.fragment.HomeFragment;
import com.terminator.zjxtwvf.guazi.view.fragment.PersenalFragment;
import com.terminator.zjxtwvf.guazi.view.fragment.SellCarFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/12/24.
 */

public class HomeActivity extends AppCompatActivity{

    List<BaseFragment> mFragments = new ArrayList<BaseFragment>();

    @Bind(R.id.banner_home_content)
    ViewPager mBanner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(HomeActivity.this);

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
}
