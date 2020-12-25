package com.cn.smarteam.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cn.myapplication.R;
import com.cn.smarteam.activity.OrderListActivity;

/**
 * Created by tzl
 * on 2020/12/14
 */
public class FunctionFragment1 extends Fragment {
    private final Context mContext;

    public FunctionFragment1(Context context) {
        mContext=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmrnt1,container,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(new Intent(getContext(), OrderListActivity.class));
            }
        });
        return view;
    }
}
