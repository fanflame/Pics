package com.ran.pics.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.ran.pics.R;
import com.ran.pics.util.Utils;

public class AboutActivity extends BaseActivity {
	private TextView tv_version;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
        setContentView(R.layout.activity_about);
		initView();
        initData();
	}

	private void initView() {
		tv_version = (TextView) findViewById(R.id.tv_version);
	}

    private void initData(){
        tv_version.setText("版本号:" + Utils.getVersion(this));
    }
}
