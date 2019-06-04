package com.ran.pics.adapter;

import com.fanyiran.utils.recycleadapter.RvBaseAdapter;
import com.ran.pics.adapter.itemtype.PicItem;

import java.util.List;

/**
 * Created by fanqiang on 2019-05-31.
 */
public class RecycleViewAdapter extends RvBaseAdapter {
    public RecycleViewAdapter(List baseDataList) {
        super(baseDataList);
        addItemType(new PicItem());
    }


}
