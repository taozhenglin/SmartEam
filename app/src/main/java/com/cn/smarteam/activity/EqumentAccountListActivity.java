package com.cn.smarteam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.smarteam.R;
import com.cn.smarteam.adapter.CommonAdapter;
import com.cn.smarteam.base.CommonViewHolder;
import com.cn.smarteam.base.Constants;
import com.cn.smarteam.base.MyApplication;
import com.cn.smarteam.bean.EquementListBean;
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
 * on 2020/12/30
 */
public class EqumentAccountListActivity extends BaseListActivity {
    private int currentPageNum = 1;
    private boolean isRefresh;
    private CommonAdapter<EquementListBean.DataBean.ListBean> adapter;
    private LoadingDialog ld;
    String s1,s2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        tv_common_title.setText("设备台账");
        edt_search1.setHint("设备编号");
        edt_search2.setHint("描述");
//        edt_search1.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                 s1 = editable.toString();
//                if (!TextUtils.isEmpty(s1)&&!TextUtils.isEmpty(s2)){
//                    tv_search.setVisibility(View.VISIBLE);
//                }else
//                    tv_search.setVisibility(View.GONE);
//            }
//        });
//        edt_search2.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                 s2 = editable.toString();
//                if (!TextUtils.isEmpty(s1)&&!TextUtils.isEmpty(s2)){
//                    tv_search.setVisibility(View.VISIBLE);
//                }else
//                    tv_search.setVisibility(View.GONE);
//            }
//        });


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
                query(0);


            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = false;
                currentPageNum++;
                query(0);

            }
        });
    }

    private void query(int searchType) {
        String url;
        String assetNum=edt_search1.getText().toString();
        String description=edt_search2.getText().toString();
        if (searchType==1||searchType==2||searchType==3) {
            url = Constants.BASE_URL + Constants.EQMENT_SEARCH_LIST;//模糊搜索
        } else {
            url = Constants.BASE_URL + Constants.EQMENT_LIST;//搜索全部

        }
        HashMap<String, String> map = new HashMap<>();
        map.put("pageNum", currentPageNum + "");
        map.put("pageSize", 10 + "");
            if (searchType==3){
            map.put("assetNum", assetNum );
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
                    final EquementListBean equementListBean = JSONObject.parseObject(response, new TypeReference<EquementListBean>() {});
                    if (equementListBean.getCode() == 200) {
                        int total=equementListBean.getData().getTotal();
                        int totalpage = equementListBean.getData().getPages();
                        if (total > 0) {
                            List<EquementListBean.DataBean.ListBean> list = equementListBean.getData().getList();
                            LogUtils.d("222222 list.size()==" + list.size());
                            nodata.setVisibility(View.GONE);
                            if (currentPageNum == 1) {
                                if (adapter == null) {
                                    adapter = new CommonAdapter<EquementListBean.DataBean.ListBean>(MyApplication.applicationContext, R.layout.equipment_list_item, list) {
                                        @Override
                                        public void convert(CommonViewHolder holder, final EquementListBean.DataBean.ListBean listBean) {
                                            CardView cardview = holder.getView(R.id.cardview);
                                            TextView tv_no = holder.getView(R.id.tv_no);
                                            TextView tv_statue = holder.getView(R.id.tv_statue);
                                            TextView tv_type = holder.getView(R.id.tv_type);
                                            TextView tv_own_company = holder.getView(R.id.tv_own_company);
                                            TextView tv_desc = holder.getView(R.id.tv_desc);
                                            TextView tv_dute = holder.getView(R.id.tv_dute);
                                            TextView tv_date = holder.getView(R.id.tv_date);

                                            SpannableString highlight = HighLightUtils.highlight(MyApplication.applicationContext, "设备编号：" + listBean.getAssetNum(), listBean.getAssetNum(), "#03DAC5", 0, 0);
                                            tv_no.setText(highlight);
//                                            tv_no.setText(listBean.getAssetNum());
                                            tv_statue.setText(listBean.getStatusValue());
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

                                            tv_type.setText("设备类型：" + listBean.getAssetTypeValue());
                                            tv_own_company.setText("所属公司：" + listBean.getDeptName());
                                            SpannableString highlightDesc = HighLightUtils.highlight(MyApplication.applicationContext, "描述：" + listBean.getDescription(), edt_search2.getText().toString(), "#03DAC5", 0, 0);
                                            tv_desc.setText(highlightDesc);
                                            tv_dute.setText("操作人：" + listBean.getChangeBy());
                                            tv_date.setText("操作时间：" + listBean.getChangeTime());


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
                                                   startActivity(new Intent(EqumentAccountListActivity.this,EquimentDetailActivity.class).putExtra("data",listBean));
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
                currentPageNum=1;
                query(3);
                break;
            case R.id.iv_search1:
                query(1);
                break;
            case R.id.iv_search2:
                query(2);

        }
    }
}
