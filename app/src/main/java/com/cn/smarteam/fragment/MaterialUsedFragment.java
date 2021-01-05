package com.cn.smarteam.fragment;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
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
import com.cn.smarteam.bean.WaitDoListBean;
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
 * on 2021/1/5  零配件使用
 */
public class MaterialUsedFragment extends Fragment {
    private final Context mContext;
    private final EquementListBean.DataBean.ListBean mListBean;
    RecyclerView recyclerView;
    SmartRefreshLayout refreshLayout;
    RecyclerView.LayoutManager layoutManager;
    private boolean isRefresh;
    private int currentPageNum = 1;
    private CommonAdapter<WaitDoListBean.DataBean.ListBean> adapter;
    private LoadingDialog ld;
    private ImageView nodata;

    public MaterialUsedFragment(Context context, EquementListBean.DataBean.ListBean listBean) {
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
        return view;    }

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
        String url = Constants.BASE_URL + Constants.GET_ASSERT_MATERIAL;
        HashMap<String, String> map = new HashMap<>();
        map.put("pageNum", currentPageNum + "");
        map.put("pageSize", 10 + "");
        map.put("assetNum",mListBean.getAssetNum());
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
                    final WaitDoListBean waitDoListBean = JSONObject.parseObject(response, new TypeReference<WaitDoListBean>() {});
                    if (waitDoListBean.getCode() == 200) {
                        List<WaitDoListBean.DataBean.ListBean> list = waitDoListBean.getData().getList();
                        LogUtils.d("222222 list.size()="+list.size());
                        int totalpage=waitDoListBean.getData().getPages();
                        if (list.size() > 0) {
                            nodata.setVisibility(View.GONE);
                            for (int i = 0; i < list.size(); i++) {
                                list.get(i).setChecked(false);
                            }
                            if (currentPageNum == 1) {
                                if (adapter == null) {
                                    adapter = new CommonAdapter<WaitDoListBean.DataBean.ListBean>(mContext, R.layout.waitdo_list_item, list) {
                                        @Override
                                        public void convert(CommonViewHolder holder, final WaitDoListBean.DataBean.ListBean listBean) {
                                            CheckBox checkbox = holder.getView(R.id.checkbox);
                                            TextView tv_no = holder.getView(R.id.tv_no);
                                            TextView tv_statue = holder.getView(R.id.tv_statue);
                                            TextView tv_type = holder.getView(R.id.tv_type);
                                            TextView tv_desc = holder.getView(R.id.tv_desc);
                                            CardView cardview = holder.getView(R.id.cardview);
                                            TextView tv_dute = holder.getView(R.id.tv_dute);

                                            tv_no.setText("工单编号：" + listBean.getWoNum());
                                            tv_statue.setText(listBean.getStatusValue());
                                            if (listBean.getStatus() == 4) {//已完工
                                                tv_statue.setTextColor(getResources().getColor(R.color.grenn));
                                            } else if (listBean.getStatus() == 2) {//已派发
                                                tv_statue.setTextColor(getResources().getColor(R.color.orange));
                                            } else if (listBean.getStatus() == 1) {//未排发
                                                tv_statue.setTextColor(getResources().getColor(R.color.textColor));
                                            } else if (listBean.getStatus() == 3) {//进行中
                                                tv_statue.setTextColor(getResources().getColor(R.color.config_color_red));
                                            } else {

                                            }

                                            tv_type.setText("工单类型：" + listBean.getWorkTypeValue());
                                            tv_desc.setText("工单描述：" + listBean.getDescription());
                                            tv_dute.setText("负责人：" + listBean.getPersonName());


                                            if (mFlag) {
                                                checkbox.setVisibility(View.VISIBLE);
                                            } else {
                                                checkbox.setVisibility(View.GONE);
                                            }
                                            checkbox.setChecked(listBean.isChecked());

                                            holder.setOnClickListener(R.id.checkbox, new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    if (listBean.isChecked()) {
                                                        listBean.setChecked(false);
                                                    } else
                                                        listBean.setChecked(true);
                                                }
                                            });
                                            holder.setOnClickListener(R.id.cardview, new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    switch (listBean.getWorkType()){
                                                        case 1://保养工单

                                                            break;
                                                        case 2://维修工单

                                                            break;
                                                        case 3://点巡检工单

                                                            break;
                                                    }
                                                }
                                            });
                                            holder.setTextSize(R.id.tv_no);
                                            holder.setTextSize(R.id.tv_statue);
                                            holder.setTextSize(R.id.tv_type);
                                            holder.setTextSize(R.id.tv_desc);
                                            holder.setTextSize(R.id.tv_dute);
                                            holder.setTextSize(R.id.tv_date);
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
            }
        });

    }
    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();
    }
}
