package com.ran.pics.activity.task;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.ran.pics.util.Constant;

public class GetBaiduPicsTask {
	private final String ONEPAGENUM = "30";
	private JsonHttpResponseHandler jsonHandler;
	private AsyncHttpClient client;
	private Context context;
	
	public GetBaiduPicsTask(Context context,
			JsonHttpResponseHandler jsonHandler) {
		this.context = context;
		this.jsonHandler = jsonHandler;
		client = new AsyncHttpClient();
	}

	public void execute(String searchWord, int pageNum) {
		if (jsonHandler == null) {
			throw new NullPointerException();
		}
		String url = Constant.UrlInterface.URL_BAIDU;
		String post = url.replace("THESEARCHWORD", searchWord)
				.replace("ONEPAGENUM", ONEPAGENUM)
				.replace("PAGENUM", pageNum * 30 + "").replace("WIDTH","1080").replace("HEIGHT","1920");
		client.post(post, jsonHandler);
	}

	public void cancleTask() {
		if (client != null)
			client.cancelRequests(context, true);
	}
}
