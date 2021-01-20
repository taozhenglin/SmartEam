package com.cn.smarteam.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.smarteam.R;
import com.cn.smarteam.base.Constants;
import com.cn.smarteam.base.MyApplication;
import com.cn.smarteam.bean.AuthPermissionBean;
import com.cn.smarteam.bean.DxjWorkOrderListBean;
import com.cn.smarteam.bean.PostData;
import com.cn.smarteam.bean.WorkEqmentListBean;
import com.cn.smarteam.fragment.MaterialUsedFragment;
import com.cn.smarteam.fragment.WorkProcessFragment;
import com.cn.smarteam.net.CallBackUtil;
import com.cn.smarteam.net.OkhttpUtil;
import com.cn.smarteam.utils.HighLightUtils;
import com.cn.smarteam.utils.LogUtils;
import com.cn.smarteam.utils.SharedPreferencesUtil;
import com.cn.smarteam.utils.StatusBarUtils;
import com.cn.smarteam.utils.Tools;
import com.google.gson.JsonObject;
import com.guideelectric.loadingdialog.view.LoadingDialog;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;

import javax.security.auth.AuthPermission;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

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
    private LinearLayout ll_back, ll_container, ll_right;
    private TextView tv_common_title, tv_title;
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragmentList;
    private Fragment currentFragment;
    private String title;
    ImageView iv_fun;
    private LoadingDialog ld;
    private PopupWindow pop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quick_report_detail_activity);
        ButterKnife.bind(this);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);
        if ((getIntent().getExtras().get("data") != null)) {
            listBean = (DxjWorkOrderListBean.DataBean.ListBean) getIntent().getExtras().get("data");
        }
        if (!TextUtils.isEmpty(getIntent().getStringExtra("title"))) {
            title = getIntent().getStringExtra("title");
        }
        ld = new LoadingDialog(this);
        initView();
        initEvent();
    }

    private void initEvent() {
        ll_back.setOnClickListener(this);
        ll_right.setOnClickListener(this);
    }

    private void initView() {
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText(title);
        ll_back = findViewById(R.id.ll_back);
        ll_right = findViewById(R.id.ll_right);
        ll_right.setVisibility(View.VISIBLE);
        tv_title = findViewById(R.id.tv_title);
        iv_fun = findViewById(R.id.iv_fun);
        iv_fun.setVisibility(View.VISIBLE);
        iv_fun.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right_triangle));
        tv_title.setText(listBean.getButtonValue());
        tv_title.setTextColor(getResources().getColor(R.color.white));
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
        } else if (listBean.getStatus() == 5) {//已关闭
            tvStatue.setTextColor(getResources().getColor(R.color.gry33));
            ll_right.setVisibility(View.GONE);

        } else {

        }
        tvEqNo.setText("设备编号：" + listBean.getAssetNum());
        tvDesc.setText("工单描述：" + listBean.getDescription());
        tvEqName.setText("设备名称：" + listBean.getAssetValue());
        if (title.equals("点巡检工单详情")){
            tvFaultTime.setText("工单类型：" + listBean.getFailureTime());
            tvFaultType.setVisibility(View.GONE);
            tvFaultVision.setVisibility(View.GONE);
            tvFaultReson.setVisibility(View.GONE);
            tvDealWay.setVisibility(View.GONE);
            tvChangeBy.setText("操纵人：" + listBean.getChangeBy());
            tvChangeTime.setText("操作时间：" + listBean.getChangeTime());

            tvStandard.setText("标准作业：" + listBean.getJobplanName());
            tvWorkDetail.setText("作业内容：" + listBean.getWorkContent());
            tvDuteBy.setText("负责人：" + listBean.getPersonName());
            tvReportBy.setText("报告人：" + listBean.getReportBy());
            tvReportTime.setText("报告时间：" + listBean.getReportTime());
        }else {
            tvFaultTime.setText("故障日期：" + listBean.getFailureTime());
            tvFaultType.setText("故障类：" + listBean.getFailureName());
            tvFaultVision.setText("故障现象：" + listBean.getProblemName());
            tvFaultReson.setText("故障原因：" + listBean.getCaseName());
            tvDealWay.setText("解决措施：" + listBean.getRemedyName());
            tvChangeBy.setText("操纵人：" + listBean.getChangeBy());
            tvChangeTime.setText("操作时间：" + listBean.getChangeTime());

            tvStandard.setText("标准作业：" + listBean.getJobplanName());
            tvWorkDetail.setText("作业内容：" + listBean.getWorkContent());
            tvDuteBy.setText("负责人：" + listBean.getPersonName());
            tvReportBy.setText("报告人：" + listBean.getReportBy());
            tvReportTime.setText("报告时间：" + listBean.getReportTime());
        }


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

        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.ll_right:
                authPermission();
                break;
        }
    }

    private void authPermission() {
        ld.show();
        String url = Constants.BASE_URL + Constants.IS_AUTHOR;
        HashMap<String, String> map = new HashMap<>();
        map.put("status", listBean.getStatus()+"");
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
                    AuthPermissionBean authPermissionBean = JSONObject.parseObject(response, new TypeReference<AuthPermissionBean>() {
                    });
                    if (authPermissionBean.getCode() == 200) {
                        if (authPermissionBean.getData() == 1) {//有权限
                            showRemarkPopupwindow();
                        } else {
                            ToastUtils.showShort(authPermissionBean.getMsg());
                        }
                    } else {
                        ToastUtils.showShort(authPermissionBean.getMsg());
                    }

                }
            }
        });
    }

    @SuppressLint("WrongConstant")
    private void showRemarkPopupwindow() {
        View rootView = LayoutInflater.from(this).inflate(R.layout.quick_report_detail_activity, null);
        View remarkView = LayoutInflater.from(this).inflate(R.layout.commondialog, null);
        pop = new PopupWindow(remarkView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundAlpha(0.5f);//设置屏幕透明度
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setFocusable(true);// 点击空白处时，隐藏掉pop窗口
        pop.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        pop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        pop.showAtLocation(rootView, Gravity.CENTER, 0, -100);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
        final EditText input_et = (EditText) remarkView.findViewById(R.id.input_et);
        LinearLayout ll_agree = (LinearLayout) remarkView.findViewById(R.id.ll_agree);
        LinearLayout ll_disagree = (LinearLayout) remarkView.findViewById(R.id.ll_disagree);
        TextView title_tv = (TextView) remarkView.findViewById(R.id.title_tv);
        ImageView iv_close = (ImageView) remarkView.findViewById(R.id.iv_close);
        ll_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //同意
                LogUtils.d("同意==");
                reject(input_et.getText().toString(),1);

            }
        });
        ll_disagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(input_et.getText().toString())){
                    ToastUtils.showShort("请输入驳回理由");
                    return;
                }
                //驳回
                reject(input_et.getText().toString(),0);
            }
        });



        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
    }
    private void reject(String toString,int tag) {
        ld.show();
        String url;

        JSONObject object=new JSONObject();
//        HashMap<String, String> map = new HashMap<>();
        object.put("personNum", SharedPreferencesUtil.getString(MyApplication.applicationContext,"personNum"));
        object.put("woNum", listBean.getWoNum()+"");
        object.put("woText", toString);
        object.put("workOrderId", listBean.getWorkOrderId()+"");
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("authorization", SharedPreferencesUtil.getString(MyApplication.applicationContext, "authorization"));
        headermap.put("Content-Type", "application/x-www-form-urlencoded");

        if (tag==1){
            url = Constants.BASE_URL + Constants.PROCESS_GO; //同意
            object.put("button", listBean.getButton());
            object.put("status", listBean.getStatus());
            object.put("flag", "1");
            object.put("dePerson", listBean.getDePerson());
        }else {
            url = Constants.BASE_URL + Constants.PROCESS_REJECT;//驳回
            object.put("flag", "2");
        }

        OkhttpUtil.okHttpPostJson(url, String.valueOf(object), headermap, new CallBackUtil.CallBackString() {
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
                    AuthPermissionBean authPermissionBean = JSONObject.parseObject(response, new TypeReference<AuthPermissionBean>() {
                    });
                    if (authPermissionBean.getCode() == 200) {
                        if (authPermissionBean.getData() == 1) {//驳回成功
                            ToastUtils.showShort(authPermissionBean.getMsg());
                            PostData data=new PostData();
                            data.setTag(title);
                            EventBus.getDefault().post(data);
                            finish();
                        } else {
                            ToastUtils.showShort(authPermissionBean.getMsg());
                        }
                    } else {
                        ToastUtils.showShort(authPermissionBean.getMsg());
                    }

                }
            }
        });
    }

    private void setBackgroundAlpha(float v) {
        WindowManager.LayoutParams lp = ((Activity) this).getWindow()
                .getAttributes();
        lp.alpha = v;
        ((Activity) this).getWindow().setAttributes(lp);
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
