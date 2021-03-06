package com.terminator.zjxtwvf.guazi.view.fragment;

import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.terminator.zjxtwvf.guazi.R;
import com.terminator.zjxtwvf.guazi.app.MyApplication;
import com.terminator.zjxtwvf.guazi.di.components.DaggerSellCarComponent;
import com.terminator.zjxtwvf.guazi.di.modules.SellCarModule;
import com.terminator.zjxtwvf.guazi.model.entity.BannerAdsEntity;
import com.terminator.zjxtwvf.guazi.model.entity.CarListEntity;
import com.terminator.zjxtwvf.guazi.model.entity.FragmentEvent;
import com.terminator.zjxtwvf.guazi.model.entity.RecyclerViewEvent;
import com.terminator.zjxtwvf.guazi.presenter.SellCarContract;
import com.terminator.zjxtwvf.guazi.presenter.SellCarPresenter;
import com.terminator.zjxtwvf.guazi.util.UIUtils;
import com.terminator.zjxtwvf.guazi.view.adapter.BaseAdapter;
import com.terminator.zjxtwvf.guazi.view.adapter.HomeAdapter;
import com.terminator.zjxtwvf.guazi.view.adapter.HomeAdapterBigMode;
import com.terminator.zjxtwvf.guazi.view.widget.LoadingPage;
import com.terminator.zjxtwvf.guazi.view.widget.RefreshRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.terminator.zjxtwvf.guazi.view.adapter.HomeAdapter.DISPALY_BIG;
import static com.terminator.zjxtwvf.guazi.view.adapter.HomeAdapter.DISPALY_SMALL;
import static com.terminator.zjxtwvf.guazi.view.widget.RefreshRecyclerView.REFRESH_ERROR;
import static com.terminator.zjxtwvf.guazi.view.widget.RefreshRecyclerView.REFRESH_ING;
import static com.terminator.zjxtwvf.guazi.view.widget.RefreshRecyclerView.REFRESH_RELEASE;
import static com.terminator.zjxtwvf.guazi.view.widget.RefreshRecyclerView.REFRESH_RETURN;
import static com.terminator.zjxtwvf.guazi.view.widget.RefreshRecyclerView.REFRESH_SUCESS;


/**
 * Created by Administrator on 2018/1/5.
 */

public class SellCarFragment extends BaseFragment implements SellCarContract.View ,RefreshRecyclerView.OnRereshStateChangeListener {

    View mView;
    int mDisMode = DISPALY_SMALL;
    BaseAdapter mAdapter;
    BaseAdapter mHomeAdapterSM;
    BaseAdapter mHomeAdapterBM;
    BannerAdsEntity mBannerAdData;
    List<CarListEntity.DataBean.PostListBean> mData;

    @Inject
    SellCarPresenter mSellCarPresenter;
    @Bind(R.id.recycler_sellcar)
    RecyclerView mSellCarView;
    @Bind(R.id.iv_loading_more)
    ImageView mLoadingMore;
    @Bind(R.id.rl_load_more)
    RelativeLayout mRlLoadingMore;
    @Bind(R.id.refresh_head)
    RelativeLayout mHeadView;
    @Bind(R.id.iv_display_mode)
    ImageView mDisplayMode;

