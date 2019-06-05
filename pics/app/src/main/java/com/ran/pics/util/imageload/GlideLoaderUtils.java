package com.ran.pics.util.imageload;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.SafeKeyGenerator;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.EmptySignature;
import com.ran.pics.R;

import java.io.File;
import java.io.IOException;

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

    private GlideLoaderUtils() {
        imageHolder = R.drawable.empty_photo;
    }

    @Override
    public void loadImage(Context context, String imgUrl, ImageView imageView, OnLoadListener onLoadListener) {
        Glide
                .with(context)
                .load(imgUrl)
                .centerCrop()
                .placeholder(imageHolder)
                .addListener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        onLoadListener.onLoadingFailed(e.getMessage());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        onLoadListener.onLoadingComplete(resource);
                        return false;
                    }
                })
                .into(imageView);
    }

    @Override
    public void loadImage(Context context, String imgUrl, ImageView imageView) {
        Glide.with(context).load(imgUrl).centerCrop().into(imageView);
    }

    @Override
    public void cancelLoad(ImageView imageView) {

    }

    @Override
    public File getDiskCache(Context context,String imgUrl) {
        File cacheFile = getCacheFile2(context,imgUrl);
        return cacheFile;
    }

    public File getCacheFile2(Context context,String url) {
        DataCacheKey dataCacheKey = new DataCacheKey(new GlideUrl(url), EmptySignature.obtain());
        SafeKeyGenerator safeKeyGenerator = new SafeKeyGenerator();
        String safeKey = safeKeyGenerator.getSafeKey(dataCacheKey);
        try {
            int cacheSize = 100 * 1000 * 1000;
            DiskLruCache diskLruCache = DiskLruCache.open(new File(context.getCacheDir(), DiskCache.Factory.DEFAULT_DISK_CACHE_DIR), 1, 1, cacheSize);
            DiskLruCache.Value value = diskLruCache.get(safeKey);
            if (value != null) {
                return value.getFile(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
