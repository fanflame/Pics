package com.ran.pics.util.imageload;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.ran.pics.R;
import com.ran.pics.application.UILApplication;

import java.io.File;

/**
 * Created by fanyiran on 16/11/16.
 */

public class UILImageLoaderUtils extends ImageLoaderUtils {

    private DisplayImageOptions options ;

    static private class ImageLoaderHolder {
        static UILImageLoaderUtils loader = new UILImageLoaderUtils();
    }

    static public UILImageLoaderUtils getInstance() {
        return ImageLoaderHolder.loader;
    }


    private UILImageLoaderUtils() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                UILApplication.getInstance()).threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCacheSize(50 * 1024 * 1024)
                // 50 Mb
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs() // Remove for release app
                .build();
        ImageLoader.getInstance().init(config);
        options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.mipmap.empty_photo)
                .showImageOnFail(R.mipmap.empty_photo)
                .resetViewBeforeLoading(true).cacheOnDisk(true)
                .cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .showImageOnLoading(R.mipmap.empty_photo)
                .bitmapConfig(Bitmap.Config.ARGB_8888).considerExifParams(true)
                .displayer(new SimpleBitmapDisplayer()).build();
    }

    @Override
    public void loadImage(Context context, String imgUrl, ImageView imageView, final OnLoadListener onLoadListener) {
        ImageLoader.getInstance().displayImage(
                imgUrl, imageView, options,
                new SimpleImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {
                        if (onLoadListener != null)
                            onLoadListener.onLoadingStarted();
                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view,
                                                FailReason failReason) {
                        String message = null;
                        switch (failReason.getType()) {
                            case IO_ERROR:
                                message = "Input/Output error";
                                break;
                            case DECODING_ERROR:
                                message = "Image can't be decoded";
                                break;
                            case NETWORK_DENIED:
                                message = "Downloads are denied";
                                break;
                            case OUT_OF_MEMORY:
                                message = "Out Of Memory error";
                                break;
                            case UNKNOWN:
                                message = "Unknown error";
                                break;
                        }
                        if (onLoadListener != null)
                            onLoadListener.onLoadingFailed(message);
                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view,
                                                  Bitmap loadedImage) {
                        if (onLoadListener != null)
                            onLoadListener.onLoadingComplete();
                    }
                }, new ImageLoadingProgressListener() {
                    @Override
                    public void onProgressUpdate(String imageUri, View view,
                                                 int current, int total) {
                        if (onLoadListener != null)
                            onLoadListener.onProgressUpdate();
                    }
                });
    }

    @Override
    public void loadImage(Context context, String imgUrl, ImageView imageView) {
        ImageLoader.getInstance().displayImage(imgUrl, imageView,
                options);
    }
    @Override
    public void cancelLoad(ImageView imageView) {
        ImageLoader.getInstance().cancelDisplayTask(imageView);
    }

    @Override
    public File getDiskCache(String imgUrl) {
        return ImageLoader.getInstance().getDiskCache().get(imgUrl);
    }

    @Override
    public void resume() {
        ImageLoader.getInstance().resume();
    }

    @Override
    public void pause() {
        ImageLoader.getInstance().pause();
    }


    @Override
    public void stop() {
        ImageLoader.getInstance().stop();
    }

    @Override
    public void destroy() {
        ImageLoader.getInstance().destroy();
    }

    @Override
    public void clearDiskCache() {
        ImageLoader.getInstance().clearDiskCache();
    }

}
