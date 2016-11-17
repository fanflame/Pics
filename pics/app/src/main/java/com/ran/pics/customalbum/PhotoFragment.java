package com.ran.pics.customalbum;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Thumbnails;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.ran.pics.R;
import com.ran.pics.customalbum.adapter.PhotoAdapter;
import com.ran.pics.customalbum.adapter.PhotoFolderAdapter;
import com.ran.pics.customalbum.bean.AlbumInfo;
import com.ran.pics.customalbum.bean.PhotoInfo;
import com.ran.pics.customalbum.bean.PhotoSerializable;
import com.ran.pics.customalbum.util.ThumbnailsUtil;
import com.ran.pics.util.imageload.ImageLoaderUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;

/**    
 */
public class PhotoFragment extends Fragment {
	private PhotoFolderFragment folderFragment;

	private GridView gridView;
	private PhotoAdapter photoAdapter;

	private List<PhotoInfo> list;
	private List<AlbumInfo> listImageInfo = new ArrayList<AlbumInfo>();
	List<PhotoInfo> listFileAll;

	private LinearLayout loadingLay;
	private ContentResolver cr;
	PhotoSerializable photoSerializable;
	private Activity activity;
	ArrayList<String> photoPath;// 当前相册所有图片路径

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity = activity;

		Bundle args = getArguments();
		listImageInfo.clear();
		if (args != null) {
			photoSerializable = (PhotoSerializable) args
					.getSerializable("list");

            if(photoSerializable != null){
                photoAdapter = new PhotoAdapter(getActivity(),
                        photoSerializable.getList(), gridView);
                gridView.setAdapter(photoAdapter);
            }
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		return inflater
				.inflate(R.layout.fragment_photoselect, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		gridView = (GridView) getView().findViewById(R.id.gridview);
		loadingLay = (LinearLayout) getView().findViewById(R.id.loadingLay);
		list = new ArrayList<PhotoInfo>();

		cr = getActivity().getContentResolver();

		new ImageAsyncTask().executeOnExecutor(Executors.newCachedThreadPool());

		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {
			}
		});

