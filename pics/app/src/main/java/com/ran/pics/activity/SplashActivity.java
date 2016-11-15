package com.ran.pics.activity;

import android.os.Bundle;
import android.os.Handler;

import com.baidu.appx.BDSplashAd;
import com.ran.pics.R;

import butterknife.BindString;

/**
 * Created by fanyiran on 16/11/13.
 */

public class SplashActivity extends BaseActivity {
    private final int DELAY_JUMP = 2000;
    private Handler handler;
    @BindString(R.string.baidu_app_key)
    String baiduAppKey;
    @BindString(R.string.baidu_ad_id)
    String baiduAdId;

    private BDSplashAd splashAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash,false);
        init();
        delayJump();
    }

    private void init() {
        handler = new Handler();
        //创建开屏广告
        splashAd = new BDSplashAd(this, baiduAppKey, baiduAdId);
        splashAd.setAdListener(new BDSplashAd.SplashAdListener() {
            @Override
            public void onAdvertisementViewDidHide() {

            }

            @Override
            public void onAdvertisementDataDidLoadSuccess() {
//                //展示开屏广告
//                if (splashAd.isLoaded()) {
//                    splashAd.showAd();
//                }
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
}
