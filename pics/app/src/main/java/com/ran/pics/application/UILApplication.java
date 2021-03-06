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

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    public static UILApplication getInstance(){
        return instance;
    }

}