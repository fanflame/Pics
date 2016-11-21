package com.ran.pics.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ran.pics.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fanyiran on 16/11/21.
 */

public class TipsDialogFragment extends DialogFragment {
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvContent)
    TextView tvContent;
    @BindView(R.id.tvCancel)
    TextView tvCancel;
    @BindView(R.id.tvConfirm)
    TextView tvConfirm;


    private OnClickListener onClickListener;
    private String title;
    private String content;
    public interface OnClickListener{
        void onCancelClick();
        void onConfirmClick();
    }

    public static class OnClickListenerAdapter implements OnClickListener{

        @Override
        public void onCancelClick() {

        }

        @Override
        public void onConfirmClick() {

        }
    }

    public static TipsDialogFragment getInstance(OnClickListener onClickListener,String title,String content){
        TipsDialogFragment fragment = new TipsDialogFragment();
        fragment.onClickListener = onClickListener;
        fragment.title = title;
        fragment.content = content;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL,R.style.alert_dialog);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dialog_tip,container,false);
        ButterKnife.bind(this,rootView);
        initView();
        return rootView;
    }

    private void initView(){
        tvTitle.setText(title);
        tvContent.setText(content);
    }

    @OnClick(R.id.tvCancel)
    public void onTvCancelClick(){
        this.dismiss();
        if(onClickListener != null) {
            onClickListener.onCancelClick();
        }
    }

    @OnClick(R.id.tvConfirm)
    public void onTvConfrimClick(){
        this.dismiss();
        if(onClickListener != null) {
            onClickListener.onConfirmClick();
        }
    }
}
