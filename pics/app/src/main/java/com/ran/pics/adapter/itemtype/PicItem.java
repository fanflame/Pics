package com.ran.pics.adapter.itemtype;

import com.fanyiran.utils.recycleadapter.ItemType;
import com.fanyiran.utils.recycleadapter.RvViewHolder;
import com.ran.pics.R;
import com.ran.pics.bean.Pic;
import com.ran.pics.view.PaletteLinearLayout;

/**
 * Created by fanqiang on 2019-05-31.
 */
public class PicItem implements ItemType {

    @Override
    public boolean openClick() {
        return true;
    }

    @Override
    public int getType() {
        return ItemTypeConstants.TYPE_PIC;
    }

    @Override
    public int getLayout() {
        return R.layout.recycle_item_pic;
    }

    @Override
        public void fillContent(RvViewHolder rvViewHolder, int position, Object data) {
        PaletteLinearLayout view = (PaletteLinearLayout) rvViewHolder.getView(R.id.linearLayout);
        view.loadImage(((Pic) data).getLinkUrl());
    }

    @Override
    public boolean isCurrentType(Object data, int position) {
        return ((Pic) data).getItemType() == getType();
    }

}
