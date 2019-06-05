package com.ran.pics.adapter.itemtype;

import com.fanyiran.utils.recycleadapter.ItemType;
import com.fanyiran.utils.recycleadapter.RvViewHolder;
import com.github.ybq.android.spinkit.SpinKitView;
import com.github.ybq.android.spinkit.SpriteFactory;
import com.github.ybq.android.spinkit.Style;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.ran.pics.R;
import com.ran.pics.bean.Pic;

/**
 * Created by fanqiang on 2019-06-04.
 */
public class LoadMoreItem implements ItemType {
    public static final int TYPE_LOAD_MORE = 1;
    @Override
    public boolean openClick() {
        return true;
    }

    @Override
    public int getType() {
        return TYPE_LOAD_MORE;
    }

    @Override
    public int getLayout() {
        return R.layout.recycle_item_pic_loadmore;
    }

    @Override
    public void fillContent(RvViewHolder rvViewHolder, int position, Object data) {
        Sprite drawable = SpriteFactory.create(Style.CHASING_DOTS);
        ((SpinKitView)(rvViewHolder.getView(R.id.spin_kit))).setIndeterminateDrawable(drawable);
    }

    @Override
    public boolean isCurrentType(Object data, int position) {
        return ((Pic) data).getItemType() == getType();
    }
}
