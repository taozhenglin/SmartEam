package com.cn.smarteam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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
import com.cn.smarteam.base.MyApplication;
import com.cn.smarteam.bean.EquementListBean;
import com.cn.smarteam.bean.EquemtMaterialUsedListBean;
import com.cn.smarteam.net.CallBackUtil;
import com.cn.smarteam.net.OkhttpUtil;
import com.cn.smarteam.utils.LogUtils;
import com.cn.smarteam.utils.SharedPreferencesUtil;
import com.cn.smarteam.utils.StatusBarUtils;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by tzl
 * on 2020/12/31  主要信息 零配件 工单
 */
public class EquimentDetailActivity extends AppCompatActivity implements View.OnClickListener {
    EquementListBean.DataBean.ListBean listBean;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.tv_common_title)
    TextView tvCommonTitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_fun)
    ImageView ivFun;
    @BindView(R.id.tv_no)
    TextView tvNo;
    @BindView(R.id.tv_statue)
    TextView tvStatue;
    @BindView(R.id.ll_top)
    LinearLayout llTop;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_dute)
    TextView tvDute;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_pur_date)
    TextView tvPurDate;
    @BindView(R.id.tv_create_date)
    TextView tvCreateDate;
    @BindView(R.id.tv_model)
    TextView tvModel;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_create_dept)
    TextView tvCreateDept;
    @BindView(R.id.tv_factory_no)
    TextView tvFactoryNo;
    @BindView(R.id.tv_org_value)
    TextView tvOrgValue;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    RecyclerView.LayoutManager layoutManager;
    private boolean isRefresh;
    private int currentPageNum = 1;
    private LoadingDialog ld;
    private ImageView nodata;
    private CommonAdapter<EquemtMaterialUsedListBean.DataBean.ListBean> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eqm_detail_activity);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);
        ButterKnife.bind(this);
        listBean = (EquementListBean.DataBean.ListBean) getIntent().getExtras().get("data");
        String assetNum = listBean.getAssetNum();
        LogUtils.d("222222 assetNum" + assetNum);

        initView();
        initEvent();

    }

    private void initEvent() {
        llBack.setOnClickListener(this);
        tvTitle.setOnClickListener(this);
        ld=new LoadingDialog(this);
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

    private void initView() {
        tvCommonTitle.setText("设备详情");
        tvTitle.setText("工单详情");
        tvNo.setText(listBean.getAssetNum());
        tvStatue.setText(listBean.getStatusValue());
        tvDesc.setText("设备描述：" + listBean.getDescription());
        tvDute.setText("操作人：" + listBean.getChangeBy());
        tvDate.setText("操作时间：" + listBean.getChangeTime());

        tvPurDate.setText("购入日期：" + listBean.getStatusDate());
        tvCreateDate.setText("投产时间：" + listBean.getInstallDate());
        tvModel.setText("规格型号：" + listBean.getClassNum());
        tvType.setText("种类：" + listBean.getAssetTypeValue());
        tvCreateDept.setText("制造单位：" + listBean.getManufacturer());
        tvFactoryNo.setText("出厂编号：" + listBean.getInstallDate());
        tvOrgValue.setText("原值（万元）：" + listBean.getPurchasePrice());

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        nodata = findViewById(R.id.nodata);

        refreshLayout = findViewById(R.id.refreshLayout);

//

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_title:
               startActivity(new Intent(this, EqumentWorderOrderDetailActivity.class).putExtra("listBean",listBean));
                break;
        }

    }


private void query() {
    String url = Constants.BASE_URL + Constants.GET_ASSERT_MATERIAL;
    HashMap<String, String> map = new HashMap<>();
    map.put("pageNum", currentPageNum + "");
    map.put("pageSize", 10 + "");
//        String assetNum = mListBean.getAssetNum();
//        assetNum = URLEncoder.encode(assetNum);
    map.put("woNum",listBean.getAssetNum());

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
                final EquemtMaterialUsedListBean equemtMaterialUsedListBean = JSONObject.parseObject(response, new TypeReference<EquemtMaterialUsedListBean>() {});
                if (equemtMaterialUsedListBean.getCode() == 200) {
                    List<EquemtMaterialUsedListBean.DataBean.ListBean> list = equemtMaterialUsedListBean.getData().getList();
                    LogUtils.d("222222 list.size()="+list.size());
                    int totalpage=equemtMaterialUsedListBean.getData().getPages();
                    if (currentPageNum == 1) {
                        if (adapter == null) {
                            adapter = new CommonAdapter<EquemtMaterialUsedListBean.DataBean.ListBean>(MyApplication.applicationContext, R.layout.material_used_list_item, list) {
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
}
