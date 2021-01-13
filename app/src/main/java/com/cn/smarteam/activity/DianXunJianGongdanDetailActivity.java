package com.cn.smarteam.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cn.smarteam.base.Constants;
import com.cn.smarteam.bean.WaitDoListBean;
import com.cn.smarteam.net.CallBackUtil;
import com.cn.smarteam.net.OkhttpUtil;
import com.cn.smarteam.utils.LogUtils;
import com.cn.smarteam.utils.SharedPreferencesUtil;

import java.util.HashMap;

import okhttp3.Call;

/**
 * Created by tzl
 * on 2021/1/5
 */
public class DianXunJianGongdanDetailActivity extends AppCompatActivity {
    private WaitDoListBean.DataBean.ListBean listBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listBean= (WaitDoListBean.DataBean.ListBean) getIntent().getExtras().get("listBean");
        query();
    }

    private void query() {
        String url = Constants.BASE_URL + Constants.GET_WAITDO_MATERIAL_LIST;
        HashMap<String, String> map = new HashMap<>();
        map.put("pageNum", 1 + "");
        map.put("pageSize", 5 + "");
        map.put("woNum",listBean.getWoNum());
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("authorization", SharedPreferencesUtil.getString(this, "authorization"));
        headermap.put("Content-Type", "application/json");
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
//                ld.close();
//                finishRefresh();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
//                ld.close();
//                finishRefresh();
//                if (!response.isEmpty()) {
//                    final WaitDoListBean waitDoListBean = JSONObject.parseObject(response, new TypeReference<WaitDoListBean>() {});
//                    if (waitDoListBean.getCode() == 200) {
//                        List<WaitDoListBean.DataBean.ListBean> list = waitDoListBean.getData().getList();
//                        LogUtils.d("222222 list.size()="+list.size());
//                        int totalpage=waitDoListBean.getData().getPages();
//                        if (list.size() > 0) {
//                            nodata.setVisibility(View.GONE);
//                            for (int i = 0; i < list.size(); i++) {
//                                list.get(i).setChecked(false);
//                            }
//                            if (currentPageNum == 1) {
//                                if (adapter == null) {
//                                    adapter = new CommonAdapter<WaitDoListBean.DataBean.ListBean>(mContext, R.layout.waitdo_list_item, list) {
//                                        @Override
//                                        public void convert(CommonViewHolder holder, final WaitDoListBean.DataBean.ListBean listBean) {
//                                            CheckBox checkbox = holder.getView(R.id.checkbox);
//                                            TextView tv_no = holder.getView(R.id.tv_no);
//                                            TextView tv_statue = holder.getView(R.id.tv_statue);
//                                            TextView tv_type = holder.getView(R.id.tv_type);
//                                            TextView tv_desc = holder.getView(R.id.tv_desc);
//                                            CardView cardview = holder.getView(R.id.cardview);
//                                            TextView tv_dute = holder.getView(R.id.tv_dute);
//
//                                            tv_no.setText("工单编号：" + listBean.getWoNum());
//                                            tv_statue.setText(listBean.getStatusValue());
//                                            if (listBean.getStatus() == 4) {//已完工
//                                                tv_statue.setTextColor(getResources().getColor(R.color.grenn));
//                                            } else if (listBean.getStatus() == 2) {//已派发
//                                                tv_statue.setTextColor(getResources().getColor(R.color.orange));
//                                            } else if (listBean.getStatus() == 1) {//未排发
//                                                tv_statue.setTextColor(getResources().getColor(R.color.textColor));
//                                            } else if (listBean.getStatus() == 3) {//进行中
//                                                tv_statue.setTextColor(getResources().getColor(R.color.config_color_red));
//                                            } else {
//
//                                            }
//
//                                            tv_type.setText("工单类型：" + listBean.getWorkTypeValue());
//                                            tv_desc.setText("工单描述：" + listBean.getDescription());
//                                            tv_dute.setText("负责人：" + listBean.getPersonName());
//
//
//                                            if (mFlag) {
//                                                checkbox.setVisibility(View.VISIBLE);
//                                            } else {
//                                                checkbox.setVisibility(View.GONE);
//                                            }
//                                            checkbox.setChecked(listBean.isChecked());
//
//                                            holder.setOnClickListener(R.id.checkbox, new View.OnClickListener() {
//                                                @Override
//                                                public void onClick(View view) {
//                                                    if (listBean.isChecked()) {
//                                                        listBean.setChecked(false);
//                                                    } else
//                                                        listBean.setChecked(true);
//                                                }
//                                            });
//                                            holder.setOnClickListener(R.id.cardview, new View.OnClickListener() {
//                                                @Override
//                                                public void onClick(View view) {
//                                                    switch (listBean.getWorkType()){
//                                                        case 1://保养工单
//
//                                                            break;
//                                                        case 2://维修工单
//
//                                                            break;
//                                                        case 3://点巡检工单
//
//                                                            break;
//                                                    }
//                                                }
//                                            });
//                                            holder.setTextSize(R.id.tv_no);
//                                            holder.setTextSize(R.id.tv_statue);
//                                            holder.setTextSize(R.id.tv_type);
//                                            holder.setTextSize(R.id.tv_desc);
//                                            holder.setTextSize(R.id.tv_dute);
//                                            holder.setTextSize(R.id.tv_date);
//                                        }
//
//                                    };
//                                    recyclerView.setAdapter(adapter);
//
//                                } else {
//                                    adapter.setData(list);
//                                    adapter.notifyDataSetChanged();
//                                }
//                            }else {
//                                //不是第一页
//                                if (currentPageNum<=totalpage){
//                                    adapter.addAllList(list);
//                                    adapter.notifyDataSetChanged();
//                                }else {
//                                    ToastUtils.showShort("没有更多数据了");
//                                }
//                            }
//                            if (adapter.getData().size()==0){
//                                nodata.setVisibility(View.VISIBLE);
//
//                            }
//
//                        } else {
//                        }
//                    }
//                }
            }
        });

    }
}
