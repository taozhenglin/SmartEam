package com.cn.smarteam.activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.cn.smarteam.R;
import com.cn.smarteam.base.MyApplication;
import com.cn.smarteam.bean.DxjWorkOrderListBean;
import com.cn.smarteam.fragment.MaterialUsedFragment;
import com.cn.smarteam.fragment.WorkProcessFragment;
import com.cn.smarteam.utils.HighLightUtils;
import com.cn.smarteam.utils.LogUtils;
import com.cn.smarteam.utils.StatusBarUtils;
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
 * on 2021/1/13
 */
public class QuickReportDetailActivity extends AppCompatActivity implements View.OnClickListener {
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
    @BindView(R.id.tv_eq_no)
    TextView tvEqNo;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_eq_name)
    TextView tvEqName;
    @BindView(R.id.tv_fault_time)
    TextView tvFaultTime;
    @BindView(R.id.tv_fault_type)
    TextView tvFaultType;
    @BindView(R.id.tv_fault_vision)
    TextView tvFaultVision;
    @BindView(R.id.tv_fault_reson)
    TextView tvFaultReson;
    @BindView(R.id.tv_deal_way)
    TextView tvDealWay;
    @BindView(R.id.tv_change_time)
    TextView tvChangeTime;
    @BindView(R.id.tv_change_by)
    TextView tvChangeBy;
    @BindView(R.id.tv_standard)
    TextView tvStandard;
    @BindView(R.id.tv_work_detail)
    TextView tvWorkDetail;
    @BindView(R.id.tv_dute_by)
    TextView tvDuteBy;
    @BindView(R.id.tv_report_by)
    TextView tvReportBy;
    @BindView(R.id.tv_report_time)
    TextView tvReportTime;
    @BindView(R.id.ll_container)
    LinearLayout llContainer;
    @BindView(R.id.magicIndicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.pager)
    ViewPager pager;
    private DxjWorkOrderListBean.DataBean.ListBean listBean;
    private LinearLayout ll_back, ll_container;
    private TextView tv_common_title;
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragmentList;
    private Fragment currentFragment;
    private String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quick_report_detail_activity);
        ButterKnife.bind(this);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);
        if ((getIntent().getExtras().get("data")!=null)){
            listBean = (DxjWorkOrderListBean.DataBean.ListBean) getIntent().getExtras().get("data");
        }
        if (!TextUtils.isEmpty(getIntent().getStringExtra("title"))){
            title=getIntent().getStringExtra("title");
        }
        initView();
        initEvent();
    }

    private void initEvent() {
        ll_back.setOnClickListener(this);
    }

    private void initView() {
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText(title);
        ll_back = findViewById(R.id.ll_back);
        ll_container = findViewById(R.id.ll_container);
        ll_container.setVisibility(View.VISIBLE);
        SpannableString highlight = HighLightUtils.highlight(this, "工单编号：" + listBean.getWoNum(), listBean.getWoNum(), "#03DAC5", 0, 0);
        tvNo.setText(highlight);
        tvStatue.setText(listBean.getStatusValue());
        if (listBean.getStatus() == 4) {//已完工
            tvStatue.setTextColor(getResources().getColor(R.color.grenn));
        } else if (listBean.getStatus() == 2) {//已派发
            tvStatue.setTextColor(getResources().getColor(R.color.orange));
        } else if (listBean.getStatus() == 1) {//未排发
            tvStatue.setTextColor(getResources().getColor(R.color.textColor));
        } else if (listBean.getStatus() == 3) {//进行中
            tvStatue.setTextColor(getResources().getColor(R.color.config_color_red));
        } else if(listBean.getStatus() == 5){//已关闭
            tvStatue.setTextColor(getResources().getColor(R.color.gry33));
        }else {

        }
        tvEqNo.setText("设备编号：" + listBean.getAssetNum());
        tvDesc.setText("工单描述：" + listBean.getDescription());
        tvEqName.setText("设备名称：" + listBean.getAssetValue());
        tvFaultTime.setText("故障日期：" + listBean.getFailureTime());
        tvFaultType.setText("故障类：" + listBean.getFailureName());
        tvFaultVision.setText("故障现象：" + listBean.getProblemName());
        tvFaultReson.setText("故障原因：" + listBean.getCaseName());
        tvDealWay.setText("解决措施：" + listBean.getRemedyName());
        tvChangeBy.setText("操纵人：" + listBean.getChangeBy());
        tvChangeTime.setText("操作时间：" + listBean.getChangeTime());

        tvStandard.setText("标准作业："+ listBean.getJobplanName());
        tvWorkDetail.setText("作业内容："+ listBean.getWorkContent());
        tvDuteBy.setText("负责人："+ listBean.getPersonName());
        tvReportBy.setText("报告人："+ listBean.getReportBy());
        tvReportTime.setText("报告时间："+ listBean.getReportTime());

        pager = findViewById(R.id.pager);
        magicIndicator = findViewById(R.id.magicIndicator);
        titles = new ArrayList<String>();
        pager.removeAllViews();
        titles.clear();
        titles.add("作业工序");
        titles.add("使用零配件");
        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        fragmentList.clear();
        WorkProcessFragment workProcessFragment = new WorkProcessFragment(this, listBean);//作业工序
        MaterialUsedFragment materialUsedFragment = new MaterialUsedFragment(this, listBean);//维修工单
        fragmentList.add(workProcessFragment);
        fragmentList.add(materialUsedFragment);
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList, titles);
        pager.setAdapter(myFragmentPagerAdapter);
        final CommonNavigator commonNavigator = new CommonNavigator(this);
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

    @Override
    public void onClick(View view) {
        finish();
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
