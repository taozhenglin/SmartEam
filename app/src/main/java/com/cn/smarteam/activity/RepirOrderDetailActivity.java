package com.cn.smarteam.activity;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cn.smarteam.bean.DxjWorkOrderListBean;

/**
 * Created by tzl
 * on 2021/1/13
 */
public class RepirOrderDetailActivity extends AppCompatActivity {
    DxjWorkOrderListBean.DataBean.ListBean listBean;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getIntent().getExtras().get("data")!=null)){
            listBean= (DxjWorkOrderListBean.DataBean.ListBean) getIntent().getExtras().get("data");
        }

    }
}
