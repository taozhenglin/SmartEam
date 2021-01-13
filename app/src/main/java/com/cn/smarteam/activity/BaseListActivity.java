package com.cn.smarteam.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cn.smarteam.R;
import com.cn.smarteam.utils.NetWorkUtil;
import com.cn.smarteam.utils.StatusBarUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/**
 * Created by tzl
 * on 2020/12/16
 */
public abstract  class BaseListActivity extends AppCompatActivity implements View.OnClickListener {
     TextView tv_search;
     EditText edt_search1,edt_search2;
     RecyclerView recyclerView;
     SmartRefreshLayout refreshLayout;
     RecyclerView.LayoutManager layoutManager;
     LinearLayout ll_back;
     public TextView tv_common_title;
     TextView tv_title;
    ImageView iv_fun;
    ImageView nodata;
    ImageView iv_warm2;
    LinearLayout ll_top;
     View include2;
    ImageView iv_search1,iv_search2;
     Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_list_activity);
        mContext=this;
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);

        ll_back = findViewById(R.id.ll_back);
        ll_back.setOnClickListener(this);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_title = findViewById(R.id.tv_title);
        iv_fun= findViewById(R.id.iv_fun);
        edt_search1=findViewById(R.id.edt_search1);
        iv_search1=findViewById(R.id.iv_search1);
        iv_search1.setOnClickListener(this);
        edt_search2=findViewById(R.id.edt_search2);
        iv_search2=findViewById(R.id.iv_search2);
        iv_search2.setOnClickListener(this);

        tv_search=findViewById(R.id.tv_search);
        tv_search.setOnClickListener(this);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        refreshLayout = findViewById(R.id.refreshLayout);
        nodata=findViewById(R.id.nodata);
        iv_warm2=findViewById(R.id.iv_warm2);
        ll_top=findViewById(R.id.ll_top);
        include2=findViewById(R.id.include2);
        if (!NetWorkUtil.isConnected(this)){
            iv_warm2.setVisibility(View.VISIBLE);
            include2.setVisibility(View.GONE);
        }
        initView();
        initEvent();
    }

    public abstract void initView();
    public abstract void initEvent();
}
