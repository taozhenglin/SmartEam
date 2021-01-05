package com.cn.smarteam.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cn.smarteam.R;
import com.cn.smarteam.base.CommonViewHolder;
import com.cn.smarteam.adapter.CommonAdapter;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzl
 * on 2020/12/16
 */
public class OrderListActivity extends BaseListActivity {
    private boolean isRefresh;
    private int currentPageNum=1;
    List<String> lists;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {


    }

    @Override
    public void initEvent() {
        lists=new ArrayList<>();
        lists.add("1");
        lists.add("2");
        lists.add("3");
        lists.add("4");
        query();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
                query();


            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                query();

            }
        });


    }

    private void query() {
        if (lists.size()>0){
            nodata.setVisibility(View.GONE);
            refreshLayout.setVisibility(View.VISIBLE);
            include2.setVisibility(View.VISIBLE);
        }else {
            //无数据
            nodata.setVisibility(View.VISIBLE);
            refreshLayout.setVisibility(View.GONE);
            include2.setVisibility(View.GONE);
        }
        recyclerView.setAdapter(new CommonAdapter<String>(this, R.layout.waitdo_list_item,lists) {
            @Override
            public void convert(CommonViewHolder holder, String s) {
                TextView tv_no = holder.getView(R.id.tv_no);
                tv_no.setText(s);
                holder.setTextSize(R.id.tv_no);
                holder.setTextSize(R.id.tv_statue);
                holder.setTextSize(R.id.tv_type);
                holder.setTextSize(R.id.tv_desc);
                holder.setTextSize(R.id.tv_dute);
                holder.setTextSize(R.id.tv_date);
            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}
