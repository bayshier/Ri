package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class AnimatorUtils {

    public static int tableDuration = 10000;

    /**
     * 控制View 旋转动画，
     * 属性动画
     *
     * @param context
     */
    public static void rotateViewShow(Context context, final ImageView view, float value) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "rotation", value);
        anim.setDuration(tableDuration);
        anim.start();

        //以下是补间动画  执行效果没有属性动画好
//        Animation animation = AnimationUtils.loadAnimation(context, R.anim.rotate_show);
//        animation.setDuration(300);
//        animation.setFillAfter(true);
//        animation.setFillBefore(false);
//        view1.startAnimation(animation);
    }

    public static void refreshView(final View view, ValueAnimator va, int duration) {
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //获取当前的height值
                int h = (Integer) valueAnimator.getAnimatedValue();
                //动态更新view的高度
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = h;
                view.setLayoutParams(layoutParams);
//                        ll_view.getLayoutParams().height = h;
//                        ll_view.requestLayout();
            }
        });
        va.setDuration(duration);
        //开始动画
        va.start();
    }


}
