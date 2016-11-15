package com.ran.pics.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.ran.pics.R;
import com.ran.pics.application.UILApplication;
import com.ran.pics.customalbum.PhotoFolderFragment;
import com.ran.pics.customalbum.PhotoFolderFragment.OnPageLodingClickListener;
import com.ran.pics.customalbum.PhotoFragment;
import com.ran.pics.customalbum.adapter.PhotoAdapter;
import com.ran.pics.customalbum.bean.PhotoInfo;
import com.ran.pics.customalbum.bean.PhotoSerializable;

import java.util.ArrayList;
import java.util.List;

/**
 * @title SelectPhotoActivity.java
 * @package com.centaline.mhc.activity.friendGroupActivity
 * @author guilin
 * @date 2013-8-6 上午10:42:15
 */
public class SelectPhotoActivity extends BaseActivity implements
		OnPageLodingClickListener, PhotoAdapter.OnPhotoSelectClickListener {
	private PhotoFolderFragment photoFolderFragment;
	PhotoFragment photoFragment;

	private Button btn_preview, btn_send;

	private ArrayList<PhotoInfo> hasList;

	private FragmentManager manager;
	private View v_bg;

	private final int MAXPICMUN = 10;

	private int checked = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selectphoto);

//		findViewById(R.id.root).setPadding(0, Utils.getActionBarHeight(this),
//				0, 0);

		getWindowManager().getDefaultDisplay().getMetrics(
				UILApplication.getDisplayMetrics());

		manager = getSupportFragmentManager();

		hasList = new ArrayList<PhotoInfo>();
		btn_send = (Button) findViewById(R.id.btn_send);
		btn_preview = (Button) findViewById(R.id.btn_preview);

		photoFolderFragment = new PhotoFolderFragment();

		FragmentTransaction transaction = manager.beginTransaction();
		photoFragment = new PhotoFragment();
		transaction.add(R.id.body, photoFragment).commit();
		transaction = manager.beginTransaction();
		transaction.add(R.id.body, photoFolderFragment).commit();
		transaction = manager.beginTransaction();
		transaction.hide(photoFolderFragment);
		photoFragment.setPhotoFolderFragment(photoFolderFragment);
		transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		transaction.commit();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.imagefolder_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
//		case R.id.showFolder:
//			showFileFolder();
//			break;
//		case R.id.deleteimage:
//			break;
		}
		return super.onContextItemSelected(item);
	}

	private void showFileFolder() {
		FragmentTransaction transaction = manager.beginTransaction();
		if (photoFolderFragment.isHidden()) {
			transaction.show(photoFolderFragment);
		} else {
			transaction.hide(photoFolderFragment);
		}
		transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		transaction.commit();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	public void onPageLodingClickListener(List<PhotoInfo> list, String name) {
		// TODO Auto-generated method stub
		FragmentTransaction transaction = manager.beginTransaction();
		PhotoSerializable photoSerializable = new PhotoSerializable();
		for (PhotoInfo photoInfoBean : list) {
			photoInfoBean.setChoose(false);
		}
		photoSerializable.setList(list);
		photoFragment.setAdapterList(photoSerializable);

		transaction.hide(photoFolderFragment).commit();
		transaction = manager.beginTransaction();
		transaction.show(photoFragment);
		transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		// Commit the transaction
		transaction.commit();
		hasList.clear();
		btn_preview.setEnabled(false);
	}

	@Override
	public void onPhotoSelectClickListener(List<PhotoInfo> list) {
		// TODO Auto-generated method stub
		hasList.clear();
		for (PhotoInfo photoInfoBean : list) {
			if (photoInfoBean.isChoose()) {
				hasList.add(photoInfoBean);
			}
		}
		if (hasList.size() >= 1) {
			btn_preview.setEnabled(true);
		} else {
			btn_preview.setEnabled(false);
		}
		int i = 0;
	}

	public void btnPreview(View v) {
	}

	public void btnSend(View v) {
	}

}
