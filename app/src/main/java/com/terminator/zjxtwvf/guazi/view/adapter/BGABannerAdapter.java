package com.terminator.zjxtwvf.guazi.view.adapter;


import com.terminator.zjxtwvf.guazi.util.BitmapCacheUtils;
import com.terminator.zjxtwvf.guazi.view.widget.RecycleImageView;

import cn.bingoogolapple.bgabanner.BGABanner;

public class BGABannerAdapter implements BGABanner.Adapter<RecycleImageView,Object>{
    @Override
    public void fillBannerItem(BGABanner banner, RecycleImageView itemView, Object model, int position) {
         BitmapCacheUtils.getInstance().display(itemView,(String) model);
    }
}
