package com.cn.smarteam.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.smarteam.R;
import com.cn.smarteam.adapter.CommonAdapter;
import com.cn.smarteam.base.CommonViewHolder;
import com.cn.smarteam.base.Constants;
import com.cn.smarteam.bean.DxjWorkOrderListBean;
import com.cn.smarteam.bean.EquemtMaterialUsedListBean;
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
 * on 2021/1/13
 */
public class MaterialUsedListActivity extends BaseListActivity {
    private boolean isRefresh;
    private int currentPageNum = 1;
    private LoadingDialog ld;
    private CommonAdapter<EquemtMaterialUsedListBean.DataBean.ListBean> adapter;
     String assetNum;
    String woNum;

    @Override
    public void initView() {
        tv_common_title.setText("零配件使用详情");
        if (!TextUtils.isEmpty(getIntent().getStringExtra("assetNum"))){
            assetNum=getIntent().getStringExtra("assetNum");
        }
        if (!TextUtils.isEmpty(getIntent().getStringExtra("woNum"))){
            woNum=getIntent().getStringExtra("woNum");
        }
    }

    @Override
    public void initEvent() {

        ll_back.setOnClickListener(this::onClick);
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
        String url = Constants.BASE_URL + Constants.GET_WAITDO_MATERIAL_LIST;
        HashMap<String, String> map = new HashMap<>();
        map.put("pageNum", currentPageNum + "");
        map.put("pageSize", 5 + "");
//        String assetNum = mListBean.getAssetNum();
//        assetNum = URLEncoder.encode(assetNum);
        map.put("assetNum",assetNum);
        map.put("woNum",woNum);

        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("authorization", SharedPreferencesUtil.getString(mContext, "authorization"));
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
                    final EquemtMaterialUsedListBean equemtMaterialUsedListBean = JSONObject.parseObject(response, new TypeReference<EquemtMaterialUsedListBean>() {});
                    if (equemtMaterialUsedListBean.getCode() == 200) {
                        List<EquemtMaterialUsedListBean.DataBean.ListBean> list = equemtMaterialUsedListBean.getData().getList();
                        LogUtils.d("222222 list.size()="+list.size());
                        int totalpage=equemtMaterialUsedListBean.getData().getPages();
                        if (currentPageNum == 1) {
                            if (adapter == null) {
                                adapter = new CommonAdapter<EquemtMaterialUsedListBean.DataBean.ListBean>(mContext, R.layout.material_used_list_item, list) {
                                    @Override
                                    public void convert(CommonViewHolder holder, EquemtMaterialUsedListBean.DataBean.ListBean listBean) {
                                        TextView tv_no = holder.getView(R.id.tv_no);
                                        TextView tv_material_name = holder.getView(R.id.tv_material_name);
                                        TextView tv_material_model = holder.getView(R.id.tv_material_model);
                                        TextView tv_material_count = holder.getView(R.id.tv_material_count);
                                        TextView tv_unit_price = holder.getView(R.id.tv_unit_price);
                                        TextView tv_total = holder.getView(R.id.tv_total);

                                        tv_no.setText("行编号：" + listBean.getItemNum());
                                        tv_material_name.setText("配件名称：" + listBean.getAccessoriesName());
                                        tv_material_model.setText("规格型号：" + listBean.getSpecifications());
                                        tv_material_count.setText("配件数量：" + listBean.getQuantity());
                                        tv_unit_price.setText("配件单价：" + listBean.getUnitCost());
                                        tv_total.setText("配件总价：" + listBean.getLineCost());

                                        holder.setTextSize(R.id.tv_no);
                                        holder.setTextSize(R.id.tv_material_name);
                                        holder.setTextSize(R.id.tv_material_model);
                                        holder.setTextSize(R.id.tv_material_count);
                                        holder.setTextSize(R.id.tv_unit_price);
                                        holder.setTextSize(R.id.tv_total);
                                    }
                                };
                                recyclerView.setAdapter(adapter);

                            } else {
                                adapter.setData(list);
                                adapter.notifyDataSetChanged();
                            }
                        }else {
                            //不是第一页
                            if (currentPageNum<=totalpage){
                                adapter.addAllList(list);
                                adapter.notifyDataSetChanged();
                            }else {
                                ToastUtils.showShort("没有更多数据了");
                            }
                        }
                        if (adapter.getData().size()==0){
                            nodata.setVisibility(View.VISIBLE);
                        }

                    } else {
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
        finish();
    }
}
