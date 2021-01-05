package com.cn.smarteam.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.smarteam.R;
import com.cn.smarteam.base.Constants;
import com.cn.smarteam.bean.ChangePwdBean;
import com.cn.smarteam.bean.LoginBean;
import com.cn.smarteam.net.CallBackUtil;
import com.cn.smarteam.net.OkhttpUtil;
import com.cn.smarteam.utils.LogUtils;
import com.cn.smarteam.utils.NetWorkUtil;
import com.cn.smarteam.utils.SharedPreferencesUtil;
import com.cn.smarteam.utils.StatusBarUtils;

import java.util.Base64;
import java.util.HashMap;

import okhttp3.Call;

/**
 * Created by tzl
 * on 2020/12/28
 */
public class ChangePwdActivity extends BaseActivity{
    LinearLayout ll_back;
    TextView tv_common_title;
    TextView tv_title,tv_commit;
    ImageView iv_fun;
    ImageView iv_warm2;
    private EditText edt_pwd,edt_pwd_new,edt_pwd_confirm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepwd);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);

        ll_back = findViewById(R.id.ll_back);
        tv_common_title = findViewById(R.id.tv_common_title);
        tv_common_title.setText("修改密码");
        tv_title = findViewById(R.id.tv_title);
        iv_fun = findViewById(R.id.iv_fun);
        ll_back.setOnClickListener(this);
        iv_warm2 = findViewById(R.id.iv_warm2);
        edt_pwd = findViewById(R.id.edt_pwd);
        edt_pwd_new = findViewById(R.id.edt_pwd_new);
        edt_pwd_confirm = findViewById(R.id.edt_pwd_confirm);
        tv_commit= findViewById(R.id.tv_commit);
        tv_commit.setOnClickListener(this);
//无网络
        if (!NetWorkUtil.isConnected(this)) {
            iv_warm2.setVisibility(View.VISIBLE);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_commit:
                if (TextUtils.isEmpty(edt_pwd.getText().toString())){
                    ToastUtils.showShort("请输入原始密码");
                    return;
                }
                if (TextUtils.isEmpty(edt_pwd_new.getText().toString())){
                    ToastUtils.showShort("请输入新密码");
                    return;
                }
                if (TextUtils.isEmpty(edt_pwd_confirm.getText().toString())){
                    ToastUtils.showShort("请确认新密码");
                    return;
                }
                if(!edt_pwd_new.getText().toString().equals(edt_pwd_confirm.getText().toString())){
                    ToastUtils.showShort("请输入统一的新密码");
                    return;
                }
                commit(edt_pwd.getText().toString(),edt_pwd_new.getText().toString());
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void commit(String pwd, String pwdNew) {
        LogUtils.d("response222222 commit");
        HashMap<String, String> map = new HashMap<>();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("originalPassword",base64(pwd));
        jsonObject.put("passWord",base64(pwdNew));
        jsonObject.put("userId",SharedPreferencesUtil.getString(this,"userId"));
        jsonObject.put("userName",SharedPreferencesUtil.getString(this,"userName"));
        jsonObject.put("userNum",SharedPreferencesUtil.getString(this,"userNum"));
        String request = String.valueOf(jsonObject);
        map.put("authorization",SharedPreferencesUtil.getString(this,"authorization"));
        map.put("userEntity",request);
        String url = Constants.BASE_URL + Constants.UPDATE_USER_PWD;
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("authorization",SharedPreferencesUtil.getString(this,"authorization"));
        headermap.put("Content-Type", "application/json");
        OkhttpUtil.okHttpPostJson(url, request,headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222 onFailure " + e.toString());
                ToastUtils.showShort("操作失败");
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("222222 onResponse " + response.toString());
                if (response!=null&&!response.isEmpty()){
                    ChangePwdBean loginBean = JSONObject.parseObject(response, new TypeReference<ChangePwdBean>() {});
                    if (loginBean.getCode()==200){
                        ToastUtils.showShort("密码修改成功,请重新登录");
                        startActivity(new Intent(ChangePwdActivity.this,LoginActivity.class));
                    }
                }
            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private String base64(String pwd) {
        byte[] bytes = pwd.getBytes();
        String encodeToString = Base64.getEncoder().encodeToString(bytes);
        LogUtils.d("222222 encodeToString =" + encodeToString);
        return encodeToString;
    }
}
