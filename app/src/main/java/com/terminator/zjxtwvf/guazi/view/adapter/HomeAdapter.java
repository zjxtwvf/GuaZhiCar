package com.terminator.zjxtwvf.guazi.view.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.terminator.zjxtwvf.guazi.R;
import com.terminator.zjxtwvf.guazi.model.entity.CarListEntity;
import com.terminator.zjxtwvf.guazi.model.entity.RecyclerViewEvent;
import com.terminator.zjxtwvf.guazi.util.BitmapCacheUtils;
import com.terminator.zjxtwvf.guazi.util.UIUtils;
import com.terminator.zjxtwvf.guazi.view.activity.SourceDetailActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by Administrator on 2018/1/6.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{

    List<CarListEntity.DataBean.PostListBean> data;

    public HomeAdapter(){
    }

    public void updateData(List<CarListEntity.DataBean.PostListBean> data){
        this.data = data;
        this.notifyItemRangeChanged(0,data.size());
    }

    @Override
    public HomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = UIUtils.inflate(R.layout.activity_item_post_list);
        HomeAdapter.MyViewHolder myViewHolder = new HomeAdapter.MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UIUtils.getContext(),SourceDetailActivity.class);
                UIUtils.getContext().startActivity(intent);
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(HomeAdapter.MyViewHolder holder, int position) {
        if(position == data.size() -1){
            EventBus.getDefault().post(new RecyclerViewEvent());
        }
        holder.tvTtile.setText(data.get(position).getTitle());
        holder.tvDateHual.setText(data.get(position).getLicense_date());
        holder.tvPrice.setText(data.get(position).getPrice());
        BitmapCacheUtils.getInstance().display(holder.iv,data.get(position).getThumb_img());
    }

    @Override
    public int getItemCount() {
        if(data != null) {
            return data.size();
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
}
