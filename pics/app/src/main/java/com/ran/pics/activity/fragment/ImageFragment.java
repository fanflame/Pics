package com.ran.pics.activity.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.palette.graphics.Palette;

import com.bumptech.glide.load.engine.Resource;
import com.ran.pics.R;
import com.ran.pics.bean.Pic;
import com.ran.pics.util.Utils;
import com.ran.pics.util.imageload.ImageLoaderUtils;
import com.ran.pics.util.imageload.OnLoadListenerAdapter;
import com.ran.pics.view.ScaleAnimationImageView;

/**
 * Created by fanqiang on 2019-05-29.
 */
public class ImageFragment extends Fragment {
    private static final String IMAGE_DATA_EXTRA = "resId";
    private static final String PIC = "pic";
    public static final int DETAIL_IMG_TAG = R.id.tag_img_detail;

    private ImageView mImageView;
    private Pic pic;
    private View rootView;
    private FrameLayout container;
    private FrameLayout cardBottom;
    private int imageRgb;

    private ImageFragment() {
    }

    public static ImageFragment newInstance(Pic pic) {
        final ImageFragment f = new ImageFragment();
        final Bundle args = new Bundle();
        args.putSerializable(PIC, pic);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pic = (Pic) (getArguments() != null ? getArguments().getSerializable(
                PIC) : null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        if(rootView != null){
//            ViewGroup parent = (ViewGroup) rootView.getParent();
//            if (parent != null) {
//                parent.removeView(rootView);
//            }
//        }else{
        rootView = inflater.inflate(R.layout.fragment_image,
                container, false);
        initView(rootView);
        initEvent();
//        }
        return rootView;
    }

    private void initView(View v) {
        mImageView = (ImageView) v.findViewById(R.id.imageView);
        mImageView.setTag(DETAIL_IMG_TAG, pic);
        container = (FrameLayout) v.findViewById(R.id.container);
        cardBottom = v.findViewById(R.id.cardBottom);
    }

    private void initEvent() {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageLoaderUtils.getInstance().loadImage(getActivity(), pic.getLinkUrl(), mImageView, new OnLoadListenerAdapter() {
            @Override
            public void onLoadingComplete(Drawable resource) {
                BitmapDrawable bd = (BitmapDrawable) resource;
                Bitmap bm = bd.getBitmap();
                getColor(bm);
            }
        });
        if (View.OnClickListener.class.isInstance(getActivity())
                && Utils.hasActionBar()) {
            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    public Pic getPic() {
        return pic;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void cancelWork() {
        ImageLoaderUtils.getInstance().cancelLoad(mImageView);
    }

    private void getColor(Bitmap bitmap) {
        Palette.Builder builder = Palette.from(bitmap);
        builder.generate(palette -> {
            if (palette == null) {
                return;
            }
            Palette.Swatch swatch = palette.getLightVibrantSwatch(); //获取到充满活力的这种色调
            if (swatch != null) {
                imageRgb = swatch.getRgb();
                container.setBackgroundColor(imageRgb);
                cardBottom.setBackgroundColor(imageRgb);
            }
////                Palette.Swatch s = palette.getDarkVibrantSwatch(); //获取充满活力的黑
////                Palette.Swatch s = palette.getLightVibrantSwatch(); //获取充满活力的亮
////                Palette.Swatch s = palette.getMutedSwatch(); //获取柔和的色调
////                Palette.Swatch s = palette.getDarkMutedSwatch(); //获取柔和的黑
////                Palette.Swatch s = palette.getLightMutedSwatch(); //获取柔和的亮
//
////            List<Palette.Swatch> mSwatch = palette.getSwatches();//获取到多种颜色
////            swatch.getBodyTextColor();// 获取文本颜色，避免在特殊颜色背景下，看不到文本
////            swatch.getTitleTextColor();
        });
    }
}
