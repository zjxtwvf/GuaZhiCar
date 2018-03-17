package com.terminator.zjxtwvf.guazi.view.adapter;


import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.terminator.zjxtwvf.guazi.view.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/6.
 */

public class HomeViewPagerAdapter extends FragmentPagerAdapter {

    List<BaseFragment> data = new ArrayList<BaseFragment>();

    public HomeViewPagerAdapter(FragmentManager fragmentManager, List<BaseFragment> data){
        super(fragmentManager);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        ((BaseFragment)data.get(position)).loadData();
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
