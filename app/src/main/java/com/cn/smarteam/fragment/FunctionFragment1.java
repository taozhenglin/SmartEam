package com.cn.smarteam.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.cn.smarteam.R;
import com.cn.smarteam.activity.EqumentAccountListActivity;

/**
 * Created by tzl
 * on 2020/12/14
 */
public class FunctionFragment1 extends Fragment implements View.OnClickListener {
    private final Context mContext;
    private CardView card_equment;
    private TextView tv_trouble,tv_zuoye;

    public FunctionFragment1(Context context) {
        mContext=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmrnt1,container,false);
        card_equment=view.findViewById(R.id.card_equment);
        tv_trouble=view.findViewById(R.id.tv_trouble);
        tv_zuoye=view.findViewById(R.id.tv_zuoye);
               return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        card_equment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.card_equment:
                mContext.startActivity(new Intent(mContext, EqumentAccountListActivity.class));

                break;

            case R.id.tv_trouble:
                break;

            case R.id.tv_zuoye:
                break;
        }
    }
}
