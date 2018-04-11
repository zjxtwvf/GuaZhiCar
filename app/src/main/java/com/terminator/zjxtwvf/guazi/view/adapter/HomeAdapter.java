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
import com.terminator.zjxtwvf.guazi.model.entity.BannerImageUrlEntity;
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

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static final int DISPALY_BIG = 0 ;
    public static final int DISPALY_SMALL = 1 ;

    public static final int LIST_ADS = 0;
    public static final int LIST_NORMAL = 1;
    public static final int LIST_NORMAL_BIG = 2;

    int mDisMode = DISPALY_SMALL;
    BannerAdsEntity mAdsData;
    List<CarListEntity.DataBean.PostListBean> data;

    public HomeAdapter(){
    }

    public void updateData(List<CarListEntity.DataBean.PostListBean> data , BannerAdsEntity bannerAdsEntity){
        this.data = data;
        this.mAdsData = bannerAdsEntity;
        this.notifyItemRangeChanged(0,data.size());
    }

    public void setDisplayMode(int mode){
        mDisMode = mode;
        this.notifyItemRangeChanged(0,data.size());
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder myViewHolder;
        if(viewType == LIST_NORMAL){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_post_list,parent,false);
            myViewHolder = new HomeAdapter.MyViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(UIUtils.getContext(),SourceDetailActivity.class);
                    UIUtils.getContext().startActivity(intent);
                }
            });
            return myViewHolder;
        }else if(viewType == LIST_NORMAL_BIG){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buy_car_list_item_big_mode,parent,false);
            myViewHolder = new HomeAdapter.MyViewBigModeHolder(view);
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
        if(holder instanceof  HomeAdapter.MyViewHolder){
            ((HomeAdapter.MyViewHolder)holder).tvTtile.setText(data.get(index).getTitle());
            ((HomeAdapter.MyViewHolder)holder).tvDateHual.setText(data.get(index).getLicense_date());
            ((HomeAdapter.MyViewHolder)holder).tvPrice.setText(data.get(index).getPrice());
            BitmapCacheUtils.getInstance().display(((HomeAdapter.MyViewHolder)holder).iv,data.get(index).getThumb_img());
        }else if(holder instanceof  HomeAdapter.MyViewAdHolder){
            String imageUrl;
            if(position == 0){
                imageUrl = mAdsData.getData().getAPP_BUY_LIST_BM().get(0).getImgUrl();
            }else{
                imageUrl = mAdsData.getData().getAPP_BUY_LIST_JR().get(0).getImgUrl();
            }
            BitmapCacheUtils.getInstance().display(((HomeAdapter.MyViewAdHolder)holder).iv,imageUrl);
        }else if(holder instanceof  HomeAdapter.MyViewBigModeHolder){
            ViewGroup.LayoutParams params = ((MyViewBigModeHolder)holder).itemView.getLayoutParams();
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            ((MyViewBigModeHolder)holder).itemView.setLayoutParams(params);
            ((MyViewBigModeHolder)holder).tv_car_title.setText(data.get(index).getTitle());
            ((MyViewBigModeHolder)holder).tv_dis_desc.setText(data.get(index).getLicense_date());
            ((MyViewBigModeHolder)holder).tv_price.setText(data.get(index).getPrice());
            ((MyViewBigModeHolder)holder).tv_price_first.setText("首付"+data.get(index).getFirst_pay());
            ((MyViewBigModeHolder)holder).tv_position.setText(data.get(index).getCity_name());
            BGABanner mBanner = ((MyViewBigModeHolder)holder).banner_content;
            mBanner.setAdapter(new BGABanner.Adapter<ImageView,Object>() {
                @Override
                public void fillBannerItem(BGABanner banner, ImageView itemView, Object model, int position) {
                    BitmapCacheUtils.getInstance().display((ImageView) itemView,
                            (String)model);
                }
            });
            mBanner.setData(data.get(index).getImage_list(), Arrays.asList("","","","",""));
        }
    }

    @Override
    public int getItemCount() {
        if(data != null) {
            return data.size() + 2;
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

    public class MyViewAdHolder extends RecyclerView.ViewHolder{
        ImageView iv;

        public MyViewAdHolder(View itemView) {
            super(itemView);
            iv = (ImageView)itemView;
        }
    }
}
