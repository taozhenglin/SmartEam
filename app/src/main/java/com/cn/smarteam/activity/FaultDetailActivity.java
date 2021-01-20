package com.cn.smarteam.activity;

import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.smarteam.R;
import com.cn.smarteam.base.Constants;
import com.cn.smarteam.base.MyApplication;
import com.cn.smarteam.bean.AuthPermissionBean;
import com.cn.smarteam.bean.FaultListBean;
import com.cn.smarteam.bean.FaultVisionListBean;
import com.cn.smarteam.net.CallBackUtil;
import com.cn.smarteam.net.OkhttpUtil;
import com.cn.smarteam.utils.HighLightUtils;
import com.cn.smarteam.utils.LogUtils;
import com.cn.smarteam.utils.SharedPreferencesUtil;
import com.cn.smarteam.utils.StatusBarUtils;
import com.guideelectric.loadingdialog.view.LoadingDialog;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * Created by tzl
 * on 2021/1/18
 */
public class FaultDetailActivity extends AppCompatActivity {
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
    @BindView(R.id.ll_right)
    LinearLayout llRight;
    @BindView(R.id.tv_no)
    TextView tvNo;
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.ll_container1)
    LinearLayout llContainer1;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.ll_container2)
    LinearLayout llContainer2;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.ll_container3)
    LinearLayout llContainer3;
    @BindView(R.id.ll3)
    LinearLayout ll3;

    private LoadingDialog ld;
    int count;
    private FaultListBean.DataBean.ListBean listBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fault_detail_activity);
        ButterKnife.bind(this);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);
        if ((getIntent().getExtras().get("data") != null)) {
            listBean = (FaultListBean.DataBean.ListBean) getIntent().getExtras().get("data");
        }
        ld = new LoadingDialog(this);
        getFaultCount();
        initView();
        initEvent();
    }

    private void getFaultCount() {
        ld.show();
        String url = Constants.BASE_URL + Constants.GET_FAULT_COUNT;
        HashMap<String, String> map = new HashMap<>();
        map.put("failureNum", listBean.getFailureNum());
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("authorization", SharedPreferencesUtil.getString(MyApplication.applicationContext, "authorization"));
        headermap.put("Content-Type", "application/json");
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                if (response != null) {
                    final AuthPermissionBean authPermissionBean = JSONObject.parseObject(response, new TypeReference<AuthPermissionBean>() {
                    });
                    if (authPermissionBean.getCode() == 200) {
                        count = authPermissionBean.getData();
                        tvCount.setText("故障次数：" + count);

                    } else {
                        ToastUtils.showShort(authPermissionBean.getMsg());
                    }
                } else {
                    ToastUtils.showShort(R.string.GETDATAFAILED);
                }
            }
        });
    }

    private void initEvent() {
        getFaultVision();

    }

    private void getFaultVision() {
        ld.show();
        String url = Constants.BASE_URL + Constants.GET_FAULT_VISION;
        HashMap<String, String> map = new HashMap<>();
        map.put("failureNum", listBean.getFailureNum());
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("authorization", SharedPreferencesUtil.getString(MyApplication.applicationContext, "authorization"));
        headermap.put("Content-Type", "application/json");
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                if (response != null) {
                    final FaultVisionListBean faultVisionListBean = JSONObject.parseObject(response, new TypeReference<FaultVisionListBean>() {
                    });
                    if (faultVisionListBean.getCode() == 200) {
                        List<FaultVisionListBean.DataBean.ListBean> list = faultVisionListBean.getData().getList();
                        if (list.size() > 0) {
                            ll1.setVisibility(View.VISIBLE);
                            llContainer1.removeAllViews();
                            for (int i = 0; i < list.size(); i++) {
                                View view = LayoutInflater.from(FaultDetailActivity.this).inflate(R.layout.equipment_list_item, llContainer1, false);
                                TextView tv_empty = view.findViewById(R.id.tv_empty);
                                TextView tv_no = view.findViewById(R.id.tv_no);
                                TextView tv_statue = view.findViewById(R.id.tv_statue);
                                TextView tv_type = view.findViewById(R.id.tv_type);
                                TextView tv_own_company = view.findViewById(R.id.tv_own_company);
                                TextView tv_desc = view.findViewById(R.id.tv_desc);
                                TextView tv_dute = view.findViewById(R.id.tv_dute);
                                TextView tv_date = view.findViewById(R.id.tv_date);
                                SpannableString highlight = HighLightUtils.highlight(MyApplication.applicationContext, "故障编号：" + list.get(i).getFailureNum(), list.get(i).getFailureNum(), "#ff0000", 0, 0);
                                tv_no.setText(highlight);
                                tv_desc.setText("故障描述："+list.get(i).getDescription());
                                tv_statue.setVisibility(View.GONE);
                                tv_type.setVisibility(View.GONE);
                                tv_own_company.setVisibility(View.GONE);
                                tv_dute.setText("操作人：" + list.get(i).getChangeBy());
                                tv_date.setText("操作时间：" + list.get(i).getChangeTime());
                                int finalI = i;
                                view.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        getResonList(list.get(finalI).getFailureNum());
                                    }
                                });
                                llContainer1.addView(view);
                            }
                            getResonList(list.get(0).getFailureNum());

                        } else {
                            ll1.setVisibility(View.GONE);

                        }
                    }else
                        ToastUtils.showShort(faultVisionListBean.getMsg());

                }
            }
        });
    }

    private void getResonList(String failureNum) {
        ld.show();
        String url = Constants.BASE_URL + Constants.GET_FAULT_VISION;
        HashMap<String, String> map = new HashMap<>();
        map.put("failureNum", failureNum);
        map.put("type", "3");
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("authorization", SharedPreferencesUtil.getString(MyApplication.applicationContext, "authorization"));
        headermap.put("Content-Type", "application/json");
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                if (response != null) {
                    final FaultVisionListBean faultVisionListBean = JSONObject.parseObject(response, new TypeReference<FaultVisionListBean>() {
                    });
                    if (faultVisionListBean.getCode() == 200) {
                        List<FaultVisionListBean.DataBean.ListBean> list = faultVisionListBean.getData().getList();
                        if (list.size() > 0) {
                            ll2.setVisibility(View.VISIBLE);
                            llContainer2.removeAllViews();
                            for (int i = 0; i < list.size(); i++) {
                                View view = LayoutInflater.from(FaultDetailActivity.this).inflate(R.layout.equipment_list_item, llContainer1, false);
                                TextView tv_empty = view.findViewById(R.id.tv_empty);
                                TextView tv_no = view.findViewById(R.id.tv_no);
                                TextView tv_statue = view.findViewById(R.id.tv_statue);
                                TextView tv_type = view.findViewById(R.id.tv_type);
                                TextView tv_own_company = view.findViewById(R.id.tv_own_company);
                                TextView tv_desc = view.findViewById(R.id.tv_desc);
                                TextView tv_dute = view.findViewById(R.id.tv_dute);
                                TextView tv_date = view.findViewById(R.id.tv_date);
                                SpannableString highlight = HighLightUtils.highlight(MyApplication.applicationContext, "故障编号：" + list.get(i).getFailureNum(), list.get(i).getFailureNum(), "#ff0000", 0, 0);
                                tv_no.setText(highlight);
                                tv_desc.setText("故障描述："+list.get(i).getDescription());
                                tv_statue.setVisibility(View.GONE);
                                tv_type.setVisibility(View.GONE);
                                tv_own_company.setVisibility(View.GONE);
                                tv_dute.setText("操作人：" + list.get(i).getChangeBy());
                                tv_date.setText("操作时间：" + list.get(i).getChangeTime());
                                int finalI = i;
                                view.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        getWayList(list.get(finalI).getFailureNum());
                                    }
                                });
                                llContainer2.addView(view);
                            }
                            getWayList(list.get(0).getFailureNum());

                        } else {
                            ll2.setVisibility(View.GONE);

                        }
                    }else
                        ToastUtils.showShort(faultVisionListBean.getMsg());

                }
            }
        });
    }

    private void getWayList(String failureNum) {
        ld.show();
        String url = Constants.BASE_URL + Constants.GET_FAULT_VISION;
        HashMap<String, String> map = new HashMap<>();
        map.put("failureNum", failureNum);
        map.put("type", "4");
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("authorization", SharedPreferencesUtil.getString(MyApplication.applicationContext, "authorization"));
        headermap.put("Content-Type", "application/json");
        OkhttpUtil.okHttpGet(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("onFailure==" + e.toString());
                ld.close();
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("onResponse==" + response);
                ld.close();
                if (response != null) {
                    final FaultVisionListBean faultVisionListBean = JSONObject.parseObject(response, new TypeReference<FaultVisionListBean>() {});
                    if (faultVisionListBean.getCode() == 200) {
                        List<FaultVisionListBean.DataBean.ListBean> list = faultVisionListBean.getData().getList();
                        if (list.size() > 0) {
                            ll3.setVisibility(View.VISIBLE);
                            llContainer3.removeAllViews();
                            for (int i = 0; i < list.size(); i++) {
                                View view = LayoutInflater.from(FaultDetailActivity.this).inflate(R.layout.equipment_list_item, llContainer1, false);
                                TextView tv_empty = view.findViewById(R.id.tv_empty);
                                TextView tv_no = view.findViewById(R.id.tv_no);
                                TextView tv_statue = view.findViewById(R.id.tv_statue);
                                TextView tv_type = view.findViewById(R.id.tv_type);
                                TextView tv_own_company = view.findViewById(R.id.tv_own_company);
                                TextView tv_desc = view.findViewById(R.id.tv_desc);
                                TextView tv_dute = view.findViewById(R.id.tv_dute);
                                TextView tv_date = view.findViewById(R.id.tv_date);
                                SpannableString highlight = HighLightUtils.highlight(MyApplication.applicationContext, "故障编号：" + list.get(i).getFailureNum(), list.get(i).getFailureNum(), "#ff0000", 0, 0);
                                tv_no.setText(highlight);
                                tv_desc.setText("故障描述："+list.get(i).getDescription());
                                tv_statue.setVisibility(View.GONE);
                                tv_type.setVisibility(View.GONE);
                                tv_own_company.setVisibility(View.GONE);
                                tv_dute.setText("操作人：" + list.get(i).getChangeBy());
                                tv_date.setText("操作时间：" + list.get(i).getChangeTime());
//                                int finalI = i;
//                                getWayList(list.get(0).getFailureNum());
//                                view.setOnClickListener(new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View view) {
//                                        getWayList(list.get(finalI).getFailureNum());
//                                    }
//                                });
                                llContainer3.addView(view);
                            }
                        } else {
                            ll3.setVisibility(View.GONE);

                        }
                    }else
                        ToastUtils.showShort(faultVisionListBean.getMsg());

                }
            }
        });
    }

    private void initView() {
        tvCommonTitle.setText("故障知识库详情");
        SpannableString highlight = HighLightUtils.highlight(MyApplication.applicationContext, "故障编码：" + listBean.getFailureNum(), listBean.getFailureNum(), "#ff0000", 0, 0);
        tvNo.setText(highlight);
        tvDesc.setText(listBean.getDescription());
        tvTime.setText("操作时间：" + listBean.getChangeTime());


    }

    @OnClick(R.id.ll_back)
    public void onViewClicked() {
        finish();
    }
}
