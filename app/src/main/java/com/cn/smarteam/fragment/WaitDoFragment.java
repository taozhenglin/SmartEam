package com.cn.smarteam.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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
import com.cn.smarteam.activity.ChangePwdActivity;
import com.cn.smarteam.activity.DianXunJianGongdanDetailActivity;
import com.cn.smarteam.activity.DxjWorkerOrderListActivity;
import com.cn.smarteam.activity.LoginActivity;
import com.cn.smarteam.activity.MainTainWorkOrderDetailActivity;
import com.cn.smarteam.activity.QuickReportDetailActivity;
import com.cn.smarteam.adapter.CommonAdapter;
import com.cn.smarteam.base.CommonViewHolder;
import com.cn.smarteam.base.Constants;
import com.cn.smarteam.base.MyApplication;
import com.cn.smarteam.bean.ChangePwdBean;
import com.cn.smarteam.bean.DxjWorkOrderListBean;
import com.cn.smarteam.bean.PostData;
import com.cn.smarteam.bean.WaitDoListBean;
import com.cn.smarteam.net.CallBackUtil;
import com.cn.smarteam.net.OkhttpUtil;
import com.cn.smarteam.utils.HighLightUtils;
import com.cn.smarteam.utils.LogUtils;
import com.cn.smarteam.utils.NetWorkUtil;
import com.cn.smarteam.utils.SharedPreferencesUtil;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.guideelectric.loadingdialog.view.LoadingDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;

/**
 * Created by tzl
 * on 2020/12/29
 */
public class WaitDoFragment extends Fragment implements View.OnClickListener {
    private final Context mContext;
    private boolean isRefresh;
    private int currentPageNum = 1;
    RecyclerView recyclerView;
    SmartRefreshLayout refreshLayout;
    RecyclerView.LayoutManager layoutManager;
    private ImageView nodata, nonet;
    TextView tv_select_menu;
    private TextView tv_select_all;
    private TextView tv_unselect_all;
    private TextView tv_commit_all;
    FloatingActionButton flab;
    private LinearLayout ll_top;
    CommonAdapter adapter;
    AlphaAnimation appearAnimation, disappearAnimation;
    private PopupWindow pop;
    private LoadingDialog ld;


    public WaitDoFragment(Context context) {
        mContext = context;
        EventBus.getDefault().register(this);
    }

    @SuppressLint("RestrictedApi")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.waitdo_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        refreshLayout = view.findViewById(R.id.refreshLayout);
        ll_top = view.findViewById(R.id.ll_top);
        tv_select_menu = view.findViewById(R.id.tv_select_menu);
        tv_select_all = view.findViewById(R.id.tv_select_all);
        tv_unselect_all = view.findViewById(R.id.tv_unselect_all);
        tv_commit_all = view.findViewById(R.id.tv_commit_all);
        flab = view.findViewById(R.id.flab);
        nodata = view.findViewById(R.id.nodata);
        nonet = view.findViewById(R.id.nonet);
        if (!NetWorkUtil.isConnected(mContext)) {
            nonet.setVisibility(View.VISIBLE);
            refreshLayout.setVisibility(View.GONE);
            flab.setVisibility(View.GONE);
        }
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_select_menu.setOnClickListener(this);
        tv_select_all.setOnClickListener(this);
        tv_unselect_all.setOnClickListener(this);
        tv_commit_all.setOnClickListener(this);
        flab.setOnClickListener(this);
        ld = new LoadingDialog(mContext);

        appearAnimation = new AlphaAnimation(0, 1);
        appearAnimation.setDuration(500);

