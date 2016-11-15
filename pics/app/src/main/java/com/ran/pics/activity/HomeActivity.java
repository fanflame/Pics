package com.ran.pics.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.ran.pics.R;
import com.ran.pics.view.MaterialSytle.LFrameLayout;
import com.ran.pics.view.pulllayout.PullToZoomLayout;

public class HomeActivity extends BaseActivity implements OnClickListener {

	private PullToZoomLayout zoomLayout;
	private LFrameLayout home_moreclassifi;
	private LFrameLayout mydown;
	private LFrameLayout about;
	private LFrameLayout clearCache;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.home);

		initView();
		// pullToZoomLayout图片
//		NetWork.getHomeBmpUrl(((ImageView) (zoomLayout.getHeaderView())), this);
	}

	private void initView() {
		// pullToZoomLayout图片
		zoomLayout = (PullToZoomLayout) findViewById(R.id.zoom_layout);
//		zoomLayout.setPadding(0, Utils.getActionBarHeight(this), 0, 0);

		home_moreclassifi = (LFrameLayout) findViewById(R.id.home_moreclassifi);
		mydown = (LFrameLayout) findViewById(R.id.mydown);
		about = (LFrameLayout) findViewById(R.id.about);
		clearCache = (LFrameLayout) findViewById(R.id.clearCache);

		home_moreclassifi.setOnClickListener(this);
		mydown.setOnClickListener(this);
		about.setOnClickListener(this);
		clearCache.setOnClickListener(this);

//		home_moreclassifi.setBackgroundDrawable(getResources().getDrawable(
//				Utils.pageBGColor));
//		mydown.setBackgroundDrawable(getResources().getDrawable(
//				Utils.pageBGColor));
//		about.setBackgroundDrawable(getResources().getDrawable(
//				Utils.pageBGColor));
//		clearCache.setBackgroundDrawable(getResources().getDrawable(
//				Utils.pageBGColor));
		// zoomLayout.setOnTouchListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mydown:
			Intent intentPhoto = new Intent(this, SelectPhotoActivity.class);
			startActivity(intentPhoto);
			this.overridePendingTransition(R.anim.right_in, R.anim.left_out);
			break;
		case R.id.clearCache:
//			Utils.clearCache(this);
			break;
		case R.id.about:
			Intent intentMore = new Intent(this, AboutActivity.class);
			startActivity(intentMore);
			this.overridePendingTransition(R.anim.right_in, R.anim.left_out);
			break;
		}
	}
}
