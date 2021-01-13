package com.cn.smarteam.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.smarteam.R;
import com.cn.smarteam.activity.MaterialUsedListActivity;
import com.cn.smarteam.adapter.CommonAdapter;
import com.cn.smarteam.base.CommonViewHolder;
import com.cn.smarteam.base.Constants;
import com.cn.smarteam.base.MyApplication;
import com.cn.smarteam.bean.DxjWorkOrderListBean;
import com.cn.smarteam.bean.WorkEqmentListBean;
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
 * on 2021/1/12 保养工单详情之设备列表
 */
public class EqumentFragment extends Fragment {
    private final Context mContext;
    private final DxjWorkOrderListBean.DataBean.ListBean mListBean;
    private RefreshLayout refreshLayout;
    RecyclerView.LayoutManager layoutManager;
    private boolean isRefresh;
    private int currentPageNum = 1;
    private LoadingDialog ld;
    private ImageView nodata;
    RecyclerView recyclerView;
    private CommonAdapter<WorkEqmentListBean.DataBean.ListBean> adapter;
    public EqumentFragment(Context context, DxjWorkOrderListBean.DataBean.ListBean listBean) {
        mContext=context;
        mListBean=listBean;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.work_process_fragment,container,false);
        nodata=view.findViewById(R.id.nodata);
        recyclerView=view.findViewById(R.id.recyclerView);
        refreshLayout=view.findViewById(R.id.refreshLayout);
        layoutManager=new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initEvent();
    }
    private void initEvent() {
        ld=new LoadingDialog(mContext);
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
        String url = Constants.BASE_URL + Constants.GET_WORK_EQUMENT_LIST;
        HashMap<String, String> map = new HashMap<>();
        map.put("pageNum", currentPageNum + "");
        map.put("pageSize", 10 + "");
        map.put("woNum",mListBean.getWoNum());
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
                    final WorkEqmentListBean workEqmentListBean = JSONObject.parseObject(response, new TypeReference<WorkEqmentListBean>() {});
                    if (workEqmentListBean.getCode() == 200) {
                        List<WorkEqmentListBean.DataBean.ListBean> list = workEqmentListBean.getData().getList();
                        LogUtils.d("222222 list.size()="+list.size());
                        int totalpage=workEqmentListBean.getData().getPages();
                        int total=workEqmentListBean.getData().getTotal();

                        if (total>0){
                            if (currentPageNum == 1) {
                                if (adapter == null) {
                                    adapter = new CommonAdapter<WorkEqmentListBean.DataBean.ListBean>(MyApplication.applicationContext, R.layout.material_used_list_item, list) {
                                        @Override
                                        public void convert(CommonViewHolder holder, WorkEqmentListBean.DataBean.ListBean listBean) {
                                            CardView cardview= holder.getView(R.id.cardview);
                                            TextView tv_no = holder.getView(R.id.tv_no);
                                            TextView tv_material_name = holder.getView(R.id.tv_material_name);
                                            TextView tv_material_model = holder.getView(R.id.tv_material_model);
                                            TextView tv_material_count = holder.getView(R.id.tv_material_count);
                                            TextView tv_unit_price = holder.getView(R.id.tv_unit_price);
                                            TextView tv_total = holder.getView(R.id.tv_total);

                                            tv_no.setText("行编号：" + listBean.getWorkorderAssetId());
                                            SpannableString highlight = HighLightUtils.highlight(mContext, "设备编号：" + listBean.getAssetNum(), listBean.getAssetNum(), "#03DAC5", 0, 0);
                                            tv_material_name.setText(highlight);
                                            tv_material_model.setText("设备名称：" + listBean.getDescription());
                                            tv_material_count.setText("设备状态：" + listBean.getStatusValue());
                                            tv_unit_price.setText("规格参数：" + listBean.getAssetTypeValue());
                                            tv_total.setText("原值（万元）：" + listBean.getPurchasePrice());

                                            holder.setTextSize(R.id.tv_no);
                                            holder.setTextSize(R.id.tv_material_name);
                                            holder.setTextSize(R.id.tv_material_model);
                                            holder.setTextSize(R.id.tv_material_count);
                                            holder.setTextSize(R.id.tv_unit_price);
                                            holder.setTextSize(R.id.tv_total);

                                            holder.setOnClickListener(R.id.cardview, new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    startActivity(new Intent(mContext, MaterialUsedListActivity.class).putExtra("assetNum",listBean.getAssetNum()).putExtra("woNum",mListBean.getWoNum()));
                                                }
                                            });
                                        }
                                    };
                                    recyclerView.setAdapter(adapter);

                                } else {
                                    adapter.setData(list);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                            else
                            {
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
                        ToastUtils.showShort(workEqmentListBean.getMsg());
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
