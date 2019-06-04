package com.ran.pics.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.palette.graphics.Palette;

import com.ran.pics.R;
import com.ran.pics.util.imageload.ImageLoaderUtils;
import com.ran.pics.util.imageload.OnLoadListenerAdapter;

import java.lang.ref.WeakReference;

/**
 * Created by fanqiang on 2019-06-03.
 */
public class PaletteLinearLayout extends LinearLayout {
    private ImageView imageView;
    private boolean isLoaded = false;
    private boolean isRequestColor = false;
    private WeakReference<OnGetPaletteColorLitener> onGetPaletteColorLitener;
    private long tag;

    public PaletteLinearLayout(Context context) {
        super(context);
        init();
    }

    public PaletteLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        // TODO: 2019-06-03 多一层linearlayout
        View view = View.inflate(getContext(), R.layout.recycle_item_pic_child, this);
        imageView = view.findViewById(R.id.imageView);
    }


    public void loadImage(String linkUrl) {
        isLoaded = false;
        isRequestColor = false;
        onGetPaletteColorLitener = null;
        tag = -1;
        ImageLoaderUtils.getInstance().loadImage(getContext(), linkUrl,
                imageView, new OnLoadListenerAdapter() {
                    @Override
                    public void onLoadingComplete(Drawable resource) {
                        isLoaded = true;
                        if (isRequestColor) {
                            getPaletteColor(tag, null);
                        }
                    }
                });
    }

    public void getPaletteColor(long tag, OnGetPaletteColorLitener onGetPaletteColorLitener) {
        // TODO: 2019-05-31 内存泄露？
        this.tag = tag;
        this.onGetPaletteColorLitener = new WeakReference<>(onGetPaletteColorLitener);
        isRequestColor = true;
        if (!isLoaded) {
            return;
        }
        BitmapDrawable bd = (BitmapDrawable) imageView.getDrawable();
        Palette.Builder builder = Palette.from(bd.getBitmap());
        builder.generate(palette -> {
            if (palette == null) {
                return;
            }
            Palette.Swatch swatch = getSwatch(palette);
            if (swatch != null) {
                if (onGetPaletteColorLitener != null) {
                    onGetPaletteColorLitener.onGetPaletteColor(tag, swatch.getRgb());
                }
            }
        });
    }

    private Palette.Swatch getSwatch(Palette palette) {
        Palette.Swatch swatch = palette.getLightVibrantSwatch(); //获取到充满活力的这种色调
        if (swatch != null) {
            return swatch;
        }
        swatch = palette.getDominantSwatch();
        if (swatch != null) {
            return swatch;
        }
        swatch = palette.getMutedSwatch();
        if (swatch != null) {
            return swatch;
        }
        swatch = palette.getVibrantSwatch();
        if (swatch != null) {
            return swatch;
        }
        swatch = palette.getDarkMutedSwatch();

        if (swatch != null) {
            return swatch;
        }
        swatch = palette.getDarkVibrantSwatch();

        if (swatch != null) {
            return swatch;
        }
        swatch = palette.getLightMutedSwatch();
        return swatch;
    }

    public interface OnGetPaletteColorLitener {
        void onGetPaletteColor(long tag, int color);
    }
}
