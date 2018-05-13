package com.terminator.zjxtwvf.guazi.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.terminator.zjxtwvf.guazi.R;
import com.terminator.zjxtwvf.guazi.app.MyApplication;
import com.terminator.zjxtwvf.guazi.di.components.DaggerHomeComponent;
import com.terminator.zjxtwvf.guazi.di.modules.HomeModule;
import com.terminator.zjxtwvf.guazi.model.entity.BannerImageUrlEntity;
import com.terminator.zjxtwvf.guazi.model.entity.FastIndexEntity;
import com.terminator.zjxtwvf.guazi.model.entity.FragmentEvent;
import com.terminator.zjxtwvf.guazi.model.entity.HomeEntity;
import com.terminator.zjxtwvf.guazi.model.entity.IndexActiveEntity;
import com.terminator.zjxtwvf.guazi.model.entity.TopicEntity;
import com.terminator.zjxtwvf.guazi.presenter.HomeContract;
import com.terminator.zjxtwvf.guazi.presenter.HomePresenter;
import com.terminator.zjxtwvf.guazi.util.BitmapCacheUtils;
import com.terminator.zjxtwvf.guazi.util.UIUtils;
import com.terminator.zjxtwvf.guazi.view.activity.SourceDetailActivity;
import com.terminator.zjxtwvf.guazi.view.activity.WebViewActivity;
import com.terminator.zjxtwvf.guazi.view.widget.ImageViewMatchWidth;
import com.terminator.zjxtwvf.guazi.view.widget.LoadingPage;

import org.greenrobot.eventbus.EventBus;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;