		gridView.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				if (scrollState == 0) {
					ImageLoaderUtils.getInstance().resume();
				} else {
					ImageLoaderUtils.getInstance().pause();
				}
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
								 int visibleItemCount, int totalItemCount) {
			}
		});
	}

	private class ImageAsyncTask extends AsyncTask<Void, Void, Object> {

		@Override
		protected Object doInBackground(Void... params) {

			// 获取缩略图
			ThumbnailsUtil.clear();
			String[] projection = { Thumbnails._ID, Thumbnails.IMAGE_ID,
					Thumbnails.DATA };
			Cursor cur = cr.query(Thumbnails.EXTERNAL_CONTENT_URI, projection,
					null, null, null);

			if (cur != null && cur.moveToFirst()) {
				int image_id;
				String image_path;
				int image_idColumn = cur.getColumnIndex(Thumbnails.IMAGE_ID);
				int dataColumn = cur.getColumnIndex(Thumbnails.DATA);
				do {
					image_id = cur.getInt(image_idColumn);
					image_path = cur.getString(dataColumn);
					ThumbnailsUtil.put(image_id, "file://" + image_path);
				} while (cur.moveToNext());
			}

			// 获取原图
			Cursor cursor = cr.query(
					MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null,
					null, "date_modified DESC");

			String _path = "_data";
			String _album = "bucket_display_name";

			HashMap<String, AlbumInfo> myhash = new HashMap<String, AlbumInfo>();
			AlbumInfo albumInfo = null;
			PhotoInfo photoInfo = null;
			if (cursor != null && cursor.moveToFirst()) {
				do {
					int index = 0;
					int _id = cursor.getInt(cursor.getColumnIndex("_id"));
					String path = cursor
							.getString(cursor.getColumnIndex(_path));
					String album = cursor.getString(cursor
							.getColumnIndex(_album));
					List<PhotoInfo> stringList = new ArrayList<PhotoInfo>();
					photoInfo = new PhotoInfo();
					if (myhash.containsKey(album)) {
						albumInfo = myhash.remove(album);
						if (listImageInfo.contains(albumInfo))
							index = listImageInfo.indexOf(albumInfo);
						photoInfo.setImage_id(_id);
						photoInfo.setPath_file("file://" + path);
						photoInfo.setPath_absolute(path);
						albumInfo.getList().add(photoInfo);
						listImageInfo.set(index, albumInfo);
						myhash.put(album, albumInfo);
					} else {
						albumInfo = new AlbumInfo();
						stringList.clear();
						photoInfo.setImage_id(_id);
						photoInfo.setPath_file("file://" + path);
						photoInfo.setPath_absolute(path);
						stringList.add(photoInfo);
						albumInfo.setImage_id(_id);
						albumInfo.setPath_file("file://" + path);
						albumInfo.setPath_absolute(path);
						albumInfo.setName_album(album);
						albumInfo.setList(stringList);
						listImageInfo.add(albumInfo);
						myhash.put(album, albumInfo);
					}
				} while (cursor.moveToNext());
				// 将所有图片添加
				if (cursor.moveToFirst()) {
					int _id = cursor.getInt(cursor.getColumnIndex("_id"));
					String path = cursor
							.getString(cursor.getColumnIndex(_path));
					String album = cursor.getString(cursor
							.getColumnIndex(_album));
					List<PhotoInfo> stringList = new ArrayList<PhotoInfo>();
					photoInfo = new PhotoInfo();
					albumInfo = new AlbumInfo();
					stringList.clear();
					photoInfo.setImage_id(_id);
					photoInfo.setPath_file("file://" + path);
					photoInfo.setPath_absolute(path);
					stringList.add(photoInfo);
					albumInfo.setImage_id(_id);
					albumInfo.setPath_file("file://" + path);
					albumInfo.setPath_absolute(path);
					albumInfo.setName_album("所有图片");

					listFileAll = new ArrayList<PhotoInfo>();
					Iterator<AlbumInfo> i = listImageInfo.iterator();
					while (i.hasNext()) {
						listFileAll.addAll(i.next().getList());
					}

					albumInfo.setList(listFileAll);
					listImageInfo.add(0, albumInfo);

					// 本相册所有图片路径
					if (photoPath == null)
						photoPath = new ArrayList<String>();
					Iterator<PhotoInfo> it = albumInfo.getList().iterator();
					while (it.hasNext()) {
						photoPath.add(it.next().getPath_absolute());
					}
				}
			}
			return null;
		}

		@Override
		protected void onPostExecute(Object result) {
			super.onPostExecute(result);
			loadingLay.setVisibility(View.GONE);
			if (getActivity() != null) {
				if (listImageInfo.size() > 0)
					list.addAll(listImageInfo.get(0).getList());
				photoAdapter = new PhotoAdapter(getActivity(), list, gridView);
				gridView.setAdapter(photoAdapter);

				if (folderFragment != null) {
					folderFragment.setAdapter(new PhotoFolderAdapter(
							getActivity(), listImageInfo));
					folderFragment.setListImageInfo(listImageInfo);
				}
			}
		}
	}

	public void setPhotoFolderFragment(PhotoFolderFragment fragment) {
		this.folderFragment = fragment;
	}

	public void setAdapterList(PhotoSerializable list) {
		this.list = list.getList();
		if (photoPath == null)
			photoPath = new ArrayList<String>();
		photoPath.clear();
		Iterator<PhotoInfo> it = this.list.iterator();
		while (it.hasNext()) {
			photoPath.add(it.next().getPath_absolute());
		}
		photoAdapter = new PhotoAdapter(getActivity(), this.list, gridView);
		gridView.setAdapter(photoAdapter);
	}


	public void refreshSelect() {
		photoAdapter.refreshSelect();
	}
}
