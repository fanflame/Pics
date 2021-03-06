package com.ran.pics.util;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.ran.pics.dialog.TipsDialogFragment;
import com.ran.pics.util.imageload.ImageLoaderUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.Random;

public class Utils {
    public static int[] getScreenSize(AppCompatActivity context) {
        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metric);
        int[] array = new int[2];
        array[0] = metric.widthPixels;
        array[1] = metric.heightPixels;
        return array;
    }

    public static long getTokenTime() {
        return new Date().getTime() + 3600;
    }

    public static boolean hasActionBar() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    public static int getActionBarHeight(Context context) {
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize,
                tv, true)) {
            return TypedValue.complexToDimensionPixelSize(tv.data, context
                    .getResources().getDisplayMetrics());
        }
        return 0;
    }


//    public static void getPicThumbnail(ArrayList<Pic> picList) {
//        int size = picList.size();
//        Pic tempPic;
//        String linkUrl;
//        String[] tempStr;
//        String temp;
//        for (int i = 0; i < size; i++) {
//            tempPic = picList.get(i);
//            linkUrl = tempPic.getLinkUrl();
//            tempStr = linkUrl.split("\\.");
//            temp = tempStr[tempStr.length - 2];
//            tempPic.setThumbnail(linkUrl.replace(temp, temp + "t"));
//        }
//    }

    public static int getRandomRightPadding() {
        return Math.abs(new Random().nextInt()) % 50 + 30;
    }

    public static int getRandomAniamtionDuration() {
        return Math.abs(new Random().nextInt()) % 200 + 400;
    }


    public static void saveBitmap(Bitmap bm, String bmpTargetPath, String picName) {
        File path = new File(Environment.getExternalStorageDirectory()
                + bmpTargetPath);
        if (!path.exists())
            path.mkdirs();
        File f = new File(Environment.getExternalStorageDirectory() + bmpTargetPath,
                picName + ".jpg");
        try {
            FileOutputStream out = new FileOutputStream(f);
            bm.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * @param source
     * @param target 拷贝文件
     */
    public static boolean fileChannelCopy(File source, File target) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        if (!target.exists()) {
            try {
                target.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        try {
            fi = new FileInputStream(source);
            fo = new FileOutputStream(target);
            in = fi.getChannel();// 得到对应的文件通道
            out = fo.getChannel();// 得到对应的文件通道
            in.transferTo(0, in.size(), out);// 连接两个通道，并且从in通道读取，然后写入out通道
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (fi != null)
                    fi.close();
                if (in != null)
                    in.close();
                if (fo != null)
                    fo.close();
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static void setWallPaper(Context context, String bmpPath, View view) {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeStream(new FileInputStream(bmpPath));
            wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK);
        } catch (Exception e) {
            ToastUtil.showShort(view, "设置失败");
            e.printStackTrace();
            return;
        }
        ToastUtil.showShort(view, "设置成功");
    }

    public static void setLockPaper(Context context, String bmpPath, View view) {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeStream(new FileInputStream(bmpPath));
            wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_SYSTEM);
        } catch (Exception e) {
            ToastUtil.showShort(view, "设置失败");
            e.printStackTrace();
            return;
        }
        ToastUtil.showShort(view, "设置成功");
    }

    public static void deleteSplashBmp(String bmpPath) {
        File path = new File(Environment.getExternalStorageDirectory()
                + bmpPath);
        if (!path.exists()) {
            return;
        }
        File[] file = path.listFiles();
        if (file != null && file.length != 0) {
            file[0].delete();
        }

    }

    /**
     * @param picName
     * @return 是不是新的图片
     */
    public static boolean isNewSplashPic(String bmpPath, String picName) {
        File path = new File(Environment.getExternalStorageDirectory()
                + bmpPath);
        File[] files = path.listFiles();
        return files == null ? false : files.length == 0 ? false : files[0]
                .getName().startsWith(picName);
    }

    public static void clearCache(FragmentManager fragmentManager) {
        TipsDialogFragment.getInstance(new TipsDialogFragment.OnClickListenerAdapter() {

            @Override
            public void onConfirmClick() {
                ImageLoaderUtils.getInstance().clearDiskCache();
            }
        }, "提示", "确定要清除缓存图片吗？").show(fragmentManager, "");
    }


    public static String getVersion(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(),
                    0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    public static void shutDownKeyBoard(AppCompatActivity context) {
        View view = context.getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void missKeyBoard(Activity context) {
        ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public static void showSoftKeyboard(EditText view, Context mContext) {
        if (view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    public static boolean createNoMediaFile() {
        File temp = new File(Environment.getExternalStorageDirectory()
                + Constant.Config.DOWN_BMP_PATH);
        if (!temp.exists())
            temp.mkdirs();
        File noMediaFile = new File(temp.getAbsolutePath() + "/.nomedia");
        try {
            noMediaFile.createNewFile();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static boolean deleteNoMediaFile() {
        File noMediaFile = new File(Environment.getExternalStorageDirectory()
                + Constant.Config.DOWN_BMP_PATH + ".nomedia");
        return noMediaFile.delete();
    }

    public static boolean hasNotchInScreen(Context context) {
        return false;
    }

    public static void setFullScreenWindowLayoutInDisplayCutout(Window window) {
        // TODO: 2019-05-28 判断手机
        HuaweiUtils.setFullScreenWindowLayoutInDisplayCutout(window);
    }

    public static void setNavigatorColor(int color, Window window) {
        window.setNavigationBarColor(color);
    }

    public static void setNavigatorHidden(Window window) {
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    public static void setStatusBarColor(Window window, int color) {
        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏颜色
        window.setStatusBarColor(color);
    }

}
