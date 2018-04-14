package com.terminator.zjxtwvf.guazi.view.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.terminator.zjxtwvf.guazi.R;
import com.terminator.zjxtwvf.guazi.model.entity.BannerAdsEntity;
import com.terminator.zjxtwvf.guazi.model.entity.CarListEntity;
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

public abstract class BaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static final int DISPALY_BIG = 0 ;
    public static final int DISPALY_SMALL = 1 ;

    public static final int LIST_ADS = 0;
    public static final int LIST_NORMAL = 1;
    public static final int LIST_NORMAL_BIG = 2;

    BannerAdsEntity mAdsData;
    int mDisMode = DISPALY_SMALL;
    RecyclerView mRecyclerView;
    List<CarListEntity.DataBean.PostListBean> data;

    public BaseAdapter(RecyclerView recyclerView){
        mRecyclerView = recyclerView;
    }

    public void updateData(List<CarListEntity.DataBean.PostListBean> data , BannerAdsEntity bannerAdsEntity){
        this.data = data;
        this.mAdsData = bannerAdsEntity;
        this.notifyItemRangeChanged(0,data.size());
    }

    public void setDisplayMode(int mode){
        mDisMode = mode;
    }

    @Override
    public int getItemViewType(int position) {
        if(0 == position || 6 == position){
            return LIST_ADS;
        }else{
            if(DISPALY_SMALL == mDisMode){
                return LIST_NORMAL;
            }else{
                return LIST_NORMAL_BIG;
            }
        }
    }

    @Override
    public int getItemCount() {
        if(data != null) {
            return data.size() + 2;
        }
        return 0;
    }

    public class MyViewAdHolder extends RecyclerView.ViewHolder{
        ImageView iv;

        public MyViewAdHolder(View itemView) {
            super(itemView);
            iv = (ImageView)itemView;
        }
    }
}
