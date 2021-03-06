package com.terminator.zjxtwvf.guazi.view.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.terminator.zjxtwvf.guazi.R;
import com.terminator.zjxtwvf.guazi.util.UIUtils;

/**
 * Created by Administrator on 2018/1/5.
 */

public abstract class LoadingPage extends FrameLayout{

    private static final int STATE_LOAD_UNDO = 1;// 未加载
    private static final int STATE_LOAD_LOADING = 2;// 正在加载
    private static final int STATE_LOAD_ERROR = 3;// 加载失败
    private static final int STATE_LOAD_EMPTY = 4;// 数据为空
    private static final int STATE_LOAD_SUCCESS = 5;// 加载成功

    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);

    private int mCurrentState = STATE_LOAD_UNDO;// 当前状态

    private View mLoadingPage;
    private View mErrorPage;
    private View mEmptyPage;
    private View mSuccessPage;

    private ImageView loadingAnima;

    public LoadingPage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    public LoadingPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LoadingPage(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        // 初始化加载中的布局
        if (mLoadingPage == null) {
            mLoadingPage = UIUtils.inflate(R.layout.loading_page);
            loadingAnima = (ImageView) mLoadingPage.findViewById(R.id.iv_loading_page);
            ((AnimationDrawable)loadingAnima.getDrawable()).start();
            addView(mLoadingPage,params);// 将加载中的布局添加给当前的帧布局
        }

        // 初始化加载失败布局
        if (mErrorPage == null) {
            mErrorPage = UIUtils.inflate(R.layout.loading_error);
            loadingAnima = (ImageView) mErrorPage.findViewById(R.id.iv_loading_error);
            ((AnimationDrawable)loadingAnima.getDrawable()).start();
            // 点击重试事件
            Button btnRetry = (Button) mErrorPage.findViewById(R.id.bt_refresh_load);
            btnRetry.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 重新加载网络数据
                    mCurrentState = STATE_LOAD_LOADING;
                    showRightPage();
                    mCurrentState = STATE_LOAD_UNDO;
                    loadData();
                }
            });
            addView(mErrorPage,params);
        }

        // 初始化数据
        if (mSuccessPage == null) {
            mSuccessPage = onCreateSuccessView();
        }

        // 初始化数据为空布局
        if (mEmptyPage == null) {
            mEmptyPage = UIUtils.inflate(R.layout.loading_error);
            addView(mEmptyPage,params);
        }
        showRightPage();
    }

    public void updatePage(final ResultState  resultState){
        UIUtils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                if (resultState != null) {
                    mCurrentState = resultState.getState();// 网络加载结束后,更新网络状态
                    // 根据最新的状态来刷新页面
                    showRightPage();
                }
            }
        });
    }

    // 根据当前状态,决定显示哪个布局
    private void showRightPage() {
        mLoadingPage
                .setVisibility((mCurrentState == STATE_LOAD_UNDO || mCurrentState == STATE_LOAD_LOADING) ? View.VISIBLE
                        : View.GONE);
        mErrorPage
                .setVisibility(mCurrentState == STATE_LOAD_ERROR ? View.VISIBLE
                        : View.GONE);
        mEmptyPage
                .setVisibility(mCurrentState == STATE_LOAD_EMPTY ? View.VISIBLE
                        : View.GONE);
        // 当成功布局为空,并且当前状态为成功,才初始化成功的布局
        if (mCurrentState == STATE_LOAD_SUCCESS) {
            if (mSuccessPage != null) {
                addView(mSuccessPage);
            }
        }

        if (mSuccessPage != null && mCurrentState == STATE_LOAD_SUCCESS) {
            mSuccessPage
                    .setVisibility(mCurrentState == STATE_LOAD_SUCCESS ? View.VISIBLE
                            : View.GONE);
            ((AnimationDrawable)loadingAnima.getDrawable()).stop();
        }
    }

    // 开始加载数据
    public void loadData() {
        if (mCurrentState != STATE_LOAD_LOADING) {// 如果当前没有加载, 就开始加载数据
            mCurrentState = STATE_LOAD_LOADING;
            mSuccessPage = onCreateSuccessView();
            onLoad();
        }
    }

    // 加载成功后显示的布局, 必须由调用者来实现
    public abstract View onCreateSuccessView();

    // 加载网络数据, 返回值表示请求网络结束后的状态
    public abstract ResultState onLoad();

    public enum ResultState {
        STATE_SUCCESS(STATE_LOAD_SUCCESS), STATE_EMPTY(STATE_LOAD_EMPTY), STATE_ERROR(
                STATE_LOAD_ERROR);
        private int state;

        ResultState(int state) {
            this.state = state;
        }
        public int getState() {
            return state;
        }
    }
}
