package com.zhilinghui.news;

import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebView;

public class DescriptActivity extends Activity {


	private WebView newsDescription;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_descript);

		String url=this.getIntent().getExtras().get("url").toString();
		newsDescription=(WebView) findViewById(R.id.newsDescription);
		newsDescription.getSettings().setUseWideViewPort(true);
		newsDescription.getSettings().setLoadWithOverviewMode(true);
		newsDescription.setVerticalScrollBarEnabled(true);
		newsDescription.setHorizontalScrollBarEnabled(false);
		newsDescription.loadUrl(url);

	}
}
