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

    private static final int REFRESH_NO = 0;
    private static final int REFRESH_ING = 1;
    private static final int REFRESH_ERROR = 2;
    private static final int REFRESH_SUCESS = 3;

    private  View mView = null;
    private  boolean mRefreshSurpport = true;
    private  int mViewHeight = 0;
    private  int mRereshState = REFRESH_NO;

    public RefreshRecyclerView(Context context) {
        super(context);
    }

    public RefreshRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RefreshRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private  float mDownY = 0f;
    private  float dis = 0f;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        mView = getChildAt(0);
        mViewHeight =getMeasuredHeight();
        if(null == mView || !mRefreshSurpport){
            return super.dispatchTouchEvent(ev);
        }
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                mDownY = ev.getY();
                System.out.println("MotionEvent.ACTION_DOWN:  "    +mDownY);
                break;
            case MotionEvent.ACTION_MOVE:
                View firstView = getChildAt(0);
                float firstViewPos = firstView.getY();
                if(firstViewPos >= 0){
                    dis = ev.getY() - mDownY;
                    //未刷新状态下  才能开始下拉
                    if(mRereshState == REFRESH_NO){
                        System.out.println("正常高度----------->  mViewHeight ：" + mViewHeight);
                        System.out.println("dis  :" + dis   +"        mDownY"   +mDownY);
                        mView.setPadding(0,-mViewHeight + Math.round(dis),0,0);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                if(Math.round(dis) > mViewHeight){
                    //还原正常高度
                    System.out.println("还原正常高度----------->  mViewHeight ：" + mViewHeight);
                    mView.setPadding(0,0,0,0);
                    //开启动画
                    //刷新
                    mRereshState = REFRESH_ING;
                }
                else{
                    //还原
                    System.out.println("还原----------->");
                    if(mRereshState == REFRESH_NO){
                        //停止动画
                        mView.setPadding(0,-mViewHeight,0,0);
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

}
