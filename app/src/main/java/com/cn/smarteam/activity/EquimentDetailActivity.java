package com.cn.smarteam.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
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
import com.cn.smarteam.bean.EquementListBean;
import com.cn.smarteam.fragment.FunctionFragment2;
import com.cn.smarteam.fragment.MaintainFragment;
import com.cn.smarteam.fragment.MaterialUsedFragment;
import com.cn.smarteam.fragment.RePairFragment;
import com.cn.smarteam.fragment.WaitDoFragment;
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
    @BindView(R.id.magicIndicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.pager)
    ViewPager pager;
    private ArrayList<Fragment> fragmentList;
    private ArrayList<String> titles;
    private Fragment currentFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eqm_detail_activity);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);
        ButterKnife.bind(this);
        listBean = (EquementListBean.DataBean.ListBean) getIntent().getExtras().get("data");
        initView();
        initEvent();

    }

    private void initEvent() {
        llBack.setOnClickListener(this);
    }

    private void initView() {
        tvCommonTitle.setText("设备详情");
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

        titles = new ArrayList<String>();
        pager.removeAllViews();
        titles.clear();
        titles.add("零配件使用");
        titles.add("维修工单");

        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        fragmentList.clear();
        MaterialUsedFragment waitDoFragment = new MaterialUsedFragment(MyApplication.applicationContext,listBean);
        RePairFragment maintainFragment = new RePairFragment(MyApplication.applicationContext,listBean);
        fragmentList.add(waitDoFragment);
        fragmentList.add(maintainFragment);
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList, titles);
        pager.setAdapter(myFragmentPagerAdapter);
        final CommonNavigator commonNavigator = new CommonNavigator(MyApplication.applicationContext);
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
                simplePagerTitleView.setSelectedColor(MyApplication.applicationContext.getResources().getColor(R.color.colorAccent));
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
