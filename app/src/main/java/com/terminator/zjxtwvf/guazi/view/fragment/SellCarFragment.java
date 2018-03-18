package com.terminator.zjxtwvf.guazi.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.terminator.zjxtwvf.guazi.R;
import com.terminator.zjxtwvf.guazi.app.MyApplication;
import com.terminator.zjxtwvf.guazi.di.components.DaggerSellCarComponent;
import com.terminator.zjxtwvf.guazi.di.modules.SellCarModule;
import com.terminator.zjxtwvf.guazi.model.entity.CarListEntity;
import com.terminator.zjxtwvf.guazi.presenter.SellCarContract;
import com.terminator.zjxtwvf.guazi.presenter.SellCarPresenter;
import com.terminator.zjxtwvf.guazi.util.UIUtils;
import com.terminator.zjxtwvf.guazi.view.adapter.HomeAdapter;
import com.terminator.zjxtwvf.guazi.view.widget.LoadingPage;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2018/1/5.
 */

public class SellCarFragment extends BaseFragment implements SellCarContract.View{

    View mView;
    HomeAdapter mHomeAdapter;

    @Inject
    SellCarPresenter mSellCarPresenter;
    @Bind(R.id.recycler_sellcar)
    RecyclerView mSellCarView;

    public SellCarFragment(){
        super();
        DaggerSellCarComponent.builder().sellCarModule(new SellCarModule(this))
                .netComponent(MyApplication.getContext().getNetComponent())
                .build()
                .Inject(this);
    }

    @Override
    public View onCreateSuccessView() {
        mView = UIUtils.inflate(R.layout.activity_buycar_fragment);
        ButterKnife.bind(this,mView);
        return mView;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        mHomeAdapter = new HomeAdapter();
        mSellCarView.setLayoutManager(new LinearLayoutManager(UIUtils.getContext()));
        mSellCarView.setAdapter(mHomeAdapter);
        mSellCarPresenter.getCarList();
        return LoadingPage.ResultState.STATE_SUCCESS;
    }

    @Override
    public void onDisplayCarList(CarListEntity carListEntity) {
        mHomeAdapter.updateData(carListEntity.getData().getPostList());
    }

    @Override
    public void onUpdateLoadingPage(LoadingPage.ResultState resultState) {
        updatePage(resultState);
    }
}
