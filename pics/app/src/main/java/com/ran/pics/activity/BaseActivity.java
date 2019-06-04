package com.ran.pics.activity;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.fanyiran.utils.recycleadapter.CreateRvHelper;
import com.fanyiran.utils.recycleadapter.ICreateRv;
import com.fanyiran.utils.recycleadapter.RvBaseAdapter;
import com.ran.pics.R;
import com.ran.pics.view.SlideView;

import butterknife.ButterKnife;

public class BaseActivity extends FragmentActivity implements ICreateRv {
    private CreateRvHelper createRvHelper;
    private SlideView slideView;

    @Override
    protected void onCreate(Bundle arg0) {
//        // 隐藏标题栏
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        // 隐藏状态栏
//        // 定义全屏参数
//        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
//        // 获得当前窗体对象
//        Window window = this.getWindow();
//        // 设置当前窗体为全屏显示
//        window.setFlags(flag, flag);
        super.onCreate(arg0);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void setContentView(int layoutResID) {
        setContentView(layoutResID,true);
    }

    public void setContentView(int layoutResID,boolean canSlideFinish){
        if(canSlideFinish){
            slideView = (SlideView) View.inflate(this,R.layout.activity_base,null);
            View.inflate(this, layoutResID,slideView);
            super.setContentView(slideView);
        }else{
            super.setContentView(layoutResID);
        }
        ButterKnife.bind(this);

        if (supportRecycleView()) {
            createRvHelper = new CreateRvHelper.Builder(this).build();
        }
    }

    @Override
    public void finish() {
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
        super.finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    ///////////////////////////////////////////////////////////////////////////
    // ICreateRv start
    ///////////////////////////////////////////////////////////////////////////

    protected boolean supportRecycleView() {
        return false;
    }
    @Override
    public RecyclerView getRecycleView() {
        return null;
    }

    @Override
    public RvBaseAdapter getAdapter() {
        return null;
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
    }

    @Override
    public RecyclerView.ItemDecoration getItemDecoration() {
        return new DividerItemDecoration(this,LinearLayoutManager.HORIZONTAL) ;
    }
    ///////////////////////////////////////////////////////////////////////////
    // ICreateRv end
    ///////////////////////////////////////////////////////////////////////////
}
