package com.ran.pics.adapter.itemtype;

import com.fanyiran.utils.recycleadapter.ItemType;
import com.fanyiran.utils.recycleadapter.RvViewHolder;
import com.ran.pics.R;
import com.ran.pics.bean.Pic;

/**
 * Created by fanqiang on 2019-06-06.
 */
public class NoMoreItem implements ItemType {

    @Override
    public boolean openClick() {
        return false;
    }

    @Override
    public int getType() {
        return ItemTypeConstants.TYPE_NOMORE;
    }

    @Override
    public int getLayout() {
        return R.layout.recycle_item_pic_nomore;
    }

    @Override
    public void fillContent(RvViewHolder rvViewHolder, int position, Object data) {

    }

    @Override
    public boolean isCurrentType(Object data, int position) {
        return ((Pic) data).getItemType() == getType();
    }
}
