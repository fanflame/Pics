package com.ran.pics.util;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class NetWork {
	public static void getSplashBmpUrl(final ImageView imageView,
			final AppCompatActivity context) {
//		File file = new File(Environment.getExternalStorageDirectory()
//				+ Constant.Config.SPLASH_BMP_PATH);
//		File[] fileArray;
//		if (file.exists() && (fileArray = file.listFiles()).length != 0) {
//			Bitmap bm;
//			try {
//				bm = BitmapFactory.decodeStream(new FileInputStream(
//						fileArray[0].getAbsoluteFile()));
//				imageView.setImageBitmap(bm);
//				context.findViewById(R.id.pullDoorViewContainer)
//						.setBackgroundColor(Color.parseColor("#00ffffff"));
//			} catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//		String url = Constant.UrlInterface.URL_LISTPIC;
//		AsyncHttpClient client = new AsyncHttpClient();
//
//		String json = TokenFactory.createAlbumPicsToken(Utils.getTokenTime(),
//                Constant.BMP_SPLASH_ALBUM_ID, "0");
//		MultipartEntity reqEntity = new MultipartEntity(); // 关键
//		try {
//			reqEntity.addPart("Token", new StringBody(json));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		client.post(context, url, reqEntity, null,
//				new JsonHttpResponseHandler() {
//
//					@Override
//					public void onSuccess(int statusCode, JSONObject response) {
//						System.out.println("fq sssssss:" + response);
//						try {
//							if (response.toString().equals(Constant.NULLLIST)
//									|| response.getString("code").equals("404")) {
//								return;
//							}
//						} catch (JSONException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						// 下载splash图片
//						final ArrayList<Pic> pic = JsonAnalyze.getAlbumPic(
//                                response, context);
//						if (pic.size() == 0)
//							return;
//						if (Utils.isNewSplashPic(Constant.Config.SPLASH_BMP_PATH,pic.get(0).getName())) {// 判断是否是新的splash图片
//							return;
//						}
//						ImageLoader.newInstance().displayImage(
//								pic.get(0).getLinkUrl(), imageView,
//								Utils.getImageLoaderOptions(),
//								new SimpleImageLoadingListener() {
//									@Override
//									public void onLoadingComplete(
//											String imageUri, View view,
//											Bitmap loadedImage) {
//										super.onLoadingComplete(imageUri, view,
//												loadedImage);
//										imageView.setImageBitmap(loadedImage);
////										Animation animation = AnimationUtils
////												.loadAnimation(context,
////														R.anim.fade_in);
////										imageView.startAnimation(animation);
//										context.findViewById(
//												R.id.pullDoorViewContainer)
//												.setBackgroundColor(
//														Color.parseColor("#00ffffff"));
//										Utils.deleteSplashBmp(Constant.Config.SPLASH_BMP_PATH);
//										Utils.saveBitmap(Constant.Config.SPLASH_BMP_PATH,loadedImage, pic
//												.get(0).getName());
//									}
//								});
//						super.onSuccess(statusCode, response);
//					}
//				});
	}

	public static void getHomeBmpUrl(final ImageView imageView,
			final AppCompatActivity context) {
//		File file = new File(Environment.getExternalStorageDirectory()
//				+ Constant.Config.HOME_BMP_PATH);
//		File[] fileArray;
//		if (file.exists() && (fileArray = file.listFiles()).length != 0) {
//			Bitmap bm;
//			try {
//				bm = BitmapFactory.decodeStream(new FileInputStream(
//						fileArray[0].getAbsoluteFile()));
//				imageView.setImageBitmap(bm);
//			} catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//		String url = Constant.UrlInterface.URL_LISTPIC;
//		AsyncHttpClient client = new AsyncHttpClient();
//
//		String json = TokenFactory.createAlbumPicsToken(Utils.getTokenTime(),
//				Constant.BMP_HOME_ALBUM_ID, "0");
//		MultipartEntity reqEntity = new MultipartEntity(); // 关键
//		try {
//			reqEntity.addPart("Token", new StringBody(json));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		client.post(context, url, reqEntity, null,
//				new JsonHttpResponseHandler() {
//
//					@Override
//					public void onSuccess(int statusCode, JSONObject response) {
//						System.out.println("fq sssssss:" + response);
//						try {
//							if (response.toString().equals(Constant.NULLLIST)
//									|| response.getString("code").equals("404")) {
//								return;
//							}
//						} catch (JSONException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						// 下载splash图片
//						final ArrayList<Pic> pic = JsonAnalyze.getAlbumPic(
//								response, context);
//						if (pic.size() == 0)
//							return;
//						if (Utils.isNewSplashPic(Constant.Config.HOME_BMP_PATH,pic.get(0).getName())) {// 判断是否是新的splash图片
//							return;
//						}
//						ImageLoader.newInstance().displayImage(
//								pic.get(0).getLinkUrl(), imageView,
//								Utils.getImageLoaderOptions(),
//								new SimpleImageLoadingListener() {
//									@Override
//									public void onLoadingComplete(
//											String imageUri, View view,
//											Bitmap loadedImage) {
//										super.onLoadingComplete(imageUri, view,
//												loadedImage);
//										imageView.setImageBitmap(loadedImage);
//										Animation animation = AnimationUtils
//												.loadAnimation(context,
//														R.anim.fade_in);
//										imageView.startAnimation(animation);
//										Utils.deleteSplashBmp(Constant.Config.HOME_BMP_PATH);
//										Utils.saveBitmap(Constant.Config.HOME_BMP_PATH,loadedImage, pic
//												.get(0).getName());
//									}
//								});
//						super.onSuccess(statusCode, response);
//					}
//				});
	}
}
