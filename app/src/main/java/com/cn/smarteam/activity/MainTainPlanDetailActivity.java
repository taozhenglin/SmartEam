package com.cn.smarteam.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cn.smarteam.R;
import com.cn.smarteam.bean.EquementListBean;
import com.cn.smarteam.bean.MainTainPlanListBean;
import com.cn.smarteam.utils.StatusBarUtils;

/**
 * Created by tzl
 * on 2021/1/11
 */
public class MainTainPlanDetailActivity extends AppCompatActivity {
    private MainTainPlanListBean.DataBean.ListBean listBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);
        listBean = (MainTainPlanListBean.DataBean.ListBean) getIntent().getExtras().get("listBean");
        initView();
        initEvent();
    }

    private void initEvent() {
    }

    private void initView() {
    }
}
