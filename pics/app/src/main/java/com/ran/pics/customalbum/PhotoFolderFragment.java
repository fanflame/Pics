package com.ran.pics.customalbum;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.ran.pics.R;
import com.ran.pics.customalbum.adapter.PhotoFolderAdapter;
import com.ran.pics.customalbum.bean.AlbumInfo;
import com.ran.pics.customalbum.bean.PhotoInfo;

import java.util.ArrayList;
import java.util.List;

/**    
 */
public class PhotoFolderFragment extends Fragment {

	public interface OnPageLodingClickListener {
		public void onPageLodingClickListener(List<PhotoInfo> list, String name);
	}

	private OnPageLodingClickListener onPageLodingClickListener;

	private ListView listView;

	private List<AlbumInfo> listImageInfo = new ArrayList<AlbumInfo>();

	private PhotoFolderAdapter listAdapter;
	private View view;
	private Activity activity;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity = activity;
		if (onPageLodingClickListener == null) {
			onPageLodingClickListener = (OnPageLodingClickListener) activity;
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		view = inflater
				.inflate(R.layout.fragment_photofolder, container, false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		listView = (ListView) getView().findViewById(R.id.listView);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
									long arg3) {
				onPageLodingClickListener.onPageLodingClickListener(
						listImageInfo.get(arg2).getList(),
						listImageInfo.get(arg2).getName_album());
			}
		});
	}

	public void setAdapter(PhotoFolderAdapter adapter) {
		listAdapter = adapter;
		listView.setAdapter(listAdapter);
	}

	public void setListImageInfo(List<AlbumInfo> listImageInfo) {
		this.listImageInfo = listImageInfo;
	}

	@Override
	public void onHiddenChanged(boolean hidden) {
		// TODO Auto-generated method stub
		Animation animation;
		if (hidden) {
			animation = AnimationUtils
					.loadAnimation(activity, R.anim.right_out);
			listView.startAnimation(animation);
		} else {
			animation = AnimationUtils.loadAnimation(activity, R.anim.right_in);
			listView.startAnimation(animation);
		}
		super.onHiddenChanged(hidden);
	}
}
