package com.ran.pics.util;

import android.support.design.widget.Snackbar;
import android.view.View;

public class ToastUtil {
    public static void showShort(View view, String content,
                                 String actionContent, View.OnClickListener clickListener) {
        Snackbar.make(view, content, Snackbar.LENGTH_SHORT).setAction(actionContent, clickListener).show();
    }

    public static void showLong(View view, String content,
                                String actionContent, View.OnClickListener clickListener) {
        Snackbar.make(view, content, Snackbar.LENGTH_LONG).setAction(actionContent, clickListener).show();
    }

    public static void showShort(View view, String content) {
        Snackbar.make(view, content, Snackbar.LENGTH_SHORT).show();
    }
}
