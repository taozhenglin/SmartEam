package com.cn.smarteam.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.smarteam.R;
import com.cn.smarteam.base.Constants;
import com.cn.smarteam.base.MyApplication;
import com.cn.smarteam.bean.LoginBean;
import com.cn.smarteam.net.CallBackUtil;
import com.cn.smarteam.net.OkhttpUtil;
import com.cn.smarteam.utils.LogUtils;
import com.cn.smarteam.utils.SharedPreferencesUtil;
import com.cn.smarteam.utils.StatusBarUtils;

import java.util.Base64;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * Created by tzl
 * on 2020/12/25
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtUsername;
    ImageView ivClear1;
    LinearLayout llName;
    EditText edtPassword;
    ImageView ivClear2;
    LinearLayout llPassword;
    TextView tvLoginIn;
    TextView tv_modify_pwd;
     boolean showPwd = false;
     String usernameTag;
    String pwdTag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //隐藏标题栏
        getSupportActionBar().hide();
        StatusBarUtils.setWhiteStatusBarColor(this, R.color.white);
        edtUsername = findViewById(R.id.edt_username);
        ivClear1 = findViewById(R.id.iv_clear1);
        edtPassword = findViewById(R.id.edt_password);
        ivClear2 = findViewById(R.id.iv_clear2);
        tv_modify_pwd = findViewById(R.id.tv_modify_pwd);
        tvLoginIn = findViewById(R.id.tv_login_in);
        init();
    }

    private void init() {
        ivClear1.setOnClickListener(this);
        ivClear2.setOnClickListener(this);
        tvLoginIn.setOnClickListener(this);
//        String span = "修改密码";
//        SpannableString spannableString=new SpannableString(span);
//        spannableString.setSpan(new ClickableSpan() {
//            @Override
//            public void onClick( View widget) {
//                Intent intent = new Intent(LoginActivity.this, ChangePwdActivity.class);
//                startActivity(intent);
//            }
//
//            @Override
//            public void updateDrawState( TextPaint ds) {
//                ds.setUnderlineText(true);
//                ds.setColor(Color.WHITE);
//            }
//        }, 0, span.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        spannableString.setSpan(new AbsoluteSizeSpan(14, true), 0, span.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);//设置字体大小
//        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#ffc000")), 0, span.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);//设置字体颜色
//        tv_modify_pwd.setText(spannableString);
//        tv_modify_pwd.setMovementMethod(LinkMovementMethod.getInstance());
        edtUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                usernameTag=charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String toString = editable.toString();
                if (TextUtils.isEmpty(toString)) {
                    ivClear1.setVisibility(View.GONE);
                    tvLoginIn.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_radis_30_gray));
                    tvLoginIn.setEnabled(false);
                } else {
                    ivClear1.setVisibility(View.VISIBLE);
                    if (!TextUtils.isEmpty(pwdTag)) {
                        tvLoginIn.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_radis_30_accent));
                        tvLoginIn.setEnabled(true);
                    }

                }
            }
        });
        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                pwdTag=charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String toString = editable.toString();
                if (TextUtils.isEmpty(toString)) {
                    ivClear2.setVisibility(View.GONE);
                    tvLoginIn.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_radis_30_gray));
                    tvLoginIn.setEnabled(false);
                } else {
                    ivClear2.setVisibility(View.VISIBLE);
                    if (!TextUtils.isEmpty(usernameTag)){
                        tvLoginIn.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_radis_30_accent));
                        tvLoginIn.setEnabled(true);
                    }

                }
            }
        });
        if (TextUtils.isEmpty(usernameTag)||TextUtils.isEmpty(pwdTag)){
            tvLoginIn.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_radis_30_gray));
            tvLoginIn.setEnabled(false);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void login(String name, final String pwd) {
        LogUtils.d("response222222 login");
        HashMap<String, String> map = new HashMap<>();
        map.put("userName", name);
        map.put("passWord", base64(pwd));
        map.put("imei", "android");
        String url = Constants.BASE_URL + Constants.LOGIN;
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "text/plan;charset=UTF-8");
        OkhttpUtil.okHttpPost(url, map, headermap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                LogUtils.d("222222 onFailure " + e.toString());
                ToastUtils.showShort("登陆失败");
            }

            @Override
            public void onResponse(String response) {
                LogUtils.d("222222 onResponse" + response);

                if (!response.isEmpty()) {
                    try {
                        LoginBean loginBean = JSONObject.parseObject(response, new TypeReference<LoginBean>() {});
                        if (loginBean.getCode()==200) {
                            SharedPreferencesUtil.setString(LoginActivity.this, "userName", loginBean.getData().getUserName());
                            SharedPreferencesUtil.setString(LoginActivity.this, "pwd", pwd);
                            SharedPreferencesUtil.setString(LoginActivity.this, "userId", loginBean.getData().getUserId());
                            SharedPreferencesUtil.setString(LoginActivity.this, "userNum", loginBean.getData().getUserNum());
                            SharedPreferencesUtil.setString(LoginActivity.this, "authorization", loginBean.getData().getAuthorization());
                            ToastUtils.showShort("登录成功");
                            startActivity(new Intent(MyApplication.applicationContext,MainActivity.class));
                            finish();
                        } else {
                            ToastUtils.showShort(loginBean.getMsg());
                        }
                    }catch (com.alibaba.fastjson.JSONException exception){
                        ToastUtils.showShort(exception.toString());
                    }
                }

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String base64(String pwd) {
        byte[] bytes = pwd.getBytes();
        String encodeToString = Base64.getEncoder().encodeToString(bytes);
        LogUtils.d("222222 encodeToString" + encodeToString);

        return encodeToString;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_clear1:
                edtUsername.setText("");
                usernameTag="";
                break;
            case R.id.iv_clear2:
                if (!showPwd) {
                    //显示
                    showPwd = true;
                    edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    ivClear2.setBackgroundResource(R.drawable.eye_open);
                } else {
                    //隐藏
                    edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    showPwd = false;
                    ivClear2.setBackgroundResource(R.drawable.eye_close);
                }
                break;
            case R.id.tv_login_in:
                login(edtUsername.getText().toString(), edtPassword.getText().toString());
                break;
        }
    }

}
