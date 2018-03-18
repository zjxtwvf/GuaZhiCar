package com.terminator.zjxtwvf.guazi.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.terminator.zjxtwvf.guazi.R;
import com.terminator.zjxtwvf.guazi.view.fragment.SourceDetailFragment;


/**
 * Created by Administrator on 2017/12/24.
 */

public class SourceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_detail);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        SourceDetailFragment sourceDetailFragment = new SourceDetailFragment();
        fragmentTransaction.add(R.id.fl_detail_activity,sourceDetailFragment);

        fragmentTransaction.commit();
    }
}
