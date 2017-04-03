package com.ran.pics.util.imageload;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ran.pics.R;

import java.io.File;

/**
 * Created by fanyiran on 16/11/26.
 */

public class GlideLoaderUtils extends ImageLoaderUtils {
    private int imageHolder;
    static private class ImageLoaderHolder {
        static GlideLoaderUtils loader = new GlideLoaderUtils();
    }

    static public GlideLoaderUtils getInstance() {
        return ImageLoaderHolder.loader;
    }

    private GlideLoaderUtils(){
        imageHolder = R.drawable.empty_photo;
    }

    @Override
    public void loadImage(Context context, String imgUrl, ImageView imageView, OnLoadListener onLoadListener) {
        Glide
                .with(context)
                .load(imgUrl)
                .centerCrop()
                .placeholder(imageHolder)
                .crossFade()
                .into(imageView);
    }

    @Override
    public void loadImage(Context context,String imgUrl, ImageView imageView) {
        Glide.with(context).load(imgUrl).into(imageView);
    }

    @Override
    public void cancelLoad(ImageView imageView) {

    }

    @Override
    public File getDiskCache(String imgUrl) {
        return null;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {
    }

    @Override
    public void clearDiskCache() {
    }
}
