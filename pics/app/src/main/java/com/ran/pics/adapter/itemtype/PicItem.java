package com.ran.pics.adapter.itemtype;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.palette.graphics.Palette;

import com.fanyiran.utils.recycleadapter.ItemType;
import com.fanyiran.utils.recycleadapter.RvViewHolder;
import com.ran.pics.R;
import com.ran.pics.bean.Pic;
import com.ran.pics.util.imageload.ImageLoaderUtils;
import com.ran.pics.util.imageload.OnLoadListenerAdapter;
import com.ran.pics.view.PaletteLinearLayout;

/**
 * Created by fanqiang on 2019-05-31.
 */
public class PicItem implements ItemType {
    public static final int TYPE_PIC = 0;
    private FrameLayout container;
    private FrameLayout cardBottom;
    private int imageRgb;
    private boolean onLoadComplete;
    private RvViewHolder rvViewHolder;

    @Override
    public boolean openClick() {
        return true;
    }

    @Override
    public int getType() {
        return TYPE_PIC;
    }

    @Override
    public int getLayout() {
        return R.layout.recycle_item_pic;
    }

    @Override
        public void fillContent(RvViewHolder rvViewHolder, int position, Object data) {
        this.rvViewHolder = rvViewHolder;
        PaletteLinearLayout view = (PaletteLinearLayout) rvViewHolder.getView(R.id.linearLayout);
        view.loadImage(((Pic) data).getLinkUrl());
    }

    @Override
    public boolean isCurrentType(Object data, int position) {
        return ((Pic) data).getItemType() == getType();
    }

}
