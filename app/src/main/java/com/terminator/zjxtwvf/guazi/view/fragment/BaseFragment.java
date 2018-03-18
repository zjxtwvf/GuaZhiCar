package com.terminator.zjxtwvf.guazi.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.terminator.zjxtwvf.guazi.util.UIUtils;
import com.terminator.zjxtwvf.guazi.view.widget.LoadingPage;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/5.
 */

public abstract class BaseFragment extends Fragment{

    private boolean mIsUiVisible = false;
    private boolean mFirst = false;
    private LoadingPage mLoadingPage;

    public BaseFragment(){
        mLoadingPage = new LoadingPage(UIUtils.getContext()) {
            @Override
            public View onCreateSuccessView() {
                return BaseFragment.this.onCreateSuccessView();
            }
            @Override
            public ResultState onLoad() {
                return BaseFragment.this.onLoad();
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return mLoadingPage;
    }

    // 开始加载数据
    public void loadData() {
        if (mLoadingPage != null) {
            mLoadingPage.loadData();
        }
    }

    //懒加载数据
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            mIsUiVisible = true;
            lazyLoad();
        }
    }
    //懒加载数据
    private void lazyLoad(){
        if(mIsUiVisible && !mFirst){
            loadData();
            mFirst = true;
        }
    }

    public void updatePage(LoadingPage.ResultState resultState){
        if (mLoadingPage != null) {
            mLoadingPage.updatePage(resultState);
        }
    }

    // 对网络返回数据的合法性进行校验
    public LoadingPage.ResultState check(Object obj) {
        if (obj != null) {
            if (obj instanceof ArrayList) {// 判断是否是集合
                ArrayList list = (ArrayList) obj;

                if (list.isEmpty()) {
                    return LoadingPage.ResultState.STATE_EMPTY;
                } else {
                    return LoadingPage.ResultState.STATE_SUCCESS;
                }
            }
        }
        return LoadingPage.ResultState.STATE_ERROR;
    }

    // 加载成功的布局, 必须由子类来实现
    public abstract View onCreateSuccessView();

    // 加载网络数据, 必须由子类来实现
    public abstract LoadingPage.ResultState onLoad();
}
