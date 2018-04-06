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

import java.util.List;

/**
 * Created by Administrator on 2018/1/6.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static final int LIST_NORMAL = 0;
    public static final int LIST_REFRESH = 1;
    public static final int LIST_ADS = 2;

    List<CarListEntity.DataBean.PostListBean> data;
    BannerAdsEntity mAdsData;

    public HomeAdapter(){
    }

    public void updateData(List<CarListEntity.DataBean.PostListBean> data , BannerAdsEntity bannerAdsEntity){
        this.data = data;
        this.mAdsData = bannerAdsEntity;
        this.notifyItemRangeChanged(0,data.size());
    }

    @Override
    public int getItemViewType(int position) {
        if(0 == position){
            return LIST_REFRESH;
        }else if(1 == position || 7 == position){
            return LIST_ADS;
        }else{
            return LIST_NORMAL;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == LIST_NORMAL){
            View view = LayoutInflater.from(UIUtils.getContext()).inflate(R.layout.activity_item_post_list,parent,false);
            HomeAdapter.MyViewHolder myViewHolder = new HomeAdapter.MyViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(UIUtils.getContext(),SourceDetailActivity.class);
                    UIUtils.getContext().startActivity(intent);
                }
            });
            return myViewHolder;
        }else if(LIST_ADS == viewType){
            ImageViewMatchWidth imageViewMatchWidth = new ImageViewMatchWidth(UIUtils.getContext());
            MyViewAdHolder adHolder = new MyViewAdHolder(imageViewMatchWidth);
            return  adHolder;
        }else{
            View view =LayoutInflater.from(UIUtils.getContext()).inflate(R.layout.refresh_loading,parent,false);
            MyViewRefreshHolder refreshHolder = new MyViewRefreshHolder(view);
            return  refreshHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int index;
        if(position == data.size() -1){
            EventBus.getDefault().post(new RecyclerViewEvent());
        }
        if(holder instanceof  HomeAdapter.MyViewHolder){
            if(position >= 2 && position < 7){
                index = position - 2;
            }else{
                index = position - 3;
            }
            ((HomeAdapter.MyViewHolder)holder).tvTtile.setText(data.get(index).getTitle());
            ((HomeAdapter.MyViewHolder)holder).tvDateHual.setText(data.get(index).getLicense_date());
            ((HomeAdapter.MyViewHolder)holder).tvPrice.setText(data.get(index).getPrice());
            BitmapCacheUtils.getInstance().display(((HomeAdapter.MyViewHolder)holder).iv,data.get(index).getThumb_img());
        }else if(holder instanceof  HomeAdapter.MyViewAdHolder){
            String imageUrl;
            if(position == 1){
                imageUrl = mAdsData.getData().getAPP_BUY_LIST_BM().get(0).getImgUrl();
            }else{
                imageUrl = mAdsData.getData().getAPP_BUY_LIST_JR().get(0).getImgUrl();
            }
            BitmapCacheUtils.getInstance().display(((HomeAdapter.MyViewAdHolder)holder).iv,imageUrl);
        }else if(holder instanceof  HomeAdapter.MyViewRefreshHolder){
        }else{
        }
    }

    @Override
    public int getItemCount() {
        if(data != null) {
            return data.size() + 3;
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tvTtile;
        TextView tvDateHual;
        TextView tvPrice;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView)itemView.findViewById(R.id.iv_item_post_list);
            tvTtile = (TextView)itemView.findViewById(R.id.tv_item_post_title);
            tvDateHual = (TextView)itemView.findViewById(R.id.tv_item_post_date_hual);
            tvPrice = (TextView)itemView.findViewById(R.id.tv_item_post_price);
        }
    }

    public class MyViewAdHolder extends RecyclerView.ViewHolder{
        ImageView iv;

        public MyViewAdHolder(View itemView) {
            super(itemView);
            iv = (ImageView)itemView;
        }
    }

    public class MyViewRefreshHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;

        public MyViewRefreshHolder(View itemView) {
            super(itemView);
            iv = (ImageView)itemView.findViewById(R.id.iv_list_refresh);
            tv = (TextView)itemView.findViewById(R.id.tv_list_refresh);
        }
    }
}
