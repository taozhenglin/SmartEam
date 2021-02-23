package com.cn.smarteam.activity;

import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.smarteam.R;
import com.cn.smarteam.adapter.CommonAdapter;
import com.cn.smarteam.base.CommonViewHolder;
import com.cn.smarteam.base.Constants;
import com.cn.smarteam.base.MyApplication;
import com.cn.smarteam.bean.DxjWorkOrderListBean;
import com.cn.smarteam.bean.FaultListBean;
import com.cn.smarteam.bean.PostData;
import com.cn.smarteam.net.CallBackUtil;
import com.cn.smarteam.net.OkhttpUtil;
import com.cn.smarteam.utils.HighLightUtils;
import com.cn.smarteam.utils.LogUtils;
import com.cn.smarteam.utils.SharedPreferencesUtil;
import com.google.android.material.internal.BaselineLayout;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

/**
 * Created by tzl
 * on 2021/1/15
 */
public class FaultListActivity extends BaseListActivity {
    private int currentPageNum = 1;
    private boolean isRefresh;
    private CommonAdapter<FaultListBean.DataBean.ListBean> adapter;
    private LoadingDialog ld;

    @Override
    public void initView() {

        tv_common_title.setText("故障知识库");
        edt_search1.setHint("故障编号");
        edt_search2.setHint("故障描述");
    }

    @Override
    public void initEvent() {
        ld = new LoadingDialog(this);

        query(0);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
                if (TextUtils.isEmpty(edt_search1.getText().toString()) && TextUtils.isEmpty(edt_search2.getText().toString())) {
                    query(0);
                } else
                    query(3);


            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                if (TextUtils.isEmpty(edt_search1.getText().toString()) && TextUtils.isEmpty(edt_search2.getText().toString())) {
                    query(0);
                } else
                    query(3);

            }
        });
    }

    private void query(int searchType) {
        ld.show();
        String url;
        String assetNum = edt_search1.getText().toString();
        String description = edt_search2.getText().toString();
        if (searchType == 3) {
            url = Constants.BASE_URL + Constants.FAULT_LIST_SEARCH;//模糊搜索
        } else {
            url = Constants.BASE_URL + Constants.FAULT_LIST;//搜索全部

        }
        HashMap<String, String> map = new HashMap<>();
        map.put("pageNum", currentPageNum + "");
        map.put("pageSize", 10 + "");
        map.put("type", "1");

        if (searchType == 3) {
            map.put("failureNum", assetNum);
            map.put("description", description);

        }
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
                    final FaultListBean faultListBean = JSONObject.parseObject(response, new TypeReference<FaultListBean>() {});
                    if (faultListBean.getCode() == 200) {
                        int total = faultListBean.getData().getTotal();
                        int totalpage = faultListBean.getData().getPages();
                        if (total > 0) {
                              List<FaultListBean.DataBean.ListBean> list = faultListBean.getData().getList();
                            LogUtils.d("222222 list.size()==" + list.size());
                            nodata.setVisibility(View.GONE);
                            if (currentPageNum == 1) {
                                if (adapter == null) {
                                    adapter = new CommonAdapter<FaultListBean.DataBean.ListBean>(MyApplication.applicationContext, R.layout.equipment_list_item, list) {
                                        @Override
                                        public void convert(CommonViewHolder holder, final FaultListBean.DataBean.ListBean listBean) {
                                            CardView cardview = holder.getView(R.id.cardview);
                                            TextView tv_empty = holder.getView(R.id.tv_empty);
                                            TextView tv_no = holder.getView(R.id.tv_no);
                                            TextView tv_statue = holder.getView(R.id.tv_statue);
                                            TextView tv_type = holder.getView(R.id.tv_type);
                                            TextView tv_own_company = holder.getView(R.id.tv_own_company);
                                            TextView tv_desc = holder.getView(R.id.tv_desc);
                                            TextView tv_dute = holder.getView(R.id.tv_dute);
                                            TextView tv_date = holder.getView(R.id.tv_date);
                                            SpannableString highlight = HighLightUtils.highlight(MyApplication.applicationContext, "故障编号：" + listBean.getFailureNum(),listBean.getFailureNum() , "#ff0000", 0, 0);
                                            tv_no.setText(highlight);
                                            tv_desc.setText("故障描述："+listBean.getDescription());
                                            tv_statue.setText(listBean.getDataFlagValue());
                                            tv_type.setVisibility(View.GONE);
                                            tv_own_company.setVisibility(View.GONE);
                                            tv_dute.setText("操作人：" + listBean.getChangeBy());
                                            tv_date.setText("操作时间：" + listBean.getChangeTime());

                                            holder.setTextSize(R.id.tv_empty);
                                            holder.setTextSize(R.id.tv_no);
                                            holder.setTextSize(R.id.tv_statue);
//                                            holder.setTextSize(R.id.tv_type);
                                            holder.setTextSize(R.id.tv_desc);
//                                            holder.setTextSize(R.id.tv_own_company);
                                            holder.setTextSize(R.id.tv_dute);
                                            holder.setTextSize(R.id.tv_date);

                                            holder.setOnClickListener(R.id.cardview, new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    startActivity(new Intent(FaultListActivity.this, FaultDetailActivity.class).putExtra("data", listBean));
                                                }
                                            });
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
                            if (adapter.getData().size() == 0) {
                                nodata.setVisibility(View.VISIBLE);

                            }

                        } else {
//                            refreshLayout.setVisibility(View.GONE);
                            nodata.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });
    }

    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_search:
                currentPageNum = 1;
                query(3);
                break;
//            case R.id.iv_search1:
//                query(1);
//                break;
//            case R.id.iv_search2:
//                query(2);

        }

    }


}
