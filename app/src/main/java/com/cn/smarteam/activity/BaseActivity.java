package com.cn.smarteam.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cn.smarteam.R;
import com.cn.smarteam.utils.NetWorkUtil;
import com.cn.smarteam.utils.StatusBarUtils;

/**
 * Created by tzl
 * on 2020/12/28
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener {
     LinearLayout ll_back;
     TextView tv_common_title;
     TextView tv_title;
    ImageView iv_fun;
    ImageView iv_warm2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);

        ll_back = findViewById(R.id.ll_back);
//        ll_back.setOnClickListener(this);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_title = findViewById(R.id.tv_title);
        iv_fun = findViewById(R.id.iv_fun);
        iv_warm2 = findViewById(R.id.iv_warm2);
//无网络
        if (!NetWorkUtil.isConnected(this)) {
            iv_warm2.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
//            case R.id.ll_back:
//                finish();
//                break;
        }
    }
}
