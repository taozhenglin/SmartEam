package com.cn.smarteam.view;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by tzl
 * on 2021/1/19
 */
public class RotateYAnimation extends Animation {
    int centerX, centerY;
    Camera camera=new Camera();

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        centerX=width/2;
        centerY=height/2;

        //动画执行时间  自行定义
        setDuration(1200);
//        setInterpolator(new DecelerateInterpolator());
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final Matrix matrix = t.getMatrix();
        camera.save();
        //中心是绕Y轴旋转  这里可以自行设置X轴 Y轴 Z轴
        camera.rotateY(180 * interpolatedTime);
        //把我们的摄像头加在变换矩阵上
        camera.getMatrix(matrix);
        //设置翻转中心点
        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);
        camera.restore();
    }
}
