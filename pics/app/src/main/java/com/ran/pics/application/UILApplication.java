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
import android.os.Build;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;

import com.github.moduth.blockcanary.BlockCanary;
import com.ran.pics.util.AppBlockCanaryContext;
import com.ran.pics.util.Constant;
import com.squareup.leakcanary.LeakCanary;

/**
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public class UILApplication extends Application {
    private static DisplayMetrics dm = new DisplayMetrics();
    public static UILApplication instance;

    public static DisplayMetrics getDisplayMetrics() {
        return dm;
    }

    public static int getPicWidth(Activity context) {
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels / 2;
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
        if (Constant.Config.DEVELOPER_MODE) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll().penaltyDeath().build());
        }
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        BlockCanary.install(this, new AppBlockCanaryContext()).start();
        super.onCreate();

        instance = this;
    }

    public static UILApplication getInstance(){
        return instance;
    }

}