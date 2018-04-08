package com.terminator.zjxtwvf.guazi.view.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.terminator.zjxtwvf.guazi.util.UIUtils;

/**
 * Created by Administrator on 2018/4/1.
 */

public class RefreshRecyclerView extends RecyclerView {

    public static final int REFRESH_NO = 0;
    public static final int REFRESH_PULL = 1;
    public static final int REFRESH_ING = 2;
    public static final int REFRESH_ERROR = 3;
    public static final int REFRESH_SUCESS = 4;
    public static final int REFRESH_RELEASE = 5;
    public static final int REFRESH_RETURN = 6;

    private int RATIO = 2;

    private  View mHeadView = null;
    private  boolean mRefreshSurpport = true;
    private  int mViewHeight = 0;
    private  int mRereshState = REFRESH_NO;
    private  OnRereshStateChangeListener mOnRereshStateChangeListener;

    public RefreshRecyclerView(Context context) {
        super(context);
    }

    public RefreshRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RefreshRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setHeadView(View headView){
        mHeadView = headView;
        mHeadView.measure(0,0);
        mViewHeight = mHeadView.getMeasuredHeight();
        mHeadView.setPadding(0,-mViewHeight,0,0);
    }

    private  float mDownY = 0f;
    private  float dis = 0f;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                mDownY = ev.getY();
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(mRereshState == REFRESH_ING){
            return true;
        }
        if(null == mHeadView || !mRefreshSurpport){
            return super.onTouchEvent(ev);
        }
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                mDownY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                dis = Math.round(ev.getY() - mDownY);
                if(dis < 0){
                    return super.onTouchEvent(ev);
                }
                if(!canScrollVertically(-1) || mRereshState == REFRESH_PULL){
                    //未刷新状态下  才能开始下拉
                    if(mRereshState == REFRESH_NO ){
                        if(dis > 0){
                            mRereshState = REFRESH_PULL;//下拉状态
                        }
                    }
                    //处于下拉状态可以上下拖动刷新布局
                    if(mRereshState == REFRESH_PULL){
                        mHeadView.setPadding(0,((int)dis)/RATIO - mViewHeight,0,0);
                        //搬运距离小于刷新布局  刷新布局内容为继续下拉即可刷新数据  反之松开即可刷新
                        if(((int)dis)/RATIO < mViewHeight){
                            if(mOnRereshStateChangeListener != null){
                                mOnRereshStateChangeListener.onRereshStateChange(REFRESH_RETURN);
                            }
                        }else{
                            if(mOnRereshStateChangeListener != null){
                                mOnRereshStateChangeListener.onRereshStateChange(REFRESH_RELEASE);
                            }
                        }
                    }
                    //消费该事件
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                if(mRereshState == REFRESH_PULL){
                    //刷新状态
                    if(((int)dis)/RATIO < mViewHeight){
                        mRereshState = REFRESH_RETURN;
                    }else{
                        mRereshState = REFRESH_RELEASE;
                    }

                    if(REFRESH_RELEASE == mRereshState){
                        //还原正常高度
                        scrollAnimaionRefresh(((int)dis)/RATIO - mViewHeight,0,200);
                        mRereshState = REFRESH_ING;
                        if(mOnRereshStateChangeListener != null){
                            mOnRereshStateChangeListener.onRereshStateChange(mRereshState);
                        }
                    }else{
                        //还原
                        mRereshState = REFRESH_NO;
                        scrollAnimaionRefresh(((int)dis)/RATIO - mViewHeight,-mViewHeight,200);
                    }
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    private void scrollAnimaionRefresh(int curLocation, int toLocation, int duration) {
        ValueAnimator animator_relase_torefresh = ValueAnimator.ofInt(curLocation, toLocation);
        animator_relase_torefresh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mHeadView.setPadding(0,(int)valueAnimator.getAnimatedValue(),0,0);
            }
        });
        animator_relase_torefresh.setDuration(duration);
        animator_relase_torefresh.start();
    }

    public void onRereshFinished(int state){
        mRereshState = state;
        if(REFRESH_SUCESS == mRereshState){
            scrollAnimaionRefresh(0,-mViewHeight,200);
        }else if(REFRESH_ERROR == mRereshState){
            scrollAnimaionRefresh(0,-mViewHeight,200);
        }
        if(mOnRereshStateChangeListener != null){
            mOnRereshStateChangeListener.onRereshStateChange(mRereshState);
        }
        mRereshState = REFRESH_NO;
    }

    public void setRereshStateChangeListener(OnRereshStateChangeListener stateChangeListener){
        mOnRereshStateChangeListener = stateChangeListener;
    }

    public interface OnRereshStateChangeListener{
        void onRereshStateChange(int state);
    }
}
