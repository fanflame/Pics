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
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.ran.pics.bean.Pic;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Utils {
    public static int[] getScreenSize(Activity context) {
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


    public static void getPicThumbnail(ArrayList<Pic> picList) {
        int size = picList.size();
        Pic tempPic;
        String linkUrl;
        String[] tempStr;
        String temp;
        for (int i = 0; i < size; i++) {
            tempPic = picList.get(i);
            linkUrl = tempPic.getLinkUrl();
            tempStr = linkUrl.split("\\.");
            temp = tempStr[tempStr.length - 2];
            tempPic.setThumbnail(linkUrl.replace(temp, temp + "t"));
        }
    }

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
                fi.close();
                if (in != null)
                    in.close();
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

    public static void setWallPaper(Context context, String bmpPath) {
        WallpaperManager wallpaperManager = WallpaperManager
                .getInstance(context);
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeStream(new FileInputStream(bmpPath));
            wallpaperManager.setBitmap(bitmap);
        } catch (FileNotFoundException e) {
            ToastUtil.show(context, "图片未找到");
            e.printStackTrace();
            return;
        } catch (IOException e) {
            ToastUtil.show(context, "设置失败");
            e.printStackTrace();
            return;
        }
        ToastUtil.show(context, "设置成功");
    }

    public static void setLockPaper(Context context, String file) {
        WallpaperManager mWallManager = WallpaperManager.getInstance(context);
        Class class1 = mWallManager.getClass();// 获取类名
        try {
            Method setWallPaperMethod = class1.getMethod(
                    "setBitmapToLockWallpaper", Bitmap.class);// 获取设置锁屏壁纸的函数
            setWallPaperMethod.invoke(mWallManager,
                    BitmapFactory.decodeStream(new FileInputStream(file)));
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ToastUtil.show(context, "锁屏壁纸设置失败");
            return;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ToastUtil.show(context, "锁屏壁纸设置失败");
            return;
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ToastUtil.show(context, "锁屏壁纸设置失败");
            return;
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ToastUtil.show(context, "锁屏壁纸设置失败");
            return;
        }// 调用锁屏壁纸的函数，并指定壁纸的路径imageFilesPath
        catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ToastUtil.show(context, "锁屏壁纸设置失败");
            return;
        }
        ToastUtil.show(context, "锁屏壁纸设置成功");
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
        },"提示","确定要清除缓存图片吗？").show(fragmentManager,"");
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

    public static void shutDownKeyBoard(Activity context) {
        View view = context.getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
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

}
