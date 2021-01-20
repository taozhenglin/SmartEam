package com.cn.smarteam.activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.cn.smarteam.R;
import com.cn.smarteam.base.MyApplication;
import com.cn.smarteam.bean.StartndWorkListBean;
import com.cn.smarteam.fragment.JobMaterialUsedFragment;
import com.cn.smarteam.fragment.JobWorkProcessFragment;
import com.cn.smarteam.fragment.MaterialUsedFragment;
import com.cn.smarteam.fragment.WorkProcessFragment;
import com.cn.smarteam.utils.HighLightUtils;
import com.cn.smarteam.utils.LogUtils;
import com.cn.smarteam.utils.SharedPreferencesUtil;
import com.cn.smarteam.utils.StatusBarUtils;
import com.cn.smarteam.utils.Tools;
import com.guideelectric.loadingdialog.view.LoadingDialog;

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
import butterknife.OnClick;

/**
 * Created by tzl
 * on 2021/1/18
 */
public class StartandWorkDetailActivity extends AppCompatActivity {

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
    @BindView(R.id.ll_2)
    LinearLayout ll2;
    private StartndWorkListBean.DataBean.ListBean listBean;
    private LoadingDialog ld;
    private LinearLayout ll_back, ll_container;
    private TextView tv_common_title, tv_title;
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragmentList;
    private Fragment currentFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quick_report_detail_activity);
        ButterKnife.bind(this);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);
        if ((getIntent().getExtras().get("data") != null)) {
            listBean = (StartndWorkListBean.DataBean.ListBean) getIntent().getExtras().get("data");
        }

        initView();
        initEvent();
    }

    private void initEvent() {
//        llBack.setOnClickListener(this);

    }

    private void initView() {
//        tv_common_title = findViewById(R.id.tv_common_title);
        tvCommonTitle.setText("标准作业详情");
        llContainer.setVisibility(View.VISIBLE);
        ll2.setVisibility(View.GONE);
        SpannableString highlight = HighLightUtils.highlight(this, "作业编号：" + listBean.getJobPlanNum(), listBean.getJobPlanNum(), "#03DAC5", 0, 0);
        tvNo.setText(highlight);
        tvStatue.setText(listBean.getStatusValue());
        tvEqNo.setVisibility(View.GONE);
        tvDesc.setText("作业描述：" + listBean.getDescription());
        tvEqName.setText("联系电话：" + SharedPreferencesUtil.getString(this, "phoneNum"));
        tvFaultTime.setText("作业步骤：" + listBean.getOperationSteps());
        tvFaultType.setText("作业内容：" + listBean.getWorkContent());
        tvFaultVision.setVisibility(View.GONE);
        tvFaultReson.setVisibility(View.GONE);
        tvDealWay.setVisibility(View.GONE);
        tvChangeBy.setText("操纵人：" + listBean.getChangeBy());
        tvChangeTime.setText("操作时间：" + listBean.getChangeTime());
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
        JobWorkProcessFragment jobWorkProcessFragment = new JobWorkProcessFragment(this, listBean);//作业工序
        JobMaterialUsedFragment jobMaterialUsedFragment = new JobMaterialUsedFragment(this, listBean);//使用零配件
        fragmentList.add(jobWorkProcessFragment);
        fragmentList.add(jobMaterialUsedFragment);
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
//        tvStandard.setText("标准作业：" + listBean.getJobplanName());
//        tvWorkDetail.setText("作业内容：" + listBean.getWorkContent());
//        tvDuteBy.setText("负责人：" + listBean.getPersonName());
//        tvReportBy.setText("报告人：" + listBean.getReportBy());
//        tvReportTime.setText("报告时间：" + listBean.getReportTime());
    }

    @OnClick(R.id.ll_back)
    public void onViewClicked() {
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