    public SellCarFragment(){
        super();
        DaggerSellCarComponent.builder().sellCarModule(new SellCarModule(this))
                .netComponent(MyApplication.getContext().getNetComponent())
                .build()
                .Inject(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateSuccessView() {
        mView = UIUtils.inflate(R.layout.activity_buycar_fragment);
        ButterKnife.bind(this,mView);
        mRlLoadingMore.getLayoutParams().height = 0;
        mRlLoadingMore.setPadding(0,-UIUtils.dip2px(60),0,0);
        ((RefreshRecyclerView)mSellCarView).setHeadView(mHeadView);
        ((RefreshRecyclerView)mSellCarView).setRereshStateChangeListener(this);
        return mView;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        mHomeAdapterSM = new HomeAdapter(mSellCarView);
        mHomeAdapterBM = new HomeAdapterBigMode(mSellCarView);
        mAdapter = mHomeAdapterSM;
        mSellCarView.setLayoutManager(new LinearLayoutManager(UIUtils.getContext()));
        mSellCarView.setAdapter(mAdapter);
        ((SimpleItemAnimator)mSellCarView.getItemAnimator()).setSupportsChangeAnimations(false);
        mSellCarPresenter.getBannerAds();
        return LoadingPage.ResultState.STATE_SUCCESS;
    }

    @Override
    public void onLoadMoreData(CarListEntity carListEntity) {
        mData.addAll(carListEntity.getData().getPostList());
        toggle(true);
        mAdapter.updateData(mData,mBannerAdData);
    }

    @Override
    public void onDisplayBannerAds(BannerAdsEntity bannerAdsEntity) {
        mBannerAdData = bannerAdsEntity;
        mSellCarPresenter.getCarList();
    }

    @Override
    public void onDisplayCarList(CarListEntity carListEntity) {
        mAdapter.updateData(carListEntity.getData().getPostList(),mBannerAdData);
        mData = carListEntity.getData().getPostList();
        Animation animation = AnimationUtils.loadAnimation(UIUtils.getContext(),R.anim.roate_animation);
        LinearInterpolator interpolator = new LinearInterpolator();
        animation.setInterpolator(interpolator);
        mLoadingMore.setAnimation(animation);
    }

    @Override
    public void onUpdateLoadingPage(LoadingPage.ResultState resultState) {
        updatePage(resultState);
    }

    @Override
    public void onLoadRereshData(CarListEntity carListEntity,int state) {
        if(null != carListEntity){
            mAdapter.updateData(carListEntity.getData().getPostList(),mBannerAdData);
            mData = carListEntity.getData().getPostList();
        }
        ((RefreshRecyclerView)mSellCarView).onRereshFinished(state);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveEvent(RecyclerViewEvent recyclerViewEvent){
        toggle(false);
        mSellCarPresenter.loadMoreData();
    }

    @OnClick({R.id.iv_display_mode})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_display_mode:
                if(DISPALY_SMALL == mDisMode){
                    mDisplayMode.setImageDrawable(UIUtils.getContext().getResources().getDrawable(R.drawable.ic_big_mode));
                    mDisMode = DISPALY_BIG;
                    mAdapter = mHomeAdapterBM;
                    mAdapter.setDisplayMode(mDisMode);
                    mSellCarView.setAdapter(mAdapter);
                }else{
                    mDisplayMode.setImageDrawable(UIUtils.getContext().getResources().getDrawable(R.drawable.ic_small_mode));
                    mDisMode = DISPALY_SMALL;
                    mAdapter = mHomeAdapterSM;
                    mAdapter.setDisplayMode(mDisMode);
                    mSellCarView.setAdapter(mAdapter);
                }
                break;
        }
        mAdapter.updateData(mData,mBannerAdData);
    }

    private void toggle(boolean down){
        ValueAnimator animator;
        if(!down){
            animator = ValueAnimator.ofInt(0,UIUtils.dip2px(60));
        }else{
            animator =ValueAnimator.ofInt(UIUtils.dip2px(60),0);
        }
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator arg0) {
                mRlLoadingMore.setPadding(0,(Integer) arg0.getAnimatedValue() - UIUtils.dip2px(60),0,0);
                System.out.println( "mRlLoadingMore.setPadding        " +   ((Integer) arg0.getAnimatedValue() - UIUtils.dip2px(60)) );
            }
        });
        animator.setDuration(600);
        animator.start();
    }

    @Override
    public void onRereshStateChange(int state) {
        final TextView tv = (TextView)mHeadView.findViewById(R.id.tv_list_refresh);
        final ImageView iv = (ImageView)mHeadView.findViewById(R.id.iv_list_refresh);
        switch (state){
            case  REFRESH_ING:
                tv.setText("正在刷新...");
                ((AnimationDrawable)iv.getDrawable()).start();
                mSellCarPresenter.loadRereshData();
                break;
            case  REFRESH_ERROR:
                ((AnimationDrawable)iv.getDrawable()).stop();
                EventBus.getDefault().post(new FragmentEvent(FragmentEvent.FRAGMENT_BUY_ID));
                break;
            case  REFRESH_SUCESS:
                ((AnimationDrawable)iv.getDrawable()).stop();
                break;
            case  REFRESH_RETURN:
                tv.setText("下拉可以刷新");
                break;
            case  REFRESH_RELEASE:
                tv.setText("释放立即刷新");
                break;
        }
    }
}
