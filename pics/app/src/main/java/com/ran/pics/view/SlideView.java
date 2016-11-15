package com.ran.pics.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;

public class SlideView extends LinearLayout{
    private float lastX;
    private float startX;
    private float endX;
    private float initTranslationX;

    public SlideView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        View handleChild = getChildAt(0);
        if (handleChild == null) {
            return super.onTouchEvent(event);
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = event.getX();
                float screenX = event.getRawX();
                startX = screenX;
                return true;
            case MotionEvent.ACTION_MOVE:
                changeX(event.getX() - lastX);
                endX = event.getRawX();
                return true;
            case MotionEvent.ACTION_UP:
                startAnim(endX - startX);
                return true;
            case MotionEvent.ACTION_CANCEL:
                startAnim(endX - startX);
                return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (getChildCount() == 1) {
            int width;
            int height;
            View child;
            LayoutParams lp;
            child = getChildAt(0);
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
            lp = (LayoutParams) child.getLayoutParams();
            initTranslationX = child.getMeasuredWidth();
            width = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            height = child.getMeasuredHeight();
            setMeasuredDimension(width, height);
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void changeX(float moveX) {
        float currentTransX = getTranslationX();
        float moveDistance = currentTransX + moveX;
        if (moveDistance <= 0) {
            return;
        }
        if (moveDistance >= initTranslationX) {
            moveDistance = initTranslationX;
        }
        this.setTranslationX(moveDistance);
    }

    private void startAnim(float moveDistance) {
        float currentTransX = getTranslationX();
        if (moveDistance > 0) {
            if (moveDistance / initTranslationX > 0.25) {
                animation(currentTransX, initTranslationX);
            } else {
                animation(currentTransX, 0);
            }
        }
    }

    private void animation(float fromPosition,final float toPosition) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "translationX", fromPosition, toPosition);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration((long) (Math.abs(toPosition - fromPosition) / initTranslationX * 300));
        animator.start();
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(toPosition == initTranslationX){
                    SlideView.this.post(new Runnable() {
                        @Override
                        public void run() {
                            ((Activity)getContext()).finish();
                        }
                    });
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

}
