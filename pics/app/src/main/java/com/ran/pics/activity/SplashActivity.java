package com.ran.pics.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import com.baidu.appx.BDInterstitialAd;
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

    private BDInterstitialAd splashAd;

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
        //创建开屏广告
        splashAd = new BDInterstitialAd(this, baiduAppKey, baiduAdId);
        splashAd.setAdListener(new BDInterstitialAd.InterstitialAdListener() {
            @Override
            public void onAdvertisementViewDidHide() {

            }

            @Override
            public void onAdvertisementDataDidLoadSuccess() {
//                //展示开屏广告
                if (splashAd.isLoaded()) {
                    splashAd.showAd();
                }
            }

            @Override
            public void onAdvertisementDataDidLoadFailure() {

            }

            @Override
            public void onAdvertisementViewDidShow() {

            }

            @Override
            public void onAdvertisementViewDidClick() {

            }

            @Override
            public void onAdvertisementViewWillStartNewIntent() {

            }
        });
        //如果本地无广告可用,需要下载广告,待下次启动使用
        if (!splashAd.isLoaded()) {
            splashAd.loadAd();
        }else{
            splashAd.showAd();
        }
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
        //销毁广告对象
        if(splashAd != null){
            splashAd.destroy();
            splashAd = null;
        }

    }

    public void startAnimation(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(llContainer,"translationY",llContainer.getHeight(),0);
        animator.setDuration(ANIMATION_DURATION);
        animator.start();
    }
}
