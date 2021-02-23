package com.cn.smarteam.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.cn.smarteam.R;
import com.cn.smarteam.bean.WaitDoListBean;
import com.cn.smarteam.adapter.CommonAdapter;
import com.cn.smarteam.utils.LogUtils;
import com.cn.smarteam.utils.NetWorkUtil;
import com.cn.smarteam.utils.Tools;
import com.cn.smarteam.view.RotateYAnimation;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzl
 * on 2020/12/14
 */
public class WorkFragment extends Fragment  {
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
    private ImageView nodata,nonet;
    private MagicIndicator magicIndicator;
    private ViewPager pager;
    private ArrayList<Fragment> fragmentList;
    private ArrayList<String> titles;
    private Fragment currentFragment;
    RelativeLayout rl_container;

    public WorkFragment(Context context) {
        mContext = context;
    }

    @SuppressLint("RestrictedApi")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmrnt2, container, false);
        rl_container= view.findViewById(R.id.rl_container);
        pager = view.findViewById(R.id.pager);
        magicIndicator = view.findViewById(R.id.magicIndicator);


        ll_top = view.findViewById(R.id.ll_top);
        tv_select_menu = view.findViewById(R.id.tv_select_menu);
        tv_select_all = view.findViewById(R.id.tv_select_all);
        tv_unselect_all = view.findViewById(R.id.tv_unselect_all);
        tv_commit_all = view.findViewById(R.id.tv_commit_all);
        flab = view.findViewById(R.id.flab);
        nodata = view.findViewById(R.id.nodata);
        nonet = view.findViewById(R.id.nonet);
        if (!NetWorkUtil.isConnected(mContext)){
            nonet.setVisibility(View.VISIBLE);
            flab.setVisibility(View.GONE);
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        tv_select_menu.setOnClickListener(this);
//        tv_select_all.setOnClickListener(this);
//        tv_unselect_all.setOnClickListener(this);
//        tv_commit_all.setOnClickListener(this);
//        flab.setOnClickListener(this);
////        query();
//        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
//            @Override
//            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
//                //刷新数据
//                isRefresh = true;
//                currentPageNum = 1;
////                query();
//
//
//            }
//        });
//        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
//            @Override
//            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
//                isRefresh = false;
//                currentPageNum++;
////                query();
//
//            }
//        });
//        appearAnimation = new AlphaAnimation(0, 1);
//        appearAnimation.setDuration(500);
//
//        disappearAnimation = new AlphaAnimation(1, 0);
//        disappearAnimation.setDuration(500);

        titles = new ArrayList<String>();
        pager.removeAllViews();
        titles.clear();
        titles.add("待办工单");
        titles.add("保养工单");

        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        fragmentList.clear();
        WaitDoFragment waitDoFragment = new WaitDoFragment(mContext);
        MaintainFragment maintainFragment = new MaintainFragment(mContext);
        fragmentList.add(waitDoFragment);
        fragmentList.add(maintainFragment);
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getActivity().getSupportFragmentManager(), fragmentList, titles);
        pager.setAdapter(myFragmentPagerAdapter);
        final CommonNavigator commonNavigator = new CommonNavigator(mContext);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return titles.size();
            }
            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
                simplePagerTitleView.setText(titles.get(index));
                simplePagerTitleView.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.sp13));
                simplePagerTitleView.setPadding(Tools.dip2px(context, 18), Tools.dip2px(context, 1), Tools.dip2px(context, 18), Tools.dip2px(context, 1));
                simplePagerTitleView.setNormalColor(Color.parseColor("#000000"));
                simplePagerTitleView.setSelectedColor(mContext.getResources().getColor(R.color.colorAccent));
                simplePagerTitleView.setNormalFontSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.sp16));
                simplePagerTitleView.setSelectedFontSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.sp20));
//                simplePagerTitleView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;


            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                linePagerIndicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                linePagerIndicator.setLineWidth(Tools.dip2px(context, 30));
                linePagerIndicator.setLineHeight(Tools.dip2px(context, 4));
                linePagerIndicator.setRoundRadius(4);
                linePagerIndicator.setColors(ContextCompat.getColor(mContext, R.color.colorAccent));
                return linePagerIndicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, pager);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                magicIndicator.onPageScrolled(position, positionOffset, positionOffsetPixels);
