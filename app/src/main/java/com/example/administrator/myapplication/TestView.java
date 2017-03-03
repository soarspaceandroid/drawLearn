package com.example.administrator.myapplication;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by Administrator on 2017/3/3.
 */

public class TestView extends View {

    private Paint paint;
    private int position = 0;

    public TestView(Context context) {
        super(context);
        initView(context);
    }

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.YELLOW);

        startValue();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int layerA = canvas.saveLayer(0,0,canvas.getWidth() , canvas.getHeight() ,paint , Canvas.ALL_SAVE_FLAG);
        canvas.drawRect(50,position,200,300 , paint);


        int layerB = canvas.saveLayer(0,0,canvas.getWidth(),canvas.getHeight(),paint,Canvas.HAS_ALPHA_LAYER_SAVE_FLAG);
        paint.setColor(Color.GRAY);
        canvas.drawCircle(200 , 300 , position , paint);


        invalidate();
//        canvas.drawColor(Color.TRANSPARENT , PorterDuff.Mode.CLEAR);

    }


    public void startValue(){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,200);
        valueAnimator.setDuration(10000);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                position = (int)valueAnimator.getAnimatedValue();
            }
        });

        final ValueAnimator valueAnimators = ValueAnimator.ofInt(200,100);
        valueAnimators.setDuration(10000);
        valueAnimators.setInterpolator(new DecelerateInterpolator());
        valueAnimators.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                position = (int)valueAnimator.getAnimatedValue();
            }
        });


        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                valueAnimators.start();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        valueAnimator.start();


    }

}
