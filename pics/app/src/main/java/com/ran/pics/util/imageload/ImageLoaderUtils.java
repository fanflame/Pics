package com.ran.pics.util.imageload;

import android.widget.ImageView;

import java.io.File;

/**
 * Created by fanyiran on 16/11/16.
 */

public abstract class ImageLoaderUtils {

    public static ImageLoaderUtils getInstance(){
        return UILImageLoaderUtils.getInstance();
    }

    public interface OnLoadListener{
        void onLoadingStarted();
        void onLoadingFailed(String failMessage);
        void onLoadingComplete();
        void onProgressUpdate();
    }
    abstract public void loadImage(String imgUrl, ImageView imageView, final OnLoadListener onLoadListener);
    abstract public void loadImage(String imgUrl, ImageView imageView);
    abstract public void cancelLoad(ImageView imageView);
    abstract public File getDiskCache(String imgUrl);
    abstract public void resume();
    abstract public void pause();
    abstract public void stop();
    abstract public void destroy();
    abstract public void clearDiskCache();
}
