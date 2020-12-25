package com.cn.smarteam.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cn.myapplication.R;
import com.cn.smarteam.bean.WaitDoListBean;
import com.cn.smarteam.adapter.CommonAdapter;
import com.cn.smarteam.base.CommonViewHolder;
import com.cn.smarteam.utils.LogUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzl
 * on 2020/12/14
 */
public class FunctionFragment2 extends Fragment implements View.OnClickListener {
    private boolean isRefresh;
    private int currentPageNum = 1;
    RecyclerView recyclerView;
    SmartRefreshLayout refreshLayout;
    RecyclerView.LayoutManager layoutManager;
    private List<WaitDoListBean> lists;
    private final Context mContext;
    private LinearLayout ll_top;
    TextView tv_select_menu;
    private TextView tv_select_all;
    private TextView tv_unselect_all;
    private TextView tv_commit_all;
    FloatingActionButton flab;
    CommonAdapter adapter;
    AlphaAnimation appearAnimation, disappearAnimation;
    private PopupWindow pop;
    private ImageView nodata;

    public FunctionFragment2(Context context) {
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmrnt2, container, false);
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
        appearAnimation = new AlphaAnimation(0, 1);
        appearAnimation.setDuration(500);

        disappearAnimation = new AlphaAnimation(1, 0);
        disappearAnimation.setDuration(500);
    }

    private void query() {
        lists = new ArrayList();
        WaitDoListBean listBean1 = new WaitDoListBean();
        listBean1.setNo("1001");
        listBean1.setType("点巡检工单");
        listBean1.setDate("2020/12/18 16:45");
        listBean1.setDesc("日常巡检 重点检查冬季防火措施及设备是否到位");
        listBean1.setDute("谢宝庆");
        listBean1.setStatue("已完成");
        listBean1.setChecked(false);

        WaitDoListBean listBean2 = new WaitDoListBean();
        listBean2.setNo("1002");
        listBean2.setType("点巡检工单");
        listBean2.setDate("2020/12/15 16:48");
        listBean2.setDesc("月中重点部位检查 重点检查疫情防控的紧急情况处理预案及应对措施");
        listBean2.setDute("马冬梅");
        listBean2.setStatue("审核中");
        listBean2.setChecked(false);

        WaitDoListBean listBean3 = new WaitDoListBean();
        listBean3.setNo("1003");
        listBean3.setType("点巡检工单");
        listBean3.setDate("2020/12/19 16:45");
        listBean3.setDesc("日常巡检 重点检查冬季防火措施及设备是否到位");
        listBean3.setDute("谢宝庆");
        listBean3.setStatue("已排发");
        listBean3.setChecked(false);

        lists.add(listBean1);
        lists.add(listBean2);
        lists.add(listBean3);

//        recyclerView.setAdapter(new CommonAdapter<WaitDoListBean>(mContext, R.layout.waitdo_list_item, lists) {
//
//            @Override
//            public void convert(CommonViewHolder holder, WaitDoListBean waitDoListBean) {
//                TextView tv_no = holder.getView(R.id.tv_no);
//                TextView tv_statue = holder.getView(R.id.tv_statue);
//                TextView tv_type = holder.getView(R.id.tv_type);
//                TextView tv_desc = holder.getView(R.id.tv_desc);
//                TextView tv_date = holder.getView(R.id.tv_date);
//                TextView tv_dute = holder.getView(R.id.tv_dute);
//
//                tv_no.setText(waitDoListBean.getNo());
//                tv_statue.setText(waitDoListBean.getStatue());
//                tv_type.setText(waitDoListBean.getType());
//                tv_desc.setText(waitDoListBean.getDesc());
//                tv_date.setText(waitDoListBean.getDate());
//                tv_dute.setText(waitDoListBean.getDute());
//
//            }
//        });
        if (lists.size() <= 0) {
            nodata.setVisibility(View.VISIBLE);
            return;
        } else {
            nodata.setVisibility(View.GONE);
        }
        adapter = new CommonAdapter<WaitDoListBean>(mContext, R.layout.waitdo_list_item, lists) {
            @Override
            public void convert(CommonViewHolder holder, final WaitDoListBean waitDoListBean) {

                CheckBox checkbox = holder.getView(R.id.checkbox);
                TextView tv_no = holder.getView(R.id.tv_no);
                TextView tv_statue = holder.getView(R.id.tv_statue);
                TextView tv_type = holder.getView(R.id.tv_type);
                TextView tv_desc = holder.getView(R.id.tv_desc);
                TextView tv_date = holder.getView(R.id.tv_date);
                TextView tv_dute = holder.getView(R.id.tv_dute);

                tv_no.setText(waitDoListBean.getNo());
                tv_statue.setText(waitDoListBean.getStatue());
                tv_type.setText(waitDoListBean.getType());
                tv_desc.setText(waitDoListBean.getDesc());
                tv_date.setText(waitDoListBean.getDate());
                tv_dute.setText(waitDoListBean.getDute());

                if (mFlag) {
                    checkbox.setVisibility(View.VISIBLE);
                } else {
                    checkbox.setVisibility(View.GONE);
                }
                checkbox.setChecked(waitDoListBean.isChecked());

                holder.setOnClickListener(R.id.checkbox, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (waitDoListBean.isChecked()) {
                            waitDoListBean.setChecked(false);
                        } else
                            waitDoListBean.setChecked(true);
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
        finishRefresh();
    }

    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_select_menu:
//                adapter.mFlag = !adapter.mFlag;
//
//                if (adapter.mFlag) {
//                    tv_select_menu.setText("取消");
//                } else {
//                    tv_select_menu.setText("选择");
//                }
//                adapter.notifyDataSetChanged();
                break;
            case R.id.tv_select_all:
                if (adapter.mFlag) {
                    for (int i = 0; i < adapter.getData().size(); i++) {
                        WaitDoListBean listBean = (WaitDoListBean) adapter.getData().get(i);
                        listBean.setChecked(true);
                    }
                }
                adapter.notifyDataSetChanged();
                break;
            case R.id.tv_unselect_all:
                if (adapter.mFlag) {
                    for (int i = 0; i < adapter.getData().size(); i++) {
                        WaitDoListBean listBean = (WaitDoListBean) adapter.getData().get(i);
                        listBean.setChecked(false);
                    }
                }
                adapter.notifyDataSetChanged();
                break;
            case R.id.tv_commit_all:
                if (lists.size() <= 0) {
                    return;
                }
                List<String> ids = new ArrayList<>();
                if (adapter.mFlag) {
                    for (int i = 0; i < adapter.getData().size(); i++) {
                        WaitDoListBean listBean = (WaitDoListBean) adapter.getData().get(i);

                        if (listBean.isChecked()) {
                            ids.add(listBean.getDesc() + "");
                        }
                    }
                    LogUtils.d("222222    " + ids.size());
                    showRemarkPopupwindow();

                }
                break;
            case R.id.flab:
                if (lists.size() <= 0) {
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
}
