package com.ran.pics.activity.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ran.pics.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fanqiang on 2019-06-06.
 */
public class ImageDetailMenuFragment extends Fragment {
    private static final int ANIM_DURATION = 300;
    private boolean isFirstResume = true;
    private OnImageDetailMenuHandleListener onImageDetailMenuHandleListener;
    @BindView(R.id.flRoot)
    FrameLayout flRoot;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_detail_menu, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        if (isFirstResume) {
            startEnterAnim();
            isFirstResume = false;
        }
        super.onResume();
    }

    private void startEnterAnim() {
        startAnim(0, 1);
    }

    private void startExistAnim() {
        startAnim(1, 0);
    }


    private void startAnim(float startAlph, float endAlph) {
        if (startAlph == 0) {
            flRoot.setVisibility(View.VISIBLE);
        }
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(flRoot, "alpha", startAlph, endAlph);
        objectAnimator.setDuration(ANIM_DURATION);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (endAlph == 0) {
                    flRoot.setVisibility(View.GONE);
                }
            }
        });
        objectAnimator.start();
    }

    @OnClick(R.id.ivClose)
    public void onCloseClick() {
        if (onImageDetailMenuHandleListener != null) {
            onImageDetailMenuHandleListener.onCloseClick();
        }
    }

    @OnClick(R.id.llDownLoad)
    public void onDownLoad(){
        if (onImageDetailMenuHandleListener != null) {
            onImageDetailMenuHandleListener.onDownLoadClick();
        }
    }

    @OnClick(R.id.llSetWallPaper)
    public void onSetWallPaperClick() {
        if (onImageDetailMenuHandleListener != null) {
            onImageDetailMenuHandleListener.onSetWallPaperClick();
        }
    }

    @OnClick(R.id.llSetLockPaper)
    public void onSetLockPaperClick() {
        if (onImageDetailMenuHandleListener != null) {
            onImageDetailMenuHandleListener.onSetLockPaperClick();
        }
    }
    public void setOnImageDetailMenuHandleListener(OnImageDetailMenuHandleListener onImageDetailMenuHandleListener) {
        this.onImageDetailMenuHandleListener = onImageDetailMenuHandleListener;
    }

    public interface OnImageDetailMenuHandleListener {
        void onCloseClick();

        void onDownLoadClick();

        void onSetWallPaperClick();

        void onSetLockPaperClick();
    }

    public void changeVisible() {
        if (flRoot.getVisibility() == View.GONE) {
            startEnterAnim();
        } else {
            startExistAnim();
        }
    }
}
