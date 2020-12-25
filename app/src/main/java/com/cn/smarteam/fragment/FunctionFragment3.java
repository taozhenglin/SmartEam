package com.cn.smarteam.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cn.myapplication.R;
import com.cn.smarteam.base.Constants;
import com.cn.smarteam.utils.SharedPreferencesUtil;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;


/**
 * Created by tzl
 * on 2020/12/14
 */
public class FunctionFragment3 extends Fragment implements View.OnClickListener {
    private final Context mContext;
    LinearLayout ll_font;
    LinearLayout ll_mode;
    private String[] stringItems1 = new String[]{"小", "常规", "大"};
    private TextView tv_font;

    public FunctionFragment3(Context context) {
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmrnt3, container, false);
        ll_font = view.findViewById(R.id.ll_font);
        ll_mode = view.findViewById(R.id.ll_mode);
        tv_font = view.findViewById(R.id.tv_font);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ll_font.setOnClickListener(this);
        ll_mode.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_font:
                final ActionSheetDialog dialog = new ActionSheetDialog(mContext, stringItems1, ll_font);
                dialog.isTitleShow(false)
                        .title("字体选择")
                        .titleTextSize_SP(14)
                        .titleTextColor(Color.parseColor("#0000ff"))
                        .cancelText("取消")
                        .cancelText(getResources().getColor(R.color.gry33))
                        .itemTextColor(getResources().getColor(R.color.colorAccent))
                        .layoutAnimation(null)
                        .show();
                dialog.setOnOperItemClickL(new OnOperItemClickL() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0://小
                                tv_font.setText(stringItems1[position]);
                                SharedPreferencesUtil.setFloat(mContext, Constants.FONT_SIZE,14);
                                break;
                            case 1://常规
                                tv_font.setText(stringItems1[position]);
                                SharedPreferencesUtil.setFloat(mContext,Constants.FONT_SIZE,16);
                                break;
                            case 2://大
                                tv_font.setText(stringItems1[position]);
                                SharedPreferencesUtil.setFloat(mContext,Constants.FONT_SIZE,18);

                                break;
                        }
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.ll_mode:

                break;
        }
    }
}
