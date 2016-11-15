package com.ran.pics.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    private static Toast toast;

    public static void show(Context context, String text) {
        if (toast != null)
            toast.cancel();
        (toast = Toast.makeText(context, text, Toast.LENGTH_SHORT)).show();
    }

    public static void cancel(){
        if(toast != null)
            toast.cancel();
    }
}
