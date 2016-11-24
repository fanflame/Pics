package com.ran.pics.activity.task;

import android.content.Context;

//import com.loopj.android.http.AsyncHttpClient;
//import com.loopj.android.http.JsonHttpResponseHandler;

public class GetTieTuKuPicsTask {
	private final String ONEPAGENUM = "30";
//	private JsonHttpResponseHandler jsonHandler;
//	private AsyncHttpClient client;
	private Context context;

//	public GetTieTuKuPicsTask(Context context,
//			JsonHttpResponseHandler jsonHandler) {
//		this.context = context;
//		this.jsonHandler = jsonHandler;
//		client = new AsyncHttpClient();
//	}

	/**
	 * 所有图片
	 */
	private void execute(String pageNum, String classifaction) {
//		String url = Constant.UrlInterface.URL_LISTPIC;
//		String json = TokenFactory.createAllPicsToken(Utils.getTokenTime(),
//				pageNum, classifaction);
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
//					public void onFailure(int statusCode, Header[] headers,
//							String responseBody, Throwable e) {
//						super.onFailure(statusCode, headers, responseBody, e);
//					}
//
//					@Override
//					public void onSuccess(int statusCode, JSONObject response) {
//						// TODO Auto-generated method stub
//						if (response.equals(Constant.ERROR_DENY)) {
//							ToastUtil.show(context, "网络不通哦亲！");
//							return;
//						}
//						if (response.toString().trim().equals("")) {
//							ToastUtil.show(context, "数据返回错误");
//							return;
//						}
//						ArrayList<Pic> picListTemp = JsonAnalyze.getAllPic(
//								response, context);
//						Utils.getPicThumbnail(picListTemp);
//						super.onSuccess(statusCode, response);
//					}
//				});
	}

	public void cancleTask() {
//		if (client != null)
//			client.cancelRequests(context, true);
	}
}
