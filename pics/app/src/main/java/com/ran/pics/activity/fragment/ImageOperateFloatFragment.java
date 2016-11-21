package com.ran.pics.activity.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ran.pics.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fanyiran on 16/11/20.
 */

public class ImageOperateFloatFragment extends Fragment {
    private final int ANIMATION_DURATION = 500;
    @BindView(R.id.tvDelete)
    TextView tvDelete;

    private OnFloatFragmentClickListener onFloatFragmentClickListener;
    public interface OnFloatFragmentClickListener{
        void onFloatFragmentDeleteClick();
    }

    public static ImageOperateFloatFragment getInstance(OnFloatFragmentClickListener onFloatFragmentClickListener){
        ImageOperateFloatFragment fragment = new ImageOperateFloatFragment();
        fragment.onFloatFragmentClickListener = onFloatFragmentClickListener;
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_operate,container,false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @OnClick(R.id.tvDelete)
    public void onTvDeleteClick(){
        if(onFloatFragmentClickListener != null){
            onFloatFragmentClickListener.onFloatFragmentDeleteClick();
        }
    }

    public void startAnimation(){
        if(isVisible()){
//            animate();
        }else{

        }
    }

    private void animate(final float start, final float end){
        ObjectAnimator animator = ObjectAnimator.ofFloat(getView(),"translationY",start,end);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float fraction = animation.getAnimatedFraction();
//                getView().setTranslationY(start + fraction * getView().getHeight());
//            }
//        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                if(start > end){

                }else{

                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(start > end){

                }else{

                }
            }
        });
        animator.setDuration(ANIMATION_DURATION);
        animator.start();
    }
}