/**
 * Created by Administrator on 2018/1/5.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View{

    private static final String ONCLICK_EVNET = "onclick_event";

    @Inject
    HomePresenter mHomePresenter;
    @Bind(R.id.banner_guide_content)
    BGABanner mBanner;
    @Bind(R.id.ll_item_brand)
    LinearLayout mLlItem;
    @Bind(R.id.my_recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.ll_home_price_range)
    LinearLayout mLlItemPriceRange;
    @Bind(R.id.ll_home_tag_types)
    LinearLayout mLlItemTagTypes;
    @Bind(R.id.ll_item_channel)
    LinearLayout mLlItemChannel;
    @Bind(R.id.ll_item_like_left)
    LinearLayout mLlItemLikeLeft;
    @Bind(R.id.ll_item_like_right)
    LinearLayout mLlItemLikeRight;
    @Bind(R.id.ll_item_service_guarantee)
    LinearLayout mLlItemServiceGuarantee;
    @Bind(R.id.ll_item_post_list)
    LinearLayout mLlItemPostList;
    @Bind(R.id.ll_item_topic_details)
    LinearLayout mLlItemTopicDetails;
    @Bind(R.id.ll_evaluate)
    LinearLayout mLindexActiveEvaluate;
    @Bind(R.id.tv_home_more)
    TextView mHomeMore;

    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,1);
    LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(540,0,1);

    View mHomeView = null;
    HomeClickListener mHomeClickListener = null;

    public  HomeFragment(){
        super();
        DaggerHomeComponent.builder().homeModule(new HomeModule(this))
                .netComponent(MyApplication.getContext().getNetComponent())
                .build()
                .Inject(this);
        mHomeClickListener = new HomeClickListener();
    }

    @Override
    public View onCreateSuccessView() {
        mHomeView = UIUtils.inflate(R.layout.activity_home_fragment);
        ButterKnife.bind(this,mHomeView);
        return mHomeView;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        mHomePresenter.getBanner();
        mHomePresenter.getFastIndex();
        mHomePresenter.getHomeCar();
        mHomePresenter.getHomeTopic();
        mHomePresenter.getIndexActive();
        return LoadingPage.ResultState.STATE_SUCCESS;
    }

    @Override
    public void onDisplayBanner(List<BannerImageUrlEntity.DataBean> dataBeans) {
        Logger.d(dataBeans);
        mBanner.setAdapter(new BGABanner.Adapter<ImageView,Object>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, final Object model, int position) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openLink(((BannerImageUrlEntity.DataBean)model).getLinkUrl(),((BannerImageUrlEntity.DataBean)model).getTitle());
                    }
                });
                BitmapCacheUtils.getInstance().display((ImageView) itemView,
                        ((BannerImageUrlEntity.DataBean)model).getImgUrl());
            }
        });
        mBanner.setData(R.layout.bga_image_view,dataBeans, Arrays.asList("","","","",""));
    }

    @Override
    public void onDisplayFastIndex(FastIndexEntity fastIndexEntity) {
        for(int i=0;i<fastIndexEntity.getData().getBrand().getItemList().size();i++) {
            View view = UIUtils.inflate(R.layout.activity_item_brand);
            ImageView iv = (ImageView) view.findViewById(R.id.iv_item_brand);
            iv.setOnClickListener(mHomeClickListener);
            BitmapCacheUtils.getInstance().display(iv,fastIndexEntity.getData().getBrand().getItemList().get(i).getIcon());
            TextView tv = (TextView) view.findViewById(R.id.tv_item_brand);
            tv.setText(fastIndexEntity.getData().getBrand().getItemList().get(i).getName());
            mLlItem.addView(view,params);
        }

        for(int i=0;i<fastIndexEntity.getData().getPrice().getItemList().size();i++){
            TextView tv = new TextView(UIUtils.getContext());
            tv.setOnClickListener(mHomeClickListener);
            tv.setId(R.id.tv_home_price);
            tv.setText(fastIndexEntity.getData().getPrice().getItemList().get(i).getName());
            tv.setTextColor(Color.rgb(4,4,4));
            tv.setTextSize(16);
            tv.setGravity(Gravity.CENTER_HORIZONTAL);
            mLlItemPriceRange.addView(tv,params);
        }

        for(int i=0;i<fastIndexEntity.getData().getPrice().getItemList().size();i++){
            TextView tv = new TextView(UIUtils.getContext());
            tv.setTextSize(16);
            tv.setId(R.id.tv_home_hot);
            tv.setOnClickListener(mHomeClickListener);
            tv.setTextColor(Color.rgb(4,4,4));
            tv.setGravity(Gravity.CENTER_HORIZONTAL);
            tv.setText(fastIndexEntity.getData().getHot().getItemList().get(i).getName());
            mLlItemTagTypes.addView(tv,params);
        }

        for(int i=0;i<fastIndexEntity.getData().getChannel().getItemList().size();i++){
            ImageView iv = new ImageView(UIUtils.getContext());
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            setClickToWebEvent(iv,R.id.iv_home_channel,fastIndexEntity.getData().getChannel().getItemList().get(i).getLink()
                    ,fastIndexEntity.getData().getChannel().getItemList().get(i).getTitle());
            BitmapCacheUtils.getInstance().display(iv,fastIndexEntity.getData().getChannel().getItemList().get(i).getImgUrl());
            mLlItemChannel.addView(iv,params);
        }

        for(int i=0;i<fastIndexEntity.getData().getLike().getItemList().size();i++) {
            ImageViewMatchWidth iv = new ImageViewMatchWidth(UIUtils.getContext());
            setClickToWebEvent(iv,R.id.iv_home_like,fastIndexEntity.getData().getLike().getItemList().get(i).getLink()
                    ,fastIndexEntity.getData().getLike().getItemList().get(i).getTitle());
            BitmapCacheUtils.getInstance().display(iv, fastIndexEntity.getData().getLike().getItemList().get(i).getImgUrl());
            if(i == 0 || i == 3){
                mLlItemLikeLeft.addView(iv,params2);
            }else{
                mLlItemLikeRight.addView(iv, params2);
            }
        }
        for(int i=0;i<fastIndexEntity.getData().getService_guarantee().size();i++) {
            View view = UIUtils.inflate(R.layout.activity_item_service_guarantee);
            setClickToWebEvent(view,R.id.iv_home_guaratee,fastIndexEntity.getData().getService_guarantee().get(i).getLink(),
                    fastIndexEntity.getData().getService_guarantee().get(i).getTitle());
            ImageView iv = (ImageView) view.findViewById(R.id.iv_item_service_guarantee);
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            BitmapCacheUtils.getInstance().display(iv,fastIndexEntity.getData().getService_guarantee().get(i).getImgUrl());
            TextView tv = (TextView) view.findViewById(R.id.tv_item_service_guarantee);
            tv.setText(fastIndexEntity.getData().getService_guarantee().get(i).getTitle());
            mLlItemServiceGuarantee.addView(view,params);
        }
    }

    @Override
    public void onDisplayHomeCar(HomeEntity homeEntity) {
        ImageView iv;
        TextView tvTtile;
        TextView tvDateHual;
        TextView tvPrice;
        for(int i=0;i<homeEntity.getData().get(0).getPostList().size();i++){
            View view = UIUtils.inflate(R.layout.activity_item_post_list);
            view.setOnClickListener(mHomeClickListener);
            iv = (ImageView)view.findViewById(R.id.iv_item_post_list);
            tvTtile = (TextView)view.findViewById(R.id.tv_item_post_title);
            tvDateHual = (TextView)view.findViewById(R.id.tv_item_post_date_hual);
            tvPrice = (TextView)view.findViewById(R.id.tv_item_post_price);
            tvTtile.setText(homeEntity.getData().get(0).getPostList().get(i).getTitle());
            tvDateHual.setText(homeEntity.getData().get(0).getPostList().get(i).getLicense_date());
            tvPrice.setText(homeEntity.getData().get(0).getPostList().get(i).getPrice());
            BitmapCacheUtils.getInstance().display(iv,homeEntity.getData().get(0).getPostList().get(i).getThumb_img());
            mLlItemPostList.addView(view);
        }
        mHomeMore.setOnClickListener(mHomeClickListener);
    }

    @Override
    public void onDisplayHomeTopic(TopicEntity topicEntity) {
        for(int i=0;i<topicEntity.getData().getTopline().getList().size();i++){
            View view = UIUtils.inflate(R.layout.activity_item_topic);
            setClickToWebEvent(view,R.id.tv_home_topic,topicEntity.getData().getTopline().getList().get(i).getUrl(),
                    topicEntity.getData().getTopline().getList().get(i).getTitle());
            TextView tag = (TextView)view.findViewById(R.id.tv_item_topic_tag);
            Shape shape = new RectShape();
            ShapeDrawable shapeDrawable = new ShapeDrawable(shape);
            shapeDrawable.getPaint().setColor(Color.parseColor(topicEntity.getData().getTopline().getList().get(i).getColor()));
            shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
            shapeDrawable.getPaint().setStrokeWidth(UIUtils.dip2px(1));
            TextView title = (TextView)view.findViewById(R.id.tv_item_topic_title);
            tag.setText(topicEntity.getData().getTopline().getList().get(i).getTag());
            tag.setTextColor(Color.parseColor(topicEntity.getData().getTopline().getList().get(i).getColor()));
            tag.setBackground(shapeDrawable);
            tag.setPadding(UIUtils.dip2px(4),0,UIUtils.dip2px(4),0);
            title.setText(topicEntity.getData().getTopline().getList().get(i).getTitle());
            mLlItemTopicDetails.addView(view);
        }
    }


    @Override
    public void onDisplayIndexActive(IndexActiveEntity indexActiveEntity) {
        setClickToWebEvent(mLindexActiveEvaluate,R.id.ll_evaluate,indexActiveEntity.getData().getAPP_INDEX_ACTIVE().get(0).getLink(),
                indexActiveEntity.getData().getAPP_INDEX_ACTIVE().get(0).getTitle());
    }

    @Override
    public void onResume() {
        super.onResume();
        mBanner.setAutoPlayAble(true);
    }

    @Override
    public void onPause() {
        super.onPause();
        mBanner.setAutoPlayAble(false);
    }

    @Override
    public void onUpdateLoadingPage(LoadingPage.ResultState resultState) {
        updatePage(resultState);
    }

    @OnClick({R.id.tv_see_more_good_car,R.id.ll_evaluate,R.id.ll_sell_free})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.tv_see_more_good_car:
                View eventView = new View(UIUtils.getContext());
                eventView.setId(R.id.ll_main_buy_car);
                EventBus.getDefault().post(eventView);
                break;
            case R.id.ll_sell_free:
                View eventViewSell = new View(UIUtils.getContext());
                eventViewSell.setId(R.id.ll_main_sell_car);
                EventBus.getDefault().post(eventViewSell);
                break;
        }
    }

    public void openLink(String url,String title){
        Intent intent = new Intent(UIUtils.getContext(),WebViewActivity.class);
        intent.putExtra("url",url);
        intent.putExtra("title",title);
        startActivity(intent);
    }

    public void setClickToWebEvent(View view,int id,String link,String title){
        view.setTag(R.id.tag_link,link);
        view.setTag(R.id.tag_titile,title);
        view.setId(id);
        view.setOnClickListener(mHomeClickListener);
    }

    public class HomeClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.tv_home_more:
                case R.id.tv_see_more_good_car:
                    EventBus.getDefault().post(new FragmentEvent(FragmentEvent.FRAGMENT_SELL_ID));
                    return;
                case R.id.iv_home_channel:
                case R.id.iv_home_guaratee:
                case R.id.iv_home_like:
                case R.id.tv_home_topic:
                case R.id.ll_evaluate:
                    if (view.getTag(R.id.tag_link) != null && view.getTag(R.id.tag_titile) != null){
                        openLink((String)view.getTag(R.id.tag_link), (String)view.getTag(R.id.tag_titile));
                    }
                    return;
                case R.id.iv_item_brand:
                case R.id.tv_home_price:
                case R.id.tv_home_hot:
                    View eventView = new View(UIUtils.getContext());
                    eventView.setId(R.id.ll_main_buy_car);
                    EventBus.getDefault().post(eventView);
                    return;
            }
            Intent intent = new Intent(UIUtils.getContext(),SourceDetailActivity.class);
            startActivity(intent);
        }
    }
}
