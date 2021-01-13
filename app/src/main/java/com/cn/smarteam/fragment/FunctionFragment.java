package com.cn.smarteam.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.cn.smarteam.R;
import com.cn.smarteam.activity.DxjWorkerOrderListActivity;
import com.cn.smarteam.activity.EqumentAccountListActivity;
import com.cn.smarteam.activity.MainTainPlanListActivity;
import com.cn.smarteam.activity.MainTainWorkerOrderListActivity;
import com.cn.smarteam.activity.QuickReportListActivity;
import com.cn.smarteam.activity.RepairWorkerOrderListActivity;

/**
 * Created by tzl
 * on 2020/12/14
 */
public class FunctionFragment extends Fragment implements View.OnClickListener {
     final Context mContext;
     LinearLayout ll_equment;
     TextView tv_trouble,tv_zuoye,tv_maintain_plan,tv_check_order,tv_repair_order,tv_maintain_order,tv_quickly_report;

    public FunctionFragment(Context context) {
        mContext=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmrnt1,container,false);
        ll_equment=view.findViewById(R.id.ll_equment);
        tv_trouble=view.findViewById(R.id.tv_trouble);
        tv_zuoye=view.findViewById(R.id.tv_zuoye);
        tv_maintain_plan=view.findViewById(R.id.tv_maintain_plan);
        tv_check_order=view.findViewById(R.id.tv_check_order);
        tv_repair_order=view.findViewById(R.id.tv_repair_order);
        tv_maintain_order=view.findViewById(R.id.tv_maintain_order);
        tv_quickly_report=view.findViewById(R.id.tv_quickly_report);
               return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ll_equment.setOnClickListener(this);
        tv_trouble.setOnClickListener(this);
        tv_maintain_plan.setOnClickListener(this);
        tv_check_order.setOnClickListener(this);
        tv_repair_order.setOnClickListener(this);
        tv_maintain_order.setOnClickListener(this);
        tv_quickly_report.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_equment:
                mContext.startActivity(new Intent(mContext, EqumentAccountListActivity.class));//设备台账
                break;
            case R.id.tv_trouble:
                break;
            case R.id.tv_zuoye:
                break;
            case R.id.tv_maintain_plan:
                mContext.startActivity(new Intent(mContext, MainTainPlanListActivity.class));//保养计划
                break;
            case R.id.tv_check_order:
                mContext.startActivity(new Intent(mContext, DxjWorkerOrderListActivity.class));//点巡检工单
                break;
            case R.id.tv_repair_order:
                mContext.startActivity(new Intent(mContext, RepairWorkerOrderListActivity.class));//维修工单
                break;
            case R.id.tv_maintain_order:
                mContext.startActivity(new Intent(mContext, MainTainWorkerOrderListActivity.class));//保养工单
                break;
            case R.id.tv_quickly_report:
                mContext.startActivity(new Intent(mContext, QuickReportListActivity.class));//快速汇报
                break;
        }
    }
}
