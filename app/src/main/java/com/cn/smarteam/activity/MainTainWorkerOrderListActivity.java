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
import com.cn.smarteam.net.CallBackUtil;
import com.cn.smarteam.net.OkhttpUtil;
import com.cn.smarteam.utils.HighLightUtils;
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
 * on 2021/1/11
 */
public class MainTainWorkerOrderListActivity extends BaseListActivity{
    private int currentPageNum = 1;
    private boolean isRefresh;
    private CommonAdapter<DxjWorkOrderListBean.DataBean.ListBean> adapter;
    private LoadingDialog ld;
    @Override
    public void initView() {
        tv_common_title.setText("保养工单");
        edt_search1.setHint("工单编号");
        edt_search2.setHint("工单描述");
    }

    @Override
    public void initEvent() {
        ld = new LoadingDialog(MyApplication.applicationContext);

        query(0);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新数据
                isRefresh = true;
                currentPageNum = 1;
                if (TextUtils.isEmpty(edt_search1.getText().toString())&&TextUtils.isEmpty(edt_search2.getText().toString())){
                    query(0);
                }else
                    query(3);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                if (TextUtils.isEmpty(edt_search1.getText().toString())&&TextUtils.isEmpty(edt_search2.getText().toString())){
                    query(0);
                }else
                    query(3);
            }
        });
    }

    private void query(int searchType) {
        String url;
        String assetNum=edt_search1.getText().toString();
        String description=edt_search2.getText().toString();
        if (searchType==3) {
            url = Constants.BASE_URL + Constants.DXJ_SEARCH_WORKORDER_LIST;//模糊搜索
        } else {
            url = Constants.BASE_URL + Constants.DXJ_WORKORDER_LIST;//搜索全部

        }
        HashMap<String, String> map = new HashMap<>();
        map.put("pageNum", currentPageNum + "");
        map.put("pageSize", 10 + "");
        map.put("worktype",1+"");
        if (searchType==3){
            map.put("woNum", assetNum );
            map.put("description", description );
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
                    final DxjWorkOrderListBean dxjWorkOrderListBean = JSONObject.parseObject(response, new TypeReference<DxjWorkOrderListBean>() {});
                    if (dxjWorkOrderListBean.getCode() == 200) {
                        int total=dxjWorkOrderListBean.getData().getTotal();
                        int totalpage = dxjWorkOrderListBean.getData().getPages();
                        if (total > 0) {
                            final List<DxjWorkOrderListBean.DataBean.ListBean> list = dxjWorkOrderListBean.getData().getList();
                            LogUtils.d("222222 list.size()==" + list.size());
                            nodata.setVisibility(View.GONE);
                            if (currentPageNum == 1) {
                                if (adapter == null) {
                                    adapter = new CommonAdapter<DxjWorkOrderListBean.DataBean.ListBean>(MyApplication.applicationContext, R.layout.equipment_list_item, list) {
                                        @Override
                                        public void convert(CommonViewHolder holder, final DxjWorkOrderListBean.DataBean.ListBean listBean) {
                                            CardView cardview = holder.getView(R.id.cardview);
                                            TextView tv_empty = holder.getView(R.id.tv_empty);
                                            TextView tv_no = holder.getView(R.id.tv_no);
                                            TextView tv_statue = holder.getView(R.id.tv_statue);
                                            TextView tv_type = holder.getView(R.id.tv_type);
                                            TextView tv_own_company = holder.getView(R.id.tv_own_company);
                                            TextView tv_desc = holder.getView(R.id.tv_desc);
                                            TextView tv_dute = holder.getView(R.id.tv_dute);
                                            TextView tv_date = holder.getView(R.id.tv_date);
                                            tv_empty.setText("工单编号：");
                                            tv_no.setText(listBean.getWoNum());
                                            SpannableString highlight = HighLightUtils.highlight(MyApplication.applicationContext, "工单描述：" + listBean.getDescription(), edt_search2.getText().toString(), "#03DAC5", 0, 0);
                                            tv_desc.setText(highlight);
                                            tv_statue.setText(listBean.getStatusValue());
                                            if (listBean.getStatus() == 4) {//已完工
                                                tv_statue.setTextColor(getResources().getColor(R.color.grenn));
                                            } else if (listBean.getStatus() == 2) {//已派发
                                                tv_statue.setTextColor(getResources().getColor(R.color.orange));
                                            } else if (listBean.getStatus() == 1) {//未派发
                                                tv_statue.setTextColor(getResources().getColor(R.color.textColor));
                                            } else if (listBean.getStatus() == 3) {//进行中
                                                tv_statue.setTextColor(getResources().getColor(R.color.config_color_red));
                                            } else if (listBean.getStatus() == 5){
                                                tv_statue.setTextColor(getResources().getColor(R.color.gry33));

                                            }

                                            tv_type.setText("上次保养时间：" + listBean.getLastStartDate());
                                            tv_own_company.setText("下次保养："+listBean.getNextCompDate());
                                            tv_dute.setText("操作人：" + listBean.getChangeBy());
                                            tv_date.setText("操作时间：" + listBean.getChangeTime());

                                            holder.setTextSize(R.id.tv_empty);
                                            holder.setTextSize(R.id.tv_no);
                                            holder.setTextSize(R.id.tv_statue);
                                            holder.setTextSize(R.id.tv_type);
                                            holder.setTextSize(R.id.tv_desc);
                                            holder.setTextSize(R.id.tv_own_company);
                                            holder.setTextSize(R.id.tv_dute);
                                            holder.setTextSize(R.id.tv_date);

                                            holder.setOnClickListener(R.id.cardview, new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    startActivity(new Intent(MyApplication.applicationContext,MainTainWorkOrderDetailActivity.class).putExtra("data",listBean));
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
                            refreshLayout.setVisibility(View.GONE);
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
                currentPageNum=1;
                query(3);
                break;
//            case R.id.iv_search1:
//                query(1);
//                break;
//            case R.id.iv_search2:
//                query(2);
//                break;

        }
    }
}
