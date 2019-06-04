package com.ran.pics.util;

import android.content.Context;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * 实现ViewPager左右滑动时的时差
 */
public class CustPagerTransformer implements ViewPager.PageTransformer {

    private int maxTranslateOffsetX;
    private ViewPager viewPager;

    public CustPagerTransformer(Context context) {
        this.maxTranslateOffsetX = dp2px(context, 180);
    }

    @Override
    public void transformPage(View view, float position) {
        if (viewPager == null) {
            viewPager = (ViewPager) view.getParent();
        }

        int leftInScreen = view.getLeft() - viewPager.getScrollX();
        int centerXInViewPager = leftInScreen + view.getMeasuredWidth() / 2;
        int offsetX = centerXInViewPager - viewPager.getMeasuredWidth() / 2;
        if (position == 0) {
            offsetX = 0;
        }
        float offsetRate = (float) offsetX * 0.38f / viewPager.getMeasuredWidth();
        float scaleFactor = 1 - Math.abs(offsetRate);
        if (scaleFactor > 0) {
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            view.setTranslationX(-maxTranslateOffsetX * offsetRate);
        }

//        if (inRange(position)) { // [-1, 1]
//            if (isRightPage(position)) { //(0, 1]
//
//                final int leftIndex = pageIndex - 1;
//                final int rightIndex = pageIndex;
//
//                final int leftColor = MainActivity.Content.values()[leftIndex].getColor();
//                final int rightColor = MainActivity.Content.values()[rightIndex].getColor();
//
//                final int composedColor = blendColors(leftColor, rightColor, position);
//                view.setBackgroundColor(composedColor);
//
//            } else if (isLeftPage(position)) { //[-1, 0)
//
//                final int leftIndex = pageIndex;
//                final int rightIndex = leftIndex + 1;
//
//                final int leftColor = MainActivity.Content.values()[leftIndex].getColor();
//                final int rightColor = MainActivity.Content.values()[rightIndex].getColor();
//
//                final int composedColor = blendColors(leftColor, rightColor, 1 - Math.abs(position));
//                view.setBackgroundColor(composedColor);
//
//            } else { // position == 0
//                view.setBackgroundColor(MainActivity.Content.values()[pageIndex].getColor());
//            }
//        } else { //(-Infinity, -1) or (1, + Infinity)
//            view.setBackgroundColor(MainActivity.Content.values()[pageIndex].getColor());
//        }
    }

    /**
     * dp和像素转换
     */
    private int dp2px(Context context, float dipValue) {
        float m = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * m + 0.5f);
    }

    public static boolean inRange(final float position) {
        return position <= 1.0 && position >= -1.0;
    }

    public static boolean isLeftPage(final float position) {
        return position < 0;
    }

    public static boolean isRightPage(final float position) {
        return position > 0;
    }

}
