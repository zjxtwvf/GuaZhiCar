package com.terminator.zjxtwvf.guazi.view.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.leakcanary.LeakCanary;
import com.terminator.zjxtwvf.guazi.R;
import com.terminator.zjxtwvf.guazi.app.MyApplication;
import com.terminator.zjxtwvf.guazi.model.entity.RecyclerViewEvent;
import com.terminator.zjxtwvf.guazi.util.BitmapCacheUtils;
import com.terminator.zjxtwvf.guazi.util.UIUtils;
import com.terminator.zjxtwvf.guazi.view.activity.SourceDetailActivity;
import com.terminator.zjxtwvf.guazi.view.widget.ImageViewMatchWidth;

import org.greenrobot.eventbus.EventBus;

import java.util.Arrays;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;


/**
 * Created by Administrator on 2018/1/6.
 */

public class HomeAdapterBigMode extends BaseAdapter{

    BGABanner.Adapter mBgaAdapter;

    public HomeAdapterBigMode(RecyclerView recyclerView) {
        super(recyclerView);
        mBgaAdapter = new BGABannerAdapter();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder myViewHolder;
        if(viewType == LIST_NORMAL_BIG){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buy_car_list_item_big_mode,parent,false);
            myViewHolder = new HomeAdapterBigMode.MyViewBigModeHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(UIUtils.getContext(),SourceDetailActivity.class);
                    UIUtils.getContext().startActivity(intent);
                }
            });
            return myViewHolder;
        } else{
            ImageViewMatchWidth imageViewMatchWidth = new ImageViewMatchWidth(UIUtils.getContext());
            MyViewAdHolder adHolder = new MyViewAdHolder(imageViewMatchWidth);
            return  adHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int index;
        if(position >= 1 && position < 7){
            index = position - 1;
        }else{
            index = position - 2;
        }
        if(position == data.size() -1){
            EventBus.getDefault().post(new RecyclerViewEvent());
        }
        if(holder instanceof  HomeAdapterBigMode.MyViewAdHolder){
            String imageUrl;
            if(position == 0){
                imageUrl = mAdsData.getData().getAPP_BUY_LIST_BM().get(0).getImgUrl();
            }else{
                imageUrl = mAdsData.getData().getAPP_BUY_LIST_JR().get(0).getImgUrl();
            }
            BitmapCacheUtils.getInstance().display(((HomeAdapterBigMode.MyViewAdHolder) holder).iv, imageUrl);
        }else if(holder instanceof  HomeAdapterBigMode.MyViewBigModeHolder){
            ViewGroup.LayoutParams params = ((MyViewBigModeHolder)holder).itemView.getLayoutParams();
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            ((MyViewBigModeHolder)holder).itemView.setLayoutParams(params);
            ((MyViewBigModeHolder)holder).tv_car_title.setText(data.get(index).getTitle());
            ((MyViewBigModeHolder)holder).tv_dis_desc.setText(data.get(index).getLicense_date());
            ((MyViewBigModeHolder)holder).tv_price.setText(data.get(index).getPrice());
            ((MyViewBigModeHolder)holder).tv_price_first.setText("首付"+data.get(index).getFirst_pay());
            ((MyViewBigModeHolder)holder).tv_position.setText(data.get(index).getCity_name());
            BGABanner mBanner = ((MyViewBigModeHolder)holder).banner_content;
            mBanner.setAdapter(mBgaAdapter);
            mBanner.setData(R.layout.bga_image_view,data.get(index).getImage_list(), Arrays.asList("","","","",""));
        }
    }

    @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        super.onViewRecycled(holder);
        if(holder instanceof  HomeAdapterBigMode.MyViewAdHolder){
            ((HomeAdapterBigMode.MyViewAdHolder) holder).iv.setImageDrawable(null);
        }else if(holder instanceof  HomeAdapterBigMode.MyViewBigModeHolder){
            BGABanner mBanner = ((MyViewBigModeHolder)holder).banner_content;
            mBanner.setAdapter(null);
        }
    }

    public class MyViewBigModeHolder extends RecyclerView.ViewHolder{
        BGABanner banner_content;
        TextView  tv_car_title;
        TextView  tv_dis_desc;
        TextView  tv_big_mode_tag0;
        TextView  tv_big_mode_tag1;
        TextView  tv_price;
        TextView  tv_price_first;
        TextView  tv_position;

        public MyViewBigModeHolder(View itemView) {
            super(itemView);
            banner_content = (BGABanner)itemView.findViewById(R.id.banner_content);
            tv_car_title = (TextView)itemView.findViewById(R.id.tv_car_title);
            tv_dis_desc = (TextView)itemView.findViewById(R.id.tv_dis_desc);
            tv_big_mode_tag0 = (TextView)itemView.findViewById(R.id.tv_big_mode_tag0);
            tv_big_mode_tag1 = (TextView)itemView.findViewById(R.id.tv_big_mode_tag1);
            tv_price = (TextView)itemView.findViewById(R.id.tv_price);
            tv_price_first = (TextView)itemView.findViewById(R.id.tv_price_first);
            tv_position = (TextView)itemView.findViewById(R.id.tv_position);
        }
    }
}
