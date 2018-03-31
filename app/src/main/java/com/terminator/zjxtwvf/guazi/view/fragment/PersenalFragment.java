package com.terminator.zjxtwvf.guazi.view.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.terminator.zjxtwvf.guazi.R;
import com.terminator.zjxtwvf.guazi.app.MyApplication;
import com.terminator.zjxtwvf.guazi.di.components.DaggerPersonalComponent;
import com.terminator.zjxtwvf.guazi.di.modules.PersonalModule;
import com.terminator.zjxtwvf.guazi.model.entity.PersonalCenterEntity;
import com.terminator.zjxtwvf.guazi.model.entity.RecommendEntity;

import com.terminator.zjxtwvf.guazi.presenter.PersonalContract;
import com.terminator.zjxtwvf.guazi.presenter.PersonnalPresenter;
import com.terminator.zjxtwvf.guazi.util.BitmapCacheUtils;
import com.terminator.zjxtwvf.guazi.util.UIUtils;
import com.terminator.zjxtwvf.guazi.view.activity.SourceDetailActivity;
import com.terminator.zjxtwvf.guazi.view.widget.LoadingPage;


import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2018/1/5.
 */

public class PersenalFragment extends BaseFragment implements PersonalContract.View{

    View mView;
    @Bind(R.id.ll_personal_center)
    LinearLayout mLlPersonalCenter;
    @Bind(R.id.ll_personal_fuc0)
    LinearLayout mLlPersonalFun0;
    @Bind(R.id.ll_personal_fuc1)
    LinearLayout mLlPersonalFun1;
    @Bind(R.id.ll_personal_other)
    LinearLayout mLlPersonalOther;
    @Bind(R.id.ll_item_personal_list)
    LinearLayout mLlPersonaRecomendList;
    @Bind(R.id.recycler_personal_recomend)
    RecyclerView mLlPersonalRecomend;


    //HomeAdapter mHomeAdapter;

    @Inject
    PersonnalPresenter mPersonnalPresenter;

    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,1);
    LinearLayout.LayoutParams params_wrap = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

    public PersenalFragment(){
        super();
        DaggerPersonalComponent.builder().personalModule(new PersonalModule(this))
                .netComponent(MyApplication.getContext().getNetComponent())
                .build()
                .Inject(this);
    }
    @Override
    public View onCreateSuccessView() {
        mView = UIUtils.inflate(R.layout.activity_persenal_fragment);
        ButterKnife.bind(this,mView);
        return mView;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        mPersonnalPresenter.getPersonalCenter();
        mPersonnalPresenter.getRecommend();
        return LoadingPage.ResultState.STATE_SUCCESS;
    }

    @Override
    public void onDisplayPersonalCenter(PersonalCenterEntity personalCenterEntity) {
        for(int i=0;i<personalCenterEntity.getData().get(0).getList().size();i++){
            View view = UIUtils.inflate(R.layout.personal_center_item);
            TextView textView = (TextView)view.findViewById(R.id.tv_personal_center);
            textView.setText(personalCenterEntity.getData().get(0).getList().get(i).getTitle());
            ImageView imageView = (ImageView)view.findViewById(R.id.iv_personal_center);
            BitmapCacheUtils.getInstance().display(imageView,personalCenterEntity.getData().get(0).getList().get(i).getImageUrl());
            params.setMargins(0,UIUtils.dip2px(20),0,0);
            mLlPersonalCenter.addView(view,params);
        }
        if(personalCenterEntity.getData().get(0).getList().size() < 4){
            for(int i=0;i<4-personalCenterEntity.getData().get(0).getList().size();i++){
                TextView textView = new TextView(UIUtils.getContext());
                params.setMargins(0,UIUtils.dip2px(20),0,0);
                mLlPersonalCenter.addView(textView,params);
            }
        }
        for(int i=0;i<personalCenterEntity.getData().get(1).getList().size();i++){
            View view = UIUtils.inflate(R.layout.personal_center_item);
            TextView textView = (TextView)view.findViewById(R.id.tv_personal_center);
            textView.setText(personalCenterEntity.getData().get(1).getList().get(i).getTitle());
            ImageView imageView = (ImageView)view.findViewById(R.id.iv_personal_center);
            BitmapCacheUtils.getInstance().display(imageView,personalCenterEntity.getData().get(1).getList().get(i).getImageUrl());
            if(i < personalCenterEntity.getData().get(1).getList().size()/2){
                mLlPersonalFun0.addView(view,params);
            }else{
                mLlPersonalFun1.addView(view,params);
            }
        }

        for(int i=0;i<personalCenterEntity.getData().get(2).getList().size();i++){
            TextView textView = new TextView(UIUtils.getContext());
            textView.setText(personalCenterEntity.getData().get(2).getList().get(i).getTitle());
            textView.setTextSize(15);
            textView.setTextColor(Color.BLACK);
            params_wrap.setMargins(0, UIUtils.dip2px(30),0,0);
            mLlPersonalOther.addView(textView,params_wrap);
        }
    }

    @Override
    public void onDisplayRecommend(RecommendEntity recommendEntity) {
        ImageView iv;
        TextView tvTtile;
        TextView tvDateHual;
        TextView tvPrice;
        for(int i=0;i<recommendEntity.getData().size();i++){
            View view = UIUtils.inflate(R.layout.activity_item_post_list);
            view.setOnClickListener(new PersonalClickListener());
            iv = (ImageView)view.findViewById(R.id.iv_item_post_list);
            tvTtile = (TextView)view.findViewById(R.id.tv_item_post_title);
            tvDateHual = (TextView)view.findViewById(R.id.tv_item_post_date_hual);
            tvPrice = (TextView)view.findViewById(R.id.tv_item_post_price);
            tvTtile.setText(recommendEntity.getData().get(i).getTitle());
            tvDateHual.setText(recommendEntity.getData().get(i).getLicense_date());
            tvPrice.setText(recommendEntity.getData().get(i).getPrice());
            BitmapCacheUtils.getInstance().display(iv,recommendEntity.getData().get(i).getThumb_img());
            mLlPersonaRecomendList.addView(view);
        }
    }

    @Override
    public void onUpdateLoadingPage(LoadingPage.ResultState resultState) {
        updatePage(resultState);
    }

    public class PersonalClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(UIUtils.getContext(),SourceDetailActivity.class);
            startActivity(intent);
        }
    }
}
