package com.terminator.zjxtwvf.guazi.view.fragment;


import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.terminator.zjxtwvf.guazi.R;
import com.terminator.zjxtwvf.guazi.app.MyApplication;
import com.terminator.zjxtwvf.guazi.di.components.DaggerBuyCarComponent;
import com.terminator.zjxtwvf.guazi.di.modules.BuyCarModule;
import com.terminator.zjxtwvf.guazi.model.entity.SellRecordsEntity;
import com.terminator.zjxtwvf.guazi.model.entity.SellDetailInfoEntity;
import com.terminator.zjxtwvf.guazi.presenter.BuyCarContract;
import com.terminator.zjxtwvf.guazi.presenter.BuyCarPresenter;
import com.terminator.zjxtwvf.guazi.util.BitmapCacheUtils;
import com.terminator.zjxtwvf.guazi.util.UIUtils;
import com.terminator.zjxtwvf.guazi.view.widget.LoadingPage;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2018/1/5.
 */

public class BuyCarFragment extends BaseFragment implements BuyCarContract.View{

    View mView;
    @Bind(R.id.iv_sell_car_bannerpic)
    ImageView  mBannerPic;
    @Bind(R.id.tv_sell_car_dualnum)
    TextView mDualNum;
    @Bind(R.id.ll_new_car_banner)
    LinearLayout mNewCarBanner;
    @Bind(R.id.ll_sale_car_records)
    LinearLayout mSaleCarRecords;
    @Bind(R.id.ll_pic_url)
    LinearLayout mSaleCarPicUrl;
    @Bind(R.id.ll_question)
    LinearLayout mQuestion;

    @Inject
    BuyCarPresenter mBuyCarPresenter;

    LinearLayout.LayoutParams params180 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,UIUtils.dip2px(180));
    LinearLayout.LayoutParams params60 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,UIUtils.dip2px(60));
    LinearLayout.LayoutParams paramsMM = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

    public BuyCarFragment(){
        DaggerBuyCarComponent.builder().buyCarModule(new BuyCarModule(this))
                .netComponent(MyApplication.getContext().getNetComponent())
                .build()
                .Inject(this);
    }
    @Override
    public View onCreateSuccessView() {
        return mView;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        mView = UIUtils.inflate(R.layout.activity_sellcar_fragment);
        ButterKnife.bind(this,mView);
        mBuyCarPresenter.getSelldetailInfo();
        mBuyCarPresenter.getSellRecords();
        return LoadingPage.ResultState.STATE_SUCCESS;
    }


    @Override
    public void onDisplaySellRecords(SellRecordsEntity sellRecordsEntity) {
        ImageView iv;
        TextView tvTtile;
        TextView tvDateHual;
        TextView tvPrice;
        for(int i=0;i<sellRecordsEntity.getData().getList().size();i++){
            View view = UIUtils.inflate(R.layout.activity_item_post_list);
            iv = (ImageView)view.findViewById(R.id.iv_item_post_list);
            tvTtile = (TextView)view.findViewById(R.id.tv_item_post_title);
            tvDateHual = (TextView)view.findViewById(R.id.tv_item_post_date_hual);
            tvPrice = (TextView)view.findViewById(R.id.tv_item_post_price);
            tvTtile.setText(sellRecordsEntity.getData().getList().get(i).getTitle());
            tvDateHual.setText(sellRecordsEntity.getData().getList().get(i).getLicense_date());
            tvPrice.setText(sellRecordsEntity.getData().getList().get(i).getDeal_price());
            BitmapCacheUtils.getInstance().display(iv,sellRecordsEntity.getData().getList().get(i).getThumb_img());
            mSaleCarRecords.addView(view);
        }
    }

    @Override
    public void onDisplaySelldetailInfo(SellDetailInfoEntity sellDetailInfoEntity) {
        BitmapCacheUtils.getInstance().displayMatchWidth(mBannerPic,sellDetailInfoEntity.getData().getBanner_pic());
        mDualNum.setText(sellDetailInfoEntity.getData().getClueNum()+"位车主提交了卖车申请");

        for(int i=0;i<sellDetailInfoEntity.getData().getNew_car_banner().size();i++){
            ImageView iv = new ImageView(UIUtils.getContext());
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            mNewCarBanner.addView(iv,params60);
            BitmapCacheUtils.getInstance().displayMatchWidth(iv,sellDetailInfoEntity.getData()
                    .getNew_car_banner().get(i).getImgUrl());
        }

        for(int i=0;i<sellDetailInfoEntity.getData().getPic_url().size();i++){
            ImageView iv = new ImageView(UIUtils.getContext());
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            mSaleCarPicUrl.addView(iv,params180);
            BitmapCacheUtils.getInstance().display(iv,sellDetailInfoEntity.getData().getPic_url().get(i));
        }

        TextView tvQues;
        TextView tvAnser;
        TextView tvIndex;
        int index = 0;
        for(int i=0;i<sellDetailInfoEntity.getData().getQuestion().size();i++){
            View view = UIUtils.inflate(R.layout.sell_car_process_que);
            tvQues = (TextView)view.findViewById(R.id.tv_que_ques);
            tvAnser = (TextView)view.findViewById(R.id.tv_que_anser);
            tvIndex = (TextView)view.findViewById(R.id.tv_que_index);
            index++;
            tvIndex.setText("Q"+index);
            tvQues.setText(sellDetailInfoEntity.getData().getQuestion().get(i).getQues());
            tvAnser.setText(sellDetailInfoEntity.getData().getQuestion().get(i).getAnser());
            mQuestion.addView(view,paramsMM);
        }
    }
}
