package com.ran.pics.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import com.ran.pics.R;

import butterknife.BindString;
import butterknife.BindView;

/**
 * Created by fanyiran on 16/11/13.
 */

public class SplashActivity extends BaseActivity {
    private final int DELAY_JUMP = 2000;
    private final int ANIMATION_DURATION = 1000;
    private Handler handler;
    @BindString(R.string.baidu_app_key)
    String baiduAppKey;
    @BindString(R.string.baidu_ad_splash_id)
    String baiduAdId;
    @BindView(R.id.llContainer)
    LinearLayout llContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash,false);
        init();
        delayJump();
    }

    private void init() {
        llContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                llContainer.setTranslationY(llContainer.getHeight());
                llContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                startAnimation();
            }
        });
        handler = new Handler();
    }

    private void delayJump() {
        handler.postDelayed(jump, DELAY_JUMP);
    }

    private Runnable jump = new Runnable() {
        @Override
        public void run() {
            MainActivity.startActivity(SplashActivity.this);
            SplashActivity.this.finish();
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (handler != null) {
            handler.removeCallbacks(jump);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void startAnimation(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(llContainer,"translationY",llContainer.getHeight(),0);
        animator.setDuration(ANIMATION_DURATION);
        animator.start();
    }
}
