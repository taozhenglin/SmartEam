package com.cn.smarteam.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cn.myapplication.R;
import com.cn.smarteam.utils.SharedPreferencesUtil;

/**
 * Created by tzl
 * on 2020/12/16
 */
public class CommonViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;

    public CommonViewHolder(Context context, View itemView, ViewGroup group) {
        super(itemView);
        mContext = context;
        mConvertView = itemView;
        mViews = new SparseArray<View>();
    }

    public static CommonViewHolder get(Context context, ViewGroup parent, int layoutid) {
        View inflate = LayoutInflater.from(context).inflate(layoutid, parent, false);
//        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
//        ScaleAnimation scaleAnimation=new ScaleAnimation(0.5f,1f,0.5f,1f,0.5f,0.5f);
//        scaleAnimation.setDuration(1000);
//        alphaAnimation.setDuration(1000);
//        AnimationSet set=new AnimationSet(false);
//        set.addAnimation(alphaAnimation);
//        set.addAnimation(scaleAnimation);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.recycler_list_anim);
        inflate.startAnimation(animation);
        CommonViewHolder viewHolder = new CommonViewHolder(context, inflate, parent);
        return viewHolder;

    }
    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if (view==null){
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public void updatePosition(int position) {
    }
    public CommonViewHolder setText(int viewId, String text){
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }
    public CommonViewHolder setImageResource(int viewId, int resId)
    {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    public CommonViewHolder setOnClickListener(int viewId,
                                         View.OnClickListener listener)
    {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }
    public void setTextSize(int viewId, float size){
        TextView view = getView(viewId);
        view.setTextSize(size);

    }
    public void setTextSize(int viewId){
        TextView view = getView(viewId);
        view.setTextSize(SharedPreferencesUtil.getFloat(mContext, Constants.FONT_SIZE));
    }
}
