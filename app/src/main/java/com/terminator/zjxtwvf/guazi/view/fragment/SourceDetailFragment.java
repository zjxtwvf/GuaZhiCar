package com.terminator.zjxtwvf.guazi.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.terminator.zjxtwvf.guazi.R;
import com.terminator.zjxtwvf.guazi.app.MyApplication;
import com.terminator.zjxtwvf.guazi.di.components.DaggerSourceDetailComponent;
import com.terminator.zjxtwvf.guazi.di.modules.SourceDetailModule;
import com.terminator.zjxtwvf.guazi.model.entity.SourceDetailEntity;
import com.terminator.zjxtwvf.guazi.presenter.SourceDetailContract;
import com.terminator.zjxtwvf.guazi.presenter.SourceDetailPresenter;
import com.terminator.zjxtwvf.guazi.util.BitmapCacheUtils;
import com.terminator.zjxtwvf.guazi.util.UIUtils;
import com.terminator.zjxtwvf.guazi.view.widget.LoadingPage;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by Administrator on 2017/12/24.
 */

public class SourceDetailFragment extends BaseFragment implements SourceDetailContract.View{

    private View mRootView;

    @Inject
    SourceDetailPresenter mSourceDetailPresenter;

    @Bind(R.id.banner_source_content)
    BGABanner mBanner;
    @Bind(R.id.tv_source_title)
    TextView mSourceTitle;
    @Bind(R.id.ll_detail_hot_item)
    LinearLayout mHotItem;
    @Bind(R.id.tv_detail_price)
    TextView mDetailPrice;
    @Bind(R.id.tv_evaluate_tips_desc)
    TextView mEvaluateTipsDesc;
    @Bind(R.id.tv_detail_qulaty)
    TextView mDetailQulaty;
    @Bind(R.id.tv_detail_new_price)
    TextView mDetailNewPrice;
    @Bind(R.id.tv_evaluate_desc)
    TextView mEvaluateDesc;
    @Bind(R.id.tv_seller_description)
    TextView mSellerDesc;
    @Bind(R.id.ll_detail_imagelist)
    LinearLayout mImageList;
    @Bind(R.id.ll_guess_you_like)
    LinearLayout mGuessYouLike;
    @Bind(R.id.ll_detail_service_item)
    LinearLayout mServiceItem;
    @Bind(R.id.ll_service_desc)
    LinearLayout mServiceDesc;
    @Bind(R.id.ll_service_desc_tags)
    LinearLayout mServiceDescTags;
    @Bind(R.id.ll_seller)
    LinearLayout mSeller;
    @Bind(R.id.ll_highlight_config_item)
    LinearLayout mHighlightConfigItem;
    @Bind(R.id.ll_service_summary)
    LinearLayout mServiceSummary;
    @Bind(R.id.ll_evaluate_item)
    LinearLayout mEvaluateItem;
    @Bind(R.id.ll_detail_baomai)
    LinearLayout mBaoMai;


    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,1);
    LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
    LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,UIUtils.dip2px(60));

    SourceDetailClickListener mClickListener = null;

    public  SourceDetailFragment(){
        super();
        DaggerSourceDetailComponent.builder()
                .netComponent(MyApplication.getContext().getNetComponent())
                .sourceDetailModule(new SourceDetailModule(this))
                .build()
                .Inject(SourceDetailFragment.this);
        mClickListener = new SourceDetailClickListener();
    }
    @Override
    public void onUpdateLoadingPage(LoadingPage.ResultState resultState) {
        updatePage(resultState);
    }

    @Override
    public View onCreateSuccessView() {
        mRootView = UIUtils.inflate(R.layout.activity_source_detail_fragment);
        ButterKnife.bind(this,mRootView);
        return mRootView;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        mSourceDetailPresenter.getSourceDetail();
        return null;
    }

    @Override
    public void onDisplaySourceDetail(SourceDetailEntity sourceDetailEntity) {
        mBanner.setAdapter(new BGABanner.Adapter<ImageView,SourceDetailEntity.DataBean.ImageCategoryListBean.ImagesBeanX>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView,
                                       SourceDetailEntity.DataBean.ImageCategoryListBean.ImagesBeanX model, int position) {
                BitmapCacheUtils.getInstance().display(itemView,model.getImage());
            }
        });
        List<String> tips = new ArrayList<String>();
        tips.add(sourceDetailEntity.getData().getClue_id_str());
        mBanner.setData(sourceDetailEntity.getData().getImageCategoryList().get(0).getImages(),tips);

        mSourceTitle.setText(sourceDetailEntity.getData().getTitle());
        mSourceTitle.getPaint().setFakeBoldText(true);
        mDetailQulaty.getPaint().setFakeBoldText(true);
        mEvaluateTipsDesc.setText("*"+sourceDetailEntity.getData().getEvaluate_tips_desc());

        for(int i=0;i<sourceDetailEntity.getData().getCar_hot_params().size();i++){
            TextView tv = new TextView(UIUtils.getContext());
            tv.setText(sourceDetailEntity.getData().getCar_hot_params().get(i).getTitle());
            tv.setTextColor(Color.parseColor(sourceDetailEntity.getData().getCar_hot_params().get(i).getColor()));
            mHotItem.addView(tv);
        }

        mDetailPrice.setText(sourceDetailEntity.getData().getPrice()+"万");
        mDetailNewPrice.setText("新车含税"+sourceDetailEntity.getData().getNew_price()+"万");
        mDetailNewPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        mEvaluateDesc.setText(sourceDetailEntity.getData().getEvaluator_desc());

        if(!sourceDetailEntity.getData().getBaomai().getImage().equals("")){
            View view = UIUtils.inflate(R.layout.baomai_layout_item);
            ImageView iv = (ImageView)view.findViewById(R.id.iv_baomai);
            BitmapCacheUtils.getInstance().displayMatchWidth(iv,sourceDetailEntity.getData().getBaomai().getImage());
            TextView tv = (TextView)view.findViewById(R.id.tv_baomai_distance);
            tv.setText(sourceDetailEntity.getData().getBm_address().getDistance());
            tv = (TextView)view.findViewById(R.id.tv_baomai_addr);
            tv.setText(sourceDetailEntity.getData().getBm_address().getTitle());
            mBaoMai.addView(view,params1);
        }

        for(int i=0;i<sourceDetailEntity.getData().getImageList().size();i++){
            View view = UIUtils.inflate(R.layout.source_detail_image_list_item);
            ImageView iv = (ImageView)view.findViewById(R.id.iv_source_detail_item);
            if(0 == sourceDetailEntity.getData().
                    getImageList().get(i).getImages().size()){
                continue;
            }
            BitmapCacheUtils.getInstance().displayMatchWidth(iv,sourceDetailEntity.getData().
                    getImageList().get(i).getImages().get(0).getImage());
            TextView tv = (TextView)view.findViewById(R.id.tv_source_detail_item_desc);
            tv.setText(sourceDetailEntity.getData().getImageList().get(i).getCategory_desc());
            tv = (TextView)view.findViewById(R.id.tv_source_detail_item_catogery);
            tv.setText(sourceDetailEntity.getData().getImageList().get(i).getCategory());
            mImageList.addView(view);
        }

        ImageView iv;
        TextView tvTtile;
        TextView tvDateHual;
        TextView tvPrice;
        for(int i=0;i<sourceDetailEntity.getData().getRecommend().size();i++){
            View view = UIUtils.inflate(R.layout.activity_item_post_list);
            view.setOnClickListener(mClickListener);
            iv = (ImageView)view.findViewById(R.id.iv_item_post_list);
            tvTtile = (TextView)view.findViewById(R.id.tv_item_post_title);
            tvDateHual = (TextView)view.findViewById(R.id.tv_item_post_date_hual);
            tvPrice = (TextView)view.findViewById(R.id.tv_item_post_price);
            tvTtile.setText(sourceDetailEntity.getData().getRecommend().get(i).getTitle());
            tvDateHual.setText(sourceDetailEntity.getData().getRecommend().get(i).getLicense_date());
            tvPrice.setText(sourceDetailEntity.getData().getRecommend().get(i).getPrice());
            BitmapCacheUtils.getInstance().display(iv,sourceDetailEntity.getData().getRecommend().get(i).getThumb_img());
            mGuessYouLike.addView(view);
        }

        for(int i=0;i<sourceDetailEntity.getData().getService_item().size();i++){
            View view = UIUtils.inflate(R.layout.activity_item_service_guarantee);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_service_guarantee);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            BitmapCacheUtils.getInstance().display(imageView,sourceDetailEntity.getData().getService_item().get(i).getImage());
            TextView tv = (TextView) view.findViewById(R.id.tv_item_service_guarantee);
            tv.setText(sourceDetailEntity.getData().getService_item().get(i).getTitle());
            mServiceItem.addView(view,params);
        }

        for(int i=0;i<sourceDetailEntity.getData().getService().getService_desc().size();i++){
            View view = UIUtils.inflate(R.layout.activity_item_service_guarantee);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_service_guarantee);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            BitmapCacheUtils.getInstance().display(imageView,sourceDetailEntity.getData().getService().getService_desc().get(i).getIcon());
            TextView tv = (TextView) view.findViewById(R.id.tv_item_service_guarantee);
            tv.setText(sourceDetailEntity.getData().getService().getService_desc().get(i).getText());
            mServiceDesc.addView(view,params);
        }

        for(int i=0;i<sourceDetailEntity.getData().getService().getService_desc().get(0).getTags().size();i++){
            View view = UIUtils.inflate(R.layout.source_detail_service_desc_tags_item);
            TextView tv = (TextView) view.findViewById(R.id.tv_service_tag_title);
            tv.setText(sourceDetailEntity.getData().getService().getService_desc().get(0).getTags().get(i).getDesc());
            TextView tv1 = (TextView) view.findViewById(R.id.tv_service_tag_desc);
            if(null != sourceDetailEntity.getData().getService().getService_desc().get(0).getTags().get(i).getColor()){
                tv1.setTextColor(Color.parseColor(sourceDetailEntity.getData().getService().getService_desc().get(0).getTags().get(i).getColor()));
            }
            tv1.setText(sourceDetailEntity.getData().getService().getService_desc().get(0).getTags().get(i).getTitle());
            mServiceDescTags.addView(view,params);
        }

        for(int i=0;i<sourceDetailEntity.getData().getHighlight_config_item().size();i++){
            View view = UIUtils.inflate(R.layout.highlight_config_item_item);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_highlight_item);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            BitmapCacheUtils.getInstance().display(imageView,sourceDetailEntity.getData().getHighlight_config_item().get(i).getImage());
            TextView tv = (TextView) view.findViewById(R.id.tv_highlight_item);
            tv.setText(sourceDetailEntity.getData().getHighlight_config_item().get(i).getTitle());
            mHighlightConfigItem.addView(view,params);
        }
        if(sourceDetailEntity.getData().getHighlight_config_item().size() < 4){
            for(int i=0;i<(4 - sourceDetailEntity.getData().getHighlight_config_item().size());i++){
                View view = UIUtils.inflate(R.layout.highlight_config_item_item);
                mHighlightConfigItem.addView(view,params);
            }
        }

        /*
        for(int i=0;i<sourceDetailEntity.getData().getSummary().size()/3 + 1;i++){
            View view = UIUtils.inflate(R.layout.service_summary_item);
            for(int j=0;j<3;j++){
                View item = null;
                if(0==j){
                    item = view.findViewById(R.id.summary_item_item0);
                }else if(1==j){
                    item = view.findViewById(R.id.summary_item_item1);
                }else{
                    item = view.findViewById(R.id.summary_item_item2);
                }
                TextView lable = (TextView) item.findViewById(R.id.tv_lable);
                TextView value = (TextView) item.findViewById(R.id.tv_value);
                lable.setText(sourceDetailEntity.getData().getSummary().get(i).getLabel());
                value.setText(sourceDetailEntity.getData().getSummary().get(i).getValue());
            }
            mServiceSummary.addView(view,params1);
        }
        */
        mSellerDesc.setText(sourceDetailEntity.getData().getSeller_description());

        for(int i=0;i<sourceDetailEntity.getData().getEvaluate_items().size();i++){
            View view = UIUtils.inflate(R.layout.evaluate_items_item);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_evaluate_item_icon);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            BitmapCacheUtils.getInstance().display(imageView,sourceDetailEntity.getData().getEvaluate_items().get(i).getIcon());
            TextView tv = (TextView) view.findViewById(R.id.tv_evaluate_title);
            tv.setText(sourceDetailEntity.getData().getEvaluate_items().get(i).getTitle());
            TextView count = (TextView) view.findViewById(R.id.tv_evaluate_count);
            count.setText(sourceDetailEntity.getData().getEvaluate_items().get(i).getCount()+"项");
            if(sourceDetailEntity.getData().getEvaluate_items().get(i).getFails() != 0){
                TextView fail = (TextView) view.findViewById(R.id.tv_evaluate_fail);
                fail.setVisibility(View.VISIBLE);
                fail.setText(sourceDetailEntity.getData().getEvaluate_items().get(i).getFails()+"项");
            }
            mEvaluateItem.addView(view,params2);
        }

    }

    class SourceDetailClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(UIUtils.getContext(),SourceDetailFragment.class);
            startActivity(intent);
        }
    }
}
