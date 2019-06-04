package com.ran.pics.util;

import android.content.Context;

/**
 * Created by fanqiang on 2019-05-28.
 */
public class OpppUtils {
    public static boolean hasNotchInScreen(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }
}
