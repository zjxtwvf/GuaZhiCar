package com.terminator.zjxtwvf.guazi.view.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

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

    private int RATIO = 3;

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
    public boolean onTouchEvent(MotionEvent ev) {
        if(null == mHeadView || !mRefreshSurpport || mRereshState == REFRESH_ING){
            return super.onTouchEvent(ev);
        }
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                mDownY = ev.getY();
                System.out.println("MotionEvent.ACTION_DOWN:  "    +mDownY);
                break;
            case MotionEvent.ACTION_MOVE:
                dis = ev.getY() - mDownY;
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
                    System.out.println("正常高度----------->  mViewHeight ：" + mViewHeight);
                    System.out.println("dis  :" + dis   +"        mDownY"   +mDownY);
                    System.out.println("dis  :" + dis   +"        pading top "   +(-mViewHeight + Math.round(dis)));

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
                //刷新状态
                if(((int)dis)/RATIO < mViewHeight){
                    mRereshState = REFRESH_RETURN;
                }else{
                    mRereshState = REFRESH_RELEASE;
                }

                if(REFRESH_RELEASE == mRereshState){
                    //还原正常高度
                    System.out.println("还原正常高度----------->  mViewHeight ：" + mViewHeight);
                    mHeadView.setPadding(0,0,0,0);
                    //开启动画
                    //刷新
                    mRereshState = REFRESH_ING;
                    if(mOnRereshStateChangeListener != null){
                        mOnRereshStateChangeListener.onRereshStateChange(mRereshState);
                    }
                }else{
                    //还原
                    System.out.println("还原----------->");
                    mRereshState = REFRESH_NO;
                    //停止动画
                    mHeadView.setPadding(0,-mViewHeight,0,0);

                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    public void onRereshFinished(int state){
        mRereshState = state;
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
