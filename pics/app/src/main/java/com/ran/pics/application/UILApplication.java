/*******************************************************************************
 * Copyright 2011-2013 Sergey Tarasevich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.ran.pics.application;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.ran.pics.R;
import com.ran.pics.util.Constant;

/**
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public class UILApplication extends Application {
    public static final String slottoken = "wsPCEa1VT9jyzfWYRbCl/07s";
    private static DisplayMetrics dm = new DisplayMetrics();
    private static DisplayImageOptions imageOptions;

    private final String publicId = "nJ2cT/MIEYask6vGGw==";

    public static DisplayMetrics getDisplayMetrics() {
        return dm;
    }

    public static int getPicWidth(Activity context) {
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels / 2;
    }

    public static DisplayImageOptions initImageOption() {
        if (imageOptions == null)
            imageOptions = new DisplayImageOptions.Builder()
                    .showImageForEmptyUri(R.mipmap.empty_photo)
                    .showImageOnFail(R.mipmap.empty_photo)
                    .resetViewBeforeLoading(true).cacheOnDisk(true)
                    .cacheInMemory(true)
                    .imageScaleType(ImageScaleType.EXACTLY)
                    .showImageOnLoading(R.mipmap.empty_photo)
                    .bitmapConfig(Bitmap.Config.ARGB_8888).considerExifParams(true)
                    .displayer(new SimpleBitmapDisplayer()).build();
        return imageOptions;
    }

    public static void missKeyBoard(Activity context) {
        ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(
                        context
                                .getCurrentFocus()
                                .getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressWarnings("unused")
    @Override
    public void onCreate() {
        if (Constant.Config.DEVELOPER_MODE
                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
//            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                    .detectAll().penaltyDialog().build());
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll().penaltyDeath().build());
        }
//        MobiSageManager.newInstance().initMobiSageManager(this,
//                publicId, "");
        super.onCreate();
        initImageLoader(getApplicationContext());
    }

    public void initImageLoader(Context context) {
        // This configuration tuning is custom. You can tune every option, you
        // may tune some of them,
        // or you can create default configuration by
        // ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context).threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCacheSize(50 * 1024 * 1024)
                        // 50 Mb
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs() // Remove for release app
                .build();
        ImageLoader.getInstance().init(config);
    }
}