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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.smarteam.R;
import com.cn.smarteam.adapter.CommonAdapter;
import com.cn.smarteam.base.CommonViewHolder;
import com.cn.smarteam.base.Constants;
import com.cn.smarteam.bean.EquementListBean;
import com.cn.smarteam.bean.EqumetMatainWorkOrderListBean;
import com.cn.smarteam.net.CallBackUtil;
import com.cn.smarteam.net.OkhttpUtil;
import com.cn.smarteam.utils.LogUtils;
import com.cn.smarteam.utils.SharedPreferencesUtil;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

/**
 * Created by tzl
 * on 2021/1/6
 */
public class RePairFragment3 extends Fragment {
    private  EquementListBean.DataBean.ListBean mListBean;
    private Context mContext;
    private  int mType;
    RecyclerView recyclerView;
    SmartRefreshLayout refreshLayout;
    RecyclerView.LayoutManager layoutManager;
    private boolean isRefresh;
    private int currentPageNum = 1;
    private CommonAdapter<EqumetMatainWorkOrderListBean.DataBean.ListBean> adapter1;
    private ImageView nodata;
    private LoadingDialog ld;
    private CommonAdapter<EqumetMatainWorkOrderListBean.DataBean.ListBean> adapter2;
    private CommonAdapter<EqumetMatainWorkOrderListBean.DataBean.ListBean> adapter3;


    /**
     * @param context
     * @param listBean
     */
    public RePairFragment3(Context context, EquementListBean.DataBean.ListBean listBean) {
        mContext = context;
        mListBean = listBean;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.waitdo_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        refreshLayout = view.findViewById(R.id.refreshLayout);
        nodata = view.findViewById(R.id.nodata);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
    //点巡检工单
    private void query() {
        String url = Constants.BASE_URL + Constants.GET_ASSERT_WORKORDERS;
        HashMap<String, String> map = new HashMap<>();
        map.put("pageNum", currentPageNum + "");
        map.put("pageSize", 5 + "");
        map.put("assetNum", mListBean.getAssetNum());
        map.put("worktype", 3 + "");//点巡检
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("authorization", SharedPreferencesUtil.getString(mContext, "authorization"));
        headermap.put("Content-Type", "application/json");
        OkhttpUtil.okHttpGet(url, map,headermap, new CallBackUtil.CallBackString() {
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
                    final EqumetMatainWorkOrderListBean equmetMatainWorkOrderListBean = JSONObject.parseObject(response, new TypeReference<EqumetMatainWorkOrderListBean>() {});
                    if (equmetMatainWorkOrderListBean.getCode() == 200) {
                        List<EqumetMatainWorkOrderListBean.DataBean.ListBean> list = equmetMatainWorkOrderListBean.getData().getList();
                        LogUtils.d("222222 list.size()=" + list.size());
                        int totalpage = equmetMatainWorkOrderListBean.getData().getPages();
                        if (list.size() > 0) {
                            nodata.setVisibility(View.GONE);

                            if (currentPageNum == 1) {
                                if (adapter1 == null) {
                                    adapter1 = new CommonAdapter<EqumetMatainWorkOrderListBean.DataBean.ListBean>(mContext, R.layout.common_workorder_item, list) {
                                        @Override
                                        public void convert(CommonViewHolder holder, final EqumetMatainWorkOrderListBean.DataBean.ListBean listBean) {
                                            TextView tv_no = holder.getView(R.id.tv_no);
                                            TextView tv_order_no = holder.getView(R.id.tv_order_no);
                                            TextView tv_desc1 = holder.getView(R.id.tv_desc1);
                                            TextView tv_desc = holder.getView(R.id.tv_desc);
                                            TextView tv_lasttime = holder.getView(R.id.tv_lasttime);
                                            TextView tv_nexttime = holder.getView(R.id.tv_nexttime);
                                            TextView tv_unit = holder.getView(R.id.tv_unit);
                                            TextView tv_frequency = holder.getView(R.id.tv_frequency);

                                            tv_no.setText("行编号：" + listBean.getWorkOrderId());
                                            tv_order_no.setText("工单编号：" + listBean.getWoNum());
                                            tv_desc.setText(listBean.getDescription());
                                            tv_lasttime.setText("工单开始时间：" + listBean.getActualStartTime());
                                            tv_nexttime.setText("工单完成时间：" + listBean.getActualFinishTime());
                                            tv_unit.setText("工单类型：" + listBean.getSpotCheckTypeValue());
                                            tv_frequency.setVisibility(View.GONE);

                                            holder.setTextSize(R.id.tv_no);
                                            holder.setTextSize(R.id.tv_order_no);
                                            holder.setTextSize(R.id.tv_desc1);
                                            holder.setTextSize(R.id.tv_desc);
                                            holder.setTextSize(R.id.tv_lasttime);
                                            holder.setTextSize(R.id.tv_nexttime);
                                            holder.setTextSize(R.id.tv_unit);
                                            holder.setTextSize(R.id.tv_frequency);
                                        }

                                    };
                                    recyclerView.setAdapter(adapter1);

                                } else {
                                    adapter1.setData(list);
                                    adapter1.notifyDataSetChanged();
                                }
                            } else {
                                //不是第一页
                                if (currentPageNum <= totalpage) {
                                    adapter1.addAllList(list);
                                    adapter1.notifyDataSetChanged();
                                } else {
                                    ToastUtils.showShort("没有更多数据了");
                                }
                            }
                            if (adapter1.getData().size() == 0) {
                                nodata.setVisibility(View.VISIBLE);

                            }

                        } else {
                        }
                    }
                }else {

                }
            }
        });

    }

    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();
    }

}
