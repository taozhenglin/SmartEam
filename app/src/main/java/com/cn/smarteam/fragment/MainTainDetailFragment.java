package com.cn.smarteam.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.cn.smarteam.R;
import com.cn.smarteam.base.MyApplication;
import com.cn.smarteam.bean.DxjWorkOrderListBean;
import com.cn.smarteam.utils.HighLightUtils;
import com.cn.smarteam.utils.LogUtils;
import com.cn.smarteam.utils.Tools;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tzl
 * on 2021/1/12  保养工单详情Fragment
 */
public class MainTainDetailFragment extends Fragment {
      Context mContext;
      DxjWorkOrderListBean.DataBean.ListBean mListBean;
    @BindView(R.id.tv_no)
    TextView tvNo;
    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_plan_no)
    TextView tvPlanNo;
    @BindView(R.id.tv_plan_desc)
    TextView tvPlanDesc;
    @BindView(R.id.tv_operate_date)
    TextView tvOperateDate;
    @BindView(R.id.tv_plan_start_date)
    TextView tvPlanStartDate;
    @BindView(R.id.tv_plan_end_date)
    TextView tvPlanEndDate;
    @BindView(R.id.tv_accture_start_date)
    TextView tvAcctureStartDate;
    @BindView(R.id.tv_accture_end_date)
    TextView tvAcctureEndDate;
    @BindView(R.id.tv_last_date)
    TextView tvLastDate;
    @BindView(R.id.tv_next_date)
    TextView tvNextDate;
    @BindView(R.id.tv_change_by)
    TextView tvChangeBy;
    @BindView(R.id.tv_radio)
    TextView tvRadio;
    @BindView(R.id.magicIndicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.pager)
    ViewPager pager;
    private LinearLayout ll_back;
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragmentList;
    private Fragment currentFragment;


    public MainTainDetailFragment(Context context, DxjWorkOrderListBean.DataBean.ListBean listBean) {
        mContext = context;
        mListBean = listBean;
        LogUtils.d("222222  mListBean= "+mListBean);

    }
    public MainTainDetailFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.maintain_detail_fragment, container, false);
        ButterKnife.bind(this,view);
        pager = view.findViewById(R.id.pager);
        magicIndicator = view.findViewById(R.id.magicIndicator);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        LogUtils.d("222222  mListBean= "+mListBean);
        SpannableString highlight = HighLightUtils.highlight(mContext, "工单编号：" + mListBean.getWoNum(), mListBean.getWoNum(), "#03DAC5", 0, 0);
        tvNo.setText(highlight);
        tvDesc.setText(mListBean.getDescription());
        tvPlanNo.setText("计划编号："+mListBean.getPmNum());
        tvPlanDesc.setText(mListBean.getPmName());
        tvOperateDate.setText("操作时间："+mListBean.getChangeTime());
        tvPlanStartDate.setText("计划开始时间："+mListBean.getPlanStartTime());
        tvPlanEndDate.setText("计划完成时间："+mListBean.getPlanFinishTime());
        tvAcctureStartDate.setText("实际开始时间："+mListBean.getActualStartTime());
        tvAcctureEndDate.setText("实际结束时间："+mListBean.getActualFinishTime());
        tvLastDate.setText("上次保养时间："+mListBean.getLastStartDate());
        tvNextDate.setText("下次保养："+mListBean.getNextCompDate());
        tvChangeBy.setText("操作人："+mListBean.getChangeBy());
        tvRadio.setText("频率："+mListBean.getFreqUnitValue()+"/"+mListBean.getFrequency());
        titles = new ArrayList<String>();
        pager.removeAllViews();
        titles.clear();
        titles.add("作业工序");
        titles.add("设备");
//        titles.add("使用零配件");

        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        fragmentList.clear();
        WorkProcessFragment workProcessFragment = new WorkProcessFragment(mContext, mListBean);//作业工序
        EqumentFragment equmentFragment = new EqumentFragment(mContext, mListBean);//设备
//        MaterialUsedFragment materialUsedFragment = new MaterialUsedFragment(mContext, mListBean);//使用零配件情况

        fragmentList.add(workProcessFragment);
        fragmentList.add(equmentFragment);
//        fragmentList.add(materialUsedFragment);
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), fragmentList, titles);
        pager.setAdapter(myFragmentPagerAdapter);
        final CommonNavigator commonNavigator = new CommonNavigator(mContext);
        commonNavigator.setAdjustMode(true);
        pager.setOffscreenPageLimit(fragmentList.size());
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
                simplePagerTitleView.setSelectedColor(MyApplication.applicationContext.getResources().getColor(R.color.colorAccent));
//                simplePagerTitleView.setNormalFontSize(TypedValue.COMPLEX_UNIT_SP,  Tools.dip2px(context, 20));
//                simplePagerTitleView.setSelectedFontSize(TypedValue.COMPLEX_UNIT_SP,  Tools.dip2px(context, 28));
                simplePagerTitleView.setTextSize(15);
                simplePagerTitleView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
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
                linePagerIndicator.setColors(ContextCompat.getColor(MyApplication.applicationContext, R.color.colorAccent));
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

            }

            @Override
            public void onPageScrollStateChanged(int state) {
//                magicIndicator.onPageScrollStateChanged(state);
            }
        });

        pager.setCurrentItem(0);
        currentFragment = fragmentList.get(0);
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