//                magicIndicator.onPageSelected(position);
            }

            @Override
            public void onPageSelected(int position) {
                LogUtils.d("222222", "position=" + position);
//                magicIndicator.onPageSelected(position);
                currentFragment = fragmentList.get(position);
//                RotateAnimation rotateAnimation=new RotateAnimation(mContext,R.anim.rotate_anim);
//                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.rotate_anim);
//                RotateYAnimation yAnimation=new RotateYAnimation();
//                yAnimation.setRepeatCount(0);
//                pager.startAnimation(yAnimation);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
//                magicIndicator.onPageScrollStateChanged(state);
            }
        });

        pager.setCurrentItem(0);
        currentFragment = fragmentList.get(0);

    }

    private void query() {
//        lists = new ArrayList();
//        WaitDoListBean listBean1 = new WaitDoListBean();
//        listBean1.setNo("1001");
//        listBean1.setType("点巡检工单");
//        listBean1.setDate("2020/12/18 16:45");
//        listBean1.setDesc("日常巡检 重点检查冬季防火措施及设备是否到位");
//        listBean1.setDute("谢宝庆");
//        listBean1.setStatue("已完成");
//        listBean1.setChecked(false);
//
//        WaitDoListBean listBean2 = new WaitDoListBean();
//        listBean2.setNo("1002");
//        listBean2.setType("点巡检工单");
//        listBean2.setDate("2020/12/15 16:48");
//        listBean2.setDesc("月中重点部位检查 重点检查疫情防控的紧急情况处理预案及应对措施");
//        listBean2.setDute("马冬梅");
//        listBean2.setStatue("审核中");
//        listBean2.setChecked(false);
//
//        WaitDoListBean listBean3 = new WaitDoListBean();
//        listBean3.setNo("1003");
//        listBean3.setType("点巡检工单");
//        listBean3.setDate("2020/12/19 16:45");
//        listBean3.setDesc("日常巡检 重点检查冬季防火措施及设备是否到位");
//        listBean3.setDute("谢宝庆");
//        listBean3.setStatue("已排发");
//        listBean3.setChecked(false);
//
//        lists.add(listBean1);
//        lists.add(listBean2);
//        lists.add(listBean3);

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
//        lists.clear();
//        if (lists.size()<=0){
//            nodata.setVisibility(View.VISIBLE);
//        }else
//            nodata.setVisibility(View.GONE);
//        adapter = new CommonAdapter<WaitDoListBean>(mContext, R.layout.waitdo_list_item, lists) {
//            @Override
//            public void convert(CommonViewHolder holder, final WaitDoListBean waitDoListBean) {
//
//                CheckBox checkbox = holder.getView(R.id.checkbox);
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
//                if (mFlag) {
//                    checkbox.setVisibility(View.VISIBLE);
//                } else {
//                    checkbox.setVisibility(View.GONE);
//                }
//                checkbox.setChecked(waitDoListBean.isChecked());
//
//                holder.setOnClickListener(R.id.checkbox, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (waitDoListBean.isChecked()) {
//                            waitDoListBean.setChecked(false);
//                        } else
//                            waitDoListBean.setChecked(true);
//                    }
//                });
//
//                holder.setTextSize(R.id.tv_no);
//                holder.setTextSize(R.id.tv_statue);
//                holder.setTextSize(R.id.tv_type);
//                holder.setTextSize(R.id.tv_desc);
//                holder.setTextSize(R.id.tv_dute);
//                holder.setTextSize(R.id.tv_date);
//            }
//        };
        recyclerView.setAdapter(adapter);
        finishRefresh();
    }

    private void finishRefresh() {
        if (isRefresh) refreshLayout.finishRefresh();
        else refreshLayout.finishLoadMore();
    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.tv_select_menu:
////                adapter.mFlag = !adapter.mFlag;
////
////                if (adapter.mFlag) {
////                    tv_select_menu.setText("取消");
////                } else {
////                    tv_select_menu.setText("选择");
////                }
////                adapter.notifyDataSetChanged();
//                break;
//            case R.id.tv_select_all:
//                if (adapter.mFlag) {
//                    for (int i = 0; i < adapter.getData().size(); i++) {
//                        WaitDoListBean listBean = (WaitDoListBean) adapter.getData().get(i);
//                        listBean.setChecked(true);
//                    }
//                }
//                adapter.notifyDataSetChanged();
//                break;
//            case R.id.tv_unselect_all:
//                if (adapter.mFlag) {
//                    for (int i = 0; i < adapter.getData().size(); i++) {
//                        WaitDoListBean listBean = (WaitDoListBean) adapter.getData().get(i);
//                        listBean.setChecked(false);
//                    }
//                }
//                adapter.notifyDataSetChanged();
//                break;
//            case R.id.tv_commit_all:
//                if (lists.size() <= 0) {
//                    return;
//                }
//                List<String> ids = new ArrayList<>();
//                if (adapter.mFlag) {
//                    for (int i = 0; i < adapter.getData().size(); i++) {
//                        WaitDoListBean listBean = (WaitDoListBean) adapter.getData().get(i);
//
//                        if (listBean.isChecked()) {
//                            ids.add(listBean.getDesc() + "");
//                        }
//                    }
//                    LogUtils.d("222222    " + ids.size());
//                    showRemarkPopupwindow();
//
//                }
//                break;
//            case R.id.flab:
//                if (lists.size() <= 0) {
//                    return;
//                }
//                adapter.mFlag = !adapter.mFlag;
//                adapter.notifyDataSetChanged();
//                if (ll_top.getVisibility() == View.GONE) {
//                    ll_top.setVisibility(View.VISIBLE);
//                    ll_top.startAnimation(appearAnimation);
//                } else {
//                    ll_top.startAnimation(disappearAnimation);
//                    ll_top.setVisibility(View.GONE);
//
//                    disappearAnimation.setAnimationListener(new Animation.AnimationListener() {
//                        @Override
//                        public void onAnimationStart(Animation animation) {
//                            LogUtils.d("222222", "onAnimationStart");
//                        }
//
//                        @Override
//                        public void onAnimationEnd(Animation animation) {
//                            LogUtils.d("222222", "onAnimationEnd");
//                        }
//
//                        @Override
//                        public void onAnimationRepeat(Animation animation) {
//                            LogUtils.d("222222", "onAnimationRepeat");
//                        }
//                    });
//                }
//
//                break;
//        }
//    }

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
    public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
        private ArrayList<Fragment> fragmentLists;
        private ArrayList<String> titlelists;

        public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList, ArrayList<String> titleList) {
            super(fm);
            this.fragmentLists = fragmentList;
            this.titlelists = titleList;
        }


        @Override
        public Fragment getItem(int position) {
            return fragmentLists.get(position);
        }

        @Override
        public int getCount() {
            return fragmentLists.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titlelists.get(position);
        }
    }
}
