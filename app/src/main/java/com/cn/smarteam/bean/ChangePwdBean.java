package com.cn.smarteam.bean;

/**
 * Created by tzl
 * on 2020/12/28
 */
public class ChangePwdBean {


    /**
     * code : 200
     * msg : GUIDE-操作成功
     * data : 1
     */

    private int code;
    private String msg;
    private int data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
