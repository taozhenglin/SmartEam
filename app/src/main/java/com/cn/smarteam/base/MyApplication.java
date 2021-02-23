package com.cn.smarteam.base;

import android.app.ActivityManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatDelegate;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ToastUtils;
import com.cn.smarteam.activity.ChangePwdActivity;
import com.cn.smarteam.activity.LoginActivity;
import com.cn.smarteam.activity.MainActivity;
import com.cn.smarteam.bean.LoginBean;
import com.cn.smarteam.net.CallBackUtil;
import com.cn.smarteam.net.OkhttpUtil;
import com.cn.smarteam.utils.DateUtils;
import com.cn.smarteam.utils.LogUtils;
import com.cn.smarteam.utils.SharedPreferencesUtil;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;


/**
 * 基础MyApplication类
 *
 * @author luhaixu
 */
public class MyApplication extends Application {
    public static String TAG = "MyApplication";
    public static Context applicationContext;
    private static MyApplication instance;
    private static final String NOTIFICATION_CHANNEL = "com.cn.beisanproject";
    String model;
    String carrier;
    public static String home = "1";
    public static float fontSize = 1.0f;

    private boolean firsttimeOpenMianActivity = false;

    //判断是否是处于后天状态,在true表示现在处于后台状态
    public static boolean houtai = false;


    private Handler handler;
    private NotificationManager mNotificationManager;

    //填写您在闪验平台申请的appid和AppKey
    public static final String appId = "579xUuz8";
    public static final String appKey = "1RA4ziYy";


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        

    }

 
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();
        disableAPIDialog();
        applicationContext = this;
        instance = this;
        // 默认设置为日间模式
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
        if (TextUtils.isEmpty(SharedPreferencesUtil.getString(this,"userName"))||TextUtils.isEmpty(SharedPreferencesUtil.getString(applicationContext,"pwd"))){
            applicationContext.startActivity(new Intent(applicationContext,LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

        }else
            login();
 
    }
    
    public static MyApplication getInstance() {
        return instance;
    }


    public boolean isFirsttimeOpenMianActivity() {
        return firsttimeOpenMianActivity;
    }

    public void setFirsttimeOpenMianActivity(boolean firsttimeOpenMianActivity) {
        this.firsttimeOpenMianActivity = firsttimeOpenMianActivity;
    }




    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }




    /**
     * 反射 禁止弹窗
     */
    private void disableAPIDialog() {
        if (Build.VERSION.SDK_INT < 28) return;
        try {
            Class clazz = Class.forName("android.app.ActivityThread");
            Method currentActivityThread = clazz.getDeclaredMethod("currentActivityThread");
            currentActivityThread.setAccessible(true);
            Object activityThread = currentActivityThread.invoke(null);
            Field mHiddenApiWarningShown = clazz.getDeclaredField("mHiddenApiWarningShown");
            mHiddenApiWarningShown.setAccessible(true);
            mHiddenApiWarningShown.setBoolean(activityThread, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getProcessName(Context cxt, int pid) {
        ActivityManager am = (ActivityManager) cxt.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
        if (runningApps == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
            if (procInfo.pid == pid) {
                return procInfo.processName;
            }
        }
        return null;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void login() {
        LogUtils.d("response222222 login");
        HashMap<String, String> map = new HashMap<>();
        map.put("userName", SharedPreferencesUtil.getString(this,"userName"));
        map.put("passWord",  base64(SharedPreferencesUtil.getString(this,"pwd")));
        map.put("imei", "android");
        String url = Constants.BASE_URL + Constants.LOGIN;
        HashMap<String, String> headermap = new HashMap<>();
        headermap.put("Content-Type", "application/json;charset=UTF-8");
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
                            SharedPreferencesUtil.setString(instance, "userName", loginBean.getData().getUserName());
                            SharedPreferencesUtil.setString(instance, "pwd", SharedPreferencesUtil.getString(instance,"pwd"));
                            SharedPreferencesUtil.setString(instance, "userId", loginBean.getData().getUserId());
                            SharedPreferencesUtil.setString(instance, "userNum", loginBean.getData().getUserNum());
                            SharedPreferencesUtil.setString(instance, "personNum", loginBean.getData().getPersonNum());
                            SharedPreferencesUtil.setString(instance, "phoneNum", loginBean.getData().getPhoneNum());
                            SharedPreferencesUtil.setString(instance, "authorization", loginBean.getData().getAuthorization());
                            SharedPreferencesUtil.setString(instance,"logintime",  DateUtils.getStringDate());
                            SharedPreferencesUtil.setInt(instance, "waitdocount", loginBean.getData().getCount());

                            ToastUtils.showShort("登录成功");
                            startActivity(new Intent(applicationContext, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

                        } else {
                            ToastUtils.showShort(loginBean.getMsg());
                            startActivity(new Intent(applicationContext,LoginActivity.class));

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
}