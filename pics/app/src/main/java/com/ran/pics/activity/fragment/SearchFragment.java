package com.ran.pics.activity.fragment;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fanyiran.utils.LogUtil;
import com.ran.pics.R;
import com.ran.pics.util.ToastUtil;
import com.ran.pics.util.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fanyiran on 16/11/14.
 */

public class SearchFragment extends Fragment {
    private static final String TAG = "SearchFragment";
    private static final int ANIM_DURATION = 300;
    @BindView(R.id.ivMenu)
    ImageView ivMenu;
    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.ivSearch)
    ImageView ivSearch;
    @BindView(R.id.bodyLayout)
    FrameLayout bodyLayout;
    @BindView(R.id.searchContainer)
    LinearLayout searchContainer;

    private int menuWidth;
    private int searchWidth;

    private View rootView;
    private boolean fristResume = true;
    private int lastColor;
    private OnSearchClick onSearchClick;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_search,container,false);
        ButterKnife.bind(this,rootView);
        menuWidth = (int) getResources().getDimension(R.dimen.menu_width);
        searchWidth = getResources().getDimensionPixelSize(R.dimen.search_width);
        return rootView;
    }

    @Override
    public void onResume() {
        if (fristResume) {
            startEntryAnim();
            fristResume = false;
        }
        super.onResume();
    }

    private void startEntryAnim() {
        rootView.setVisibility(View.VISIBLE);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this,"changeAnim",1.0f,0f);
        objectAnimator.setDuration(ANIM_DURATION);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                etSearch.requestFocus();
                Utils.showSoftKeyboard(etSearch,getContext());
            }
        });
        objectAnimator.start();
    }
    private void startExitAnim() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this,"changeAnim",0f,1f);
        objectAnimator.setDuration(ANIM_DURATION);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                rootView.setVisibility(View.GONE);
                Utils.missKeyBoard(getActivity());
            }
        });
        objectAnimator.start();
    }

//    private void startExitAnimWithKeyWord() {
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this,"changeAnim",0f,1f);
//        objectAnimator.setDuration(ANIM_DURATION);
//        objectAnimator.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                rootView.setVisibility(View.GONE);
//                Utils.missKeyBoard(getActivity());
//            }
//        });
//        objectAnimator.start();
//    }

    private void setChangeAnim(float value) {
        ivMenu.setAlpha(value);
        ViewGroup.LayoutParams layoutParams = ivMenu.getLayoutParams();
        layoutParams.height = (int) (menuWidth * value);
        layoutParams.width = layoutParams.height;
        ivMenu.setLayoutParams(layoutParams);

        bodyLayout.setAlpha(1-value);
        ivSearch.setAlpha(1-value);
        ViewGroup.LayoutParams layoutParamsSearch = ivSearch.getLayoutParams();
        layoutParamsSearch.width = (int) ((1 - value) * searchWidth);
        layoutParamsSearch.height = layoutParamsSearch.width;
        ivSearch.setLayoutParams(layoutParamsSearch);
    }

    public void setVisible(boolean visible) {
        setVisible(visible,lastColor);
    }

    public void setVisible(boolean visible,int lastColor) {
        setSearchColor(lastColor);
        if (visible) {
            etSearch.setText("");
            startEntryAnim();
        } else {
            startExitAnim();
        }
    }

    public boolean getVisible() {
        return rootView.getVisibility() == View.VISIBLE;
    }

    public void setSearchColor(int lastColor) {
        if (this.lastColor == lastColor) {
            return;
        }
        this.lastColor = lastColor;
        searchContainer.setBackgroundColor(lastColor);
    }

    public interface OnSearchClick {
        void onSearchClick(String keyWord);
    }

    public void setOnSearchClick(OnSearchClick onSearchClick) {
        this.onSearchClick = onSearchClick;
    }

    @OnClick(R.id.ivSearch)
    public void onSearchClick() {
        if (TextUtils.isEmpty(etSearch.getText().toString())) {
            ToastUtil.showShort(etSearch,"请输入关键字");
            return;
        }
        if (onSearchClick != null) {
            onSearchClick.onSearchClick(etSearch.getText().toString().trim());
        }
        Utils.missKeyBoard(getActivity());
        startExitAnim();
    }

}
