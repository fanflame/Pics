package com.ran.pics.activity.task;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

public class GetTieTuKeClassifiTask {
	private JsonHttpResponseHandler jsonHandler;
	private AsyncHttpClient client;
	private Context context;

	public GetTieTuKeClassifiTask(Context context,
                                  JsonHttpResponseHandler jsonHandler) {
		this.context = context;
		this.jsonHandler = jsonHandler;
		client = new AsyncHttpClient();
	}

	public void execute() {
//		if (jsonHandler == null) {
//			throw new NullPointerException();
//		}
//		String json = TokenFactory.createAlbumToken(Utils.getTokenTime(),null);
//		MultipartEntity reqEntity = MultipartEntityBuilder.create(); // 关键
//        try {
//            reqEntity.addPart("Token", new StringBody(json));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        client.post(context, Constant.UrlInterface.URL_ALBUM, reqEntity.build(), null,
//                jsonHandler);
	}

	public void cancleTask() {
		if (client != null)
			client.cancelRequests(context, true);
	}
}
