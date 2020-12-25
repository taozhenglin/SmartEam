package com.cn.smarteam.activity;

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

import com.cn.myapplication.R;
import com.cn.smarteam.utils.NetWorkUtil;
import com.cn.smarteam.utils.StatusBarUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/**
 * Created by tzl
 * on 2020/12/16
 */
public abstract  class BaseListActivity extends AppCompatActivity {
     TextView tv_search;
     EditText edt_search;
     RecyclerView recyclerView;
     SmartRefreshLayout refreshLayout;
     RecyclerView.LayoutManager layoutManager;
    private LinearLayout ll_back;
    private TextView tv_common_title;
    private TextView tv_title;
    ImageView iv_fun;
    ImageView iv_warm;
    ImageView iv_warm2;
    LinearLayout ll_top;
     View include2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_list_activity);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);

        ll_back = findViewById(R.id.ll_back);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_title = findViewById(R.id.tv_title);
        iv_fun= findViewById(R.id.iv_fun);
        edt_search=findViewById(R.id.edt_search);
        tv_search=findViewById(R.id.tv_search);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        refreshLayout = findViewById(R.id.refreshLayout);
        iv_warm=findViewById(R.id.iv_warm);
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
