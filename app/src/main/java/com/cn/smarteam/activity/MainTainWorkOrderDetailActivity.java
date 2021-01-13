package com.cn.smarteam.activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
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
import com.cn.smarteam.base.CommonViewHolder;
import com.cn.smarteam.base.MyApplication;
import com.cn.smarteam.bean.DxjWorkOrderListBean;
import com.cn.smarteam.bean.EquementListBean;
import com.cn.smarteam.fragment.MainTainDetailFragment;
import com.cn.smarteam.fragment.RePairFragment1;
import com.cn.smarteam.fragment.RePairFragment2;
import com.cn.smarteam.fragment.RePairFragment3;
import com.cn.smarteam.fragment.WorkerOrderProcessFragment;
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

/**
 * Created by tzl
 * on 2021/1/12  保养工单详情
 */
public class MainTainWorkOrderDetailActivity extends AppCompatActivity implements View.OnClickListener {
    DxjWorkOrderListBean.DataBean.ListBean listBean;
    private LinearLayout ll_back;
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragmentList;
    private Fragment currentFragment;
    private MagicIndicator magicIndicator;
    private ViewPager pager;
    private TextView tv_common_title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maintain_wordkorder_detail_activity);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);
        listBean= (DxjWorkOrderListBean.DataBean.ListBean) getIntent().getExtras().get("data");
        initView();
        initEvent();
    }

    private void initView() {
        tv_common_title=findViewById(R.id.tv_common_title);
        tv_common_title.setText("工单详情");
        ll_back=findViewById(R.id.ll_back);

        pager=findViewById(R.id.pager);
        magicIndicator=findViewById(R.id.magicIndicator);
        titles = new ArrayList<String>();
        pager.removeAllViews();
        titles.clear();
        titles.add("保养工单详情");
        titles.add("工单流程");
        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        fragmentList.clear();
        MainTainDetailFragment mainTainDetailFragment = new MainTainDetailFragment(this, listBean);//维修工单
        WorkerOrderProcessFragment workerOrderProcessFragment = new WorkerOrderProcessFragment(this, listBean);//保养工单

        fragmentList.add(mainTainDetailFragment);
        fragmentList.add(workerOrderProcessFragment);
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

    private void initEvent() {
        ll_back.setOnClickListener(this);
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
