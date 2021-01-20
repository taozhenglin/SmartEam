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
import com.cn.smarteam.activity.StartandWorkDetailActivity;
import com.cn.smarteam.adapter.CommonAdapter;
import com.cn.smarteam.base.CommonViewHolder;
import com.cn.smarteam.base.Constants;
import com.cn.smarteam.bean.DxjWorkOrderListBean;
import com.cn.smarteam.bean.EquemtMaterialUsedListBean;
import com.cn.smarteam.bean.StartndWorkListBean;
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
 * on 2021/1/18
 */
public class JobMaterialUsedFragment extends Fragment {
     Context mContext;
    StartndWorkListBean.DataBean.ListBean mListBean;
    RecyclerView recyclerView;
    SmartRefreshLayout refreshLayout;
    RecyclerView.LayoutManager layoutManager;
    private boolean isRefresh;
    private int currentPageNum = 1;
    private LoadingDialog ld;
    private ImageView nodata;
    private CommonAdapter<EquemtMaterialUsedListBean.DataBean.ListBean> adapter;
    public JobMaterialUsedFragment(Context context, StartndWorkListBean.DataBean.ListBean listBean) {
        mContext=context;
        mListBean=listBean;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.waitdo_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        nodata = view.findViewById(R.id.nodata);

        refreshLayout = view.findViewById(R.id.refreshLayout);
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


    private void query() {
        ld.show();
        String url = Constants.BASE_URL + Constants.GET_JOB_MATERIAL_LIST;
        HashMap<String, String> map = new HashMap<>();
        map.put("pageNum", currentPageNum + "");
        map.put("pageSize", 5 + "");
//        String assetNum = mListBean.getAssetNum();
//        assetNum = URLEncoder.encode(assetNum);
//        map.put("assetNum",mListBean.getAssetNum());
        map.put("jobPlanNum",mListBean.getJobPlanNum());

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
                        int total=equemtMaterialUsedListBean.getData().getTotal();

                        if (total>0){
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
                        }else {
                            nodata.setVisibility(View.VISIBLE);

                        }
                    } else {
                        ToastUtils.showShort(equemtMaterialUsedListBean.getMsg());
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
