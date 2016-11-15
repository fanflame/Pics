package com.ran.pics.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.ran.pics.activity.fragment.ImageDetailFragment;
import com.ran.pics.bean.Pic;
import com.ran.pics.view.ScaleAnimationImageView;

import java.util.ArrayList;

/**
 * Created by fanyiran on 15/5/5.
 */
public class ImagePagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Pic> picList;
    private ScaleAnimationImageView.SingleTapListener singleTapListener;

    public ImagePagerAdapter(FragmentManager fm, ArrayList<Pic> picList, ScaleAnimationImageView.SingleTapListener singleTapListener) {
        super(fm);
        this.picList = picList;
        this.singleTapListener = singleTapListener;
    }

    @Override
    public int getCount() {
        return picList == null?0:picList.size();
    }

    @Override
    public ImageDetailFragment getItem(int position) {
        return ImageDetailFragment.newInstance(position,
                picList.get(position),singleTapListener);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        final ImageDetailFragment fragment = (ImageDetailFragment) object;
        fragment.cancelWork();
        super.destroyItem(container, position, object);
    }
}

