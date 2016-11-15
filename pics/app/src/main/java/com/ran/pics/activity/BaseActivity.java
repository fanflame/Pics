package com.ran.pics.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.ran.pics.R;
import com.ran.pics.util.ToastUtil;

import butterknife.ButterKnife;

public class BaseActivity extends FragmentActivity {
    private GestureDetector detector;

    private SimpleOnGestureListener onGestureListener = new SimpleOnGestureListener() {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            final int FLING_MIN_DISTANCE = 90, FLING_MIN_VELOCITY = 100;
            if (e2 != null && e1 != null
                    && e2.getX() - e1.getX() > FLING_MIN_DISTANCE
                    && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
                finish();
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        // 定义全屏参数
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        // 获得当前窗体对象
        Window window = this.getWindow();
        // 设置当前窗体为全屏显示
        window.setFlags(flag, flag);
        super.onCreate(arg0);
        initEvent();

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
            default:
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onStop() {
        super.onStop();
        ToastUtil.cancel();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        ButterKnife.bind(this);
    }

    private void initEvent() {
        detector = new GestureDetector(this, onGestureListener);
    }

    @Override
    public void finish() {
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
        super.finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
        super.onBackPressed();
    }
}