        disappearAnimation = new AlphaAnimation(1, 0);
        disappearAnimation.setDuration(500);
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

    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();
    }

    private void query() {
        String url = Constants.BASE_URL + Constants.WAIT_DO_LIST;
        HashMap<String, String> map = new HashMap<>();
        map.put("pageNum", currentPageNum + "");
        map.put("pageSize", 10 + "");
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
                    final DxjWorkOrderListBean waitDoListBean = JSONObject.parseObject(response, new TypeReference<DxjWorkOrderListBean>() {});
                    if (waitDoListBean.getCode() == 200) {
                        List<DxjWorkOrderListBean.DataBean.ListBean> list = waitDoListBean.getData().getList();
                        LogUtils.d("222222 list.size()="+list.size());
                        int totalpage=waitDoListBean.getData().getPages();
                        int total=waitDoListBean.getData().getTotal();

                        if (total > 0) {
                            nodata.setVisibility(View.GONE);
//                            for (int i = 0; i < list.size(); i++) {
//                                list.get(i).setChecked(false);
//                            }
                            if (currentPageNum == 1) {
                                if (adapter == null) {
                                    adapter = new CommonAdapter<DxjWorkOrderListBean.DataBean.ListBean>(mContext, R.layout.waitdo_list_item, list) {
                                        @Override
                                        public void convert(CommonViewHolder holder, DxjWorkOrderListBean.DataBean.ListBean listBean) {
                                            CheckBox checkbox = holder.getView(R.id.checkbox);
                                            TextView tv_no = holder.getView(R.id.tv_no);
                                            TextView tv_statue = holder.getView(R.id.tv_statue);
                                            TextView tv_type = holder.getView(R.id.tv_type);
                                            TextView tv_desc = holder.getView(R.id.tv_desc);
                                            CardView cardview = holder.getView(R.id.cardview);
                                            TextView tv_dute = holder.getView(R.id.tv_dute);
                                            SpannableString highlightNo = HighLightUtils.highlight(MyApplication.applicationContext, "工单编号：" + listBean.getWoNum(), listBean.getWoNum(), "#03DAC5", 0, 0);
                                            tv_no.setText(highlightNo);
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
                                                            startActivity(new Intent(mContext, MainTainWorkOrderDetailActivity.class).putExtra("data",listBean));

                                                            break;
                                                        case 2://维修工单
                                                            startActivity(new Intent(mContext, QuickReportDetailActivity.class).putExtra("data",listBean).putExtra("title","维修工单详情"));

                                                            break;
                                                        case 3://点巡检工单
                                                            startActivity(new Intent(mContext, QuickReportDetailActivity.class).putExtra("data",listBean).putExtra("title","点巡检工单详情"));
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


                        } else {
                                nodata.setVisibility(View.VISIBLE);
                        }
                    }else {
                        ToastUtils.showShort(waitDoListBean.getMsg());

                    }
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_select_menu:
                adapter.mFlag = !adapter.mFlag;

                if (adapter.mFlag) {
                    tv_select_menu.setText("取消");
                } else {
                    tv_select_menu.setText("选择");
                }
                adapter.notifyDataSetChanged();
                break;
            case R.id.tv_select_all:
                if (adapter.mFlag) {
                    for (int i = 0; i < adapter.getData().size(); i++) {
                        DxjWorkOrderListBean.DataBean.ListBean listBean = (DxjWorkOrderListBean.DataBean.ListBean) adapter.getData().get(i);
                        listBean.setChecked(true);
                    }
                }
                adapter.notifyDataSetChanged();
                break;
            case R.id.tv_unselect_all:
                if (adapter.mFlag) {
                    for (int i = 0; i < adapter.getData().size(); i++) {
                        DxjWorkOrderListBean.DataBean.ListBean listBean = (DxjWorkOrderListBean.DataBean.ListBean) adapter.getData().get(i);
                        listBean.setChecked(false);
                    }
                }
                adapter.notifyDataSetChanged();
                break;
            case R.id.tv_commit_all:
                if (adapter.getData().size() <= 0) {
                    return;
                }
                List<String> ids = new ArrayList<>();
                if (adapter.mFlag) {
                    for (int i = 0; i < adapter.getData().size(); i++) {
                        DxjWorkOrderListBean.DataBean.ListBean listBean = (DxjWorkOrderListBean.DataBean.ListBean) adapter.getData().get(i);

                        if (listBean.isChecked()) {
                            ids.add(listBean.getWoNum() + "");
                        }
                    }
                    LogUtils.d("222222    " + ids.size());
                    showRemarkPopupwindow();

                }
                break;
            case R.id.flab:
                if (adapter.getData().size() <= 0) {
                    return;
                }
                adapter.mFlag = !adapter.mFlag;
                adapter.notifyDataSetChanged();
                if (ll_top.getVisibility() == View.GONE) {
                    ll_top.setVisibility(View.VISIBLE);
                    ll_top.startAnimation(appearAnimation);
                } else {
                    ll_top.startAnimation(disappearAnimation);
                    ll_top.setVisibility(View.GONE);

                    disappearAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            LogUtils.d("222222", "onAnimationStart");
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            LogUtils.d("222222", "onAnimationEnd");
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                            LogUtils.d("222222", "onAnimationRepeat");
                        }
                    });
                }

                break;
        }
    }

    @SuppressLint("WrongConstant")
    private void showRemarkPopupwindow() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.fragmrnt2, null);
        View remarkView = LayoutInflater.from(mContext).inflate(R.layout.dialog_calender_sign_rule, null);
        pop = new PopupWindow(remarkView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundAlpha(0.5f);//设置屏幕透明度
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setFocusable(true);// 点击空白处时，隐藏掉pop窗口
        pop.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        pop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pop.showAtLocation(rootView, Gravity.CENTER, 0, 0);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
//        final EditText input_et = (EditText) remarkView.findViewById(R.id.input_et);
//        TextView finish_tv = (TextView) remarkView.findViewById(R.id.finish_tv);
//        TextView cancel_tv = (TextView) remarkView.findViewById(R.id.cancel_tv);
//        TextView title_tv = (TextView) remarkView.findViewById(R.id.title_tv);
//        ImageView iv_agree = (ImageView) remarkView.findViewById(R.id.iv_agree);
//        iv_agree.setBackgroundResource(R.drawable.selected);
//        ImageView iv_disagree = (ImageView) remarkView.findViewById(R.id.iv_disagree);
//        iv_disagree.setBackgroundResource(R.drawable.unselected);
//        iv_agree.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
//        iv_disagree.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
//        finish_tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String txt = input_et.getText().toString().trim();
//                pop.dismiss(); //不管有否字符串都应该去dismiss
//            }
//        });
//
//        cancel_tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pop.dismiss();
//            }
//        });
    }

    private void setBackgroundAlpha(float v) {
        WindowManager.LayoutParams lp = ((Activity) mContext).getWindow()
                .getAttributes();
        lp.alpha = v;
        ((Activity) mContext).getWindow().setAttributes(lp);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getNotify(PostData postData) {
        if (postData.getTag().equals("query")) {
            query();
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
