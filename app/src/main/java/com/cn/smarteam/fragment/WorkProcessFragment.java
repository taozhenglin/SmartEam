package com.cn.smarteam.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.smarteam.R;
import com.cn.smarteam.adapter.CommonAdapter;
import com.cn.smarteam.base.CommonViewHolder;
import com.cn.smarteam.base.Constants;
import com.cn.smarteam.base.MyApplication;
import com.cn.smarteam.bean.DxjWorkOrderListBean;
import com.cn.smarteam.bean.EquemtMaterialUsedListBean;
import com.cn.smarteam.bean.WorkProcessListBean;
import com.cn.smarteam.net.CallBackUtil;
import com.cn.smarteam.net.OkhttpUtil;
import com.cn.smarteam.utils.LogUtils;
import com.cn.smarteam.utils.SharedPreferencesUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

/**
 * Created by tzl
 * on 2021/1/12
 */
public class WorkProcessFragment extends Fragment {
    private final Context mContext;
    private final DxjWorkOrderListBean.DataBean.ListBean mListBean;
    private RefreshLayout refreshLayout;
    RecyclerView.LayoutManager layoutManager;
    private boolean isRefresh;
    private int currentPageNum = 1;
    private LoadingDialog ld;
    private ImageView nodata;
    RecyclerView recyclerView;
    private CommonAdapter<WorkProcessListBean.DataBean.ListBean> adapter;

    public WorkProcessFragment(Context context, DxjWorkOrderListBean.DataBean.ListBean listBean) {
        mContext = context;
        mListBean = listBean;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.work_process_fragment, container, false);
        nodata = view.findViewById(R.id.nodata);
        recyclerView = view.findViewById(R.id.recyclerView);
        refreshLayout = view.findViewById(R.id.refreshLayout);
        layoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initEvent();
    }

    private void initEvent() {
        ld = new LoadingDialog(mContext);
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
        ld.show();
        String url = Constants.BASE_URL + Constants.GET_WORK_PROCESS;
        HashMap<String, String> map = new HashMap<>();
        map.put("pageNum", currentPageNum + "");
        map.put("pageSize", 10 + "");
        map.put("woNum", mListBean.getWoNum());
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("authorization", SharedPreferencesUtil.getString(MyApplication.applicationContext, "authorization"));
        headermap.put("Content-Type", "application/json");
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();
                finishRefresh();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                finishRefresh();
                if (!response.isEmpty()) {
                    final WorkProcessListBean workProcessListBean = JSONObject.parseObject(response, new TypeReference<WorkProcessListBean>() {});
                    if (workProcessListBean.getCode() == 200) {
                        List<WorkProcessListBean.DataBean.ListBean> list = workProcessListBean.getData().getList();
                        LogUtils.d("222222 list.size()=" + list.size());
                        int totalpage = workProcessListBean.getData().getPages();
                        int total = workProcessListBean.getData().getTotal();
                        if (total > 0) {
                            if (currentPageNum == 1) {
                                if (adapter == null) {
                                    adapter = new CommonAdapter<WorkProcessListBean.DataBean.ListBean>(MyApplication.applicationContext, R.layout.work_process_list_item, list) {
                                        @Override
                                        public void convert(CommonViewHolder holder, WorkProcessListBean.DataBean.ListBean listBean) {
                                            TextView tv_no = holder.getView(R.id.tv_no);
                                            TextView tv_task_no = holder.getView(R.id.tv_task_no);
                                            TextView tv_time = holder.getView(R.id.tv_time);
                                            TextView tv_empty = holder.getView(R.id.tv_empty);
                                            TextView tv_desc = holder.getView(R.id.tv_desc);
                                            TextView tv_change_by = holder.getView(R.id.tv_change_by);
                                            TextView tv_change_time = holder.getView(R.id.tv_change_time);


                                            tv_no.setText("序号：" + listBean.getSeqNum());
                                            tv_task_no.setText("任务编号：" + listBean.getJobtaskNum());
                                            tv_time.setText("持续时间：" + listBean.getDuration());
                                            tv_desc.setText(listBean.getDescription());
                                            tv_change_by.setText("操作人：" + listBean.getChangeBy());
                                            tv_change_time.setText("操作时间：" + listBean.getChangeTime());

                                            holder.setTextSize(R.id.tv_no);
                                            holder.setTextSize(R.id.tv_task_no);
                                            holder.setTextSize(R.id.tv_time);
                                            holder.setTextSize(R.id.tv_empty);
                                            holder.setTextSize(R.id.tv_desc);
                                            holder.setTextSize(R.id.tv_change_by);
                                            holder.setTextSize(R.id.tv_change_time);
                                        }
                                    };
                                    recyclerView.setAdapter(adapter);

                                } else {
                                    adapter.setData(list);
                                    adapter.notifyDataSetChanged();
                                }
                            } else {
                                //不是第一页
                                if (currentPageNum <= totalpage) {
                                    adapter.addAllList(list);
                                    adapter.notifyDataSetChanged();
                                } else {
                                    ToastUtils.showShort("没有更多数据了");
                                }
                            }
                        }else {
                                nodata.setVisibility(View.VISIBLE);
                        }
                    } else {
                        ToastUtils.showShort(workProcessListBean.getMsg());

                    }
                }
            }
        });
    }


    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();
    }
}
