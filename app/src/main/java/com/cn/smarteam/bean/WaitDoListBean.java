package com.cn.smarteam.bean;

/**
 * Created by tzl
 * on 2020/12/18
 */
public class WaitDoListBean  {
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDute() {
        return dute;
    }

    public void setDute(String dute) {
        this.dute = dute;
    }

    String no;
    String desc;
    String date;
    String statue;
    String type;
    String dute;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    boolean isChecked;

}
