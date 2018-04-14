package com.terminator.zjxtwvf.guazi.view.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.terminator.zjxtwvf.guazi.R;
import com.terminator.zjxtwvf.guazi.model.entity.RecyclerViewEvent;
import com.terminator.zjxtwvf.guazi.util.BitmapCacheUtils;
import com.terminator.zjxtwvf.guazi.util.UIUtils;
import com.terminator.zjxtwvf.guazi.view.activity.SourceDetailActivity;
import com.terminator.zjxtwvf.guazi.view.widget.ImageViewMatchWidth;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2018/1/6.
 */

public class HomeAdapter extends BaseAdapter{

    public HomeAdapter(RecyclerView recyclerView) {
        super(recyclerView);
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
        }else{
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
            //if(mRecyclerView.getScrollState() != RecyclerView.SCROLL_STATE_SETTLING){
                BitmapCacheUtils.getInstance().display(((HomeAdapter.MyViewHolder)holder).iv,data.get(index).getThumb_img());
            //}
        }else if(holder instanceof  HomeAdapter.MyViewAdHolder){
            String imageUrl;
            if(position == 0){
                imageUrl = mAdsData.getData().getAPP_BUY_LIST_BM().get(0).getImgUrl();
            }else{
                imageUrl = mAdsData.getData().getAPP_BUY_LIST_JR().get(0).getImgUrl();
            }
            //if(mRecyclerView.getScrollState() != RecyclerView.SCROLL_STATE_SETTLING) {
                BitmapCacheUtils.getInstance().display(((HomeAdapter.MyViewAdHolder) holder).iv, imageUrl);
            //}
        }
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
}
