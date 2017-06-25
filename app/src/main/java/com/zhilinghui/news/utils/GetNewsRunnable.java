package com.zhilinghui.news.utils;


import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.zhilinghui.news.bean.News;
import com.zhilinghui.news.bean.NewsListBean;

public class GetNewsRunnable implements Runnable{

	private HttpUtils httpUtils;
	private Gson gson;
	private List<News> newsList;
	private News news;
	private String url;
	private NetUtils netUtils;

	public GetNewsRunnable(HttpUtils httpUtils,Gson gson,List<News> newsList,News news,String url){
		this.httpUtils=httpUtils;
		this.gson=gson;
		this.newsList=newsList;
		this.news=news;
		this.url=url;
		netUtils=new NetUtils();
	}

	//run方法中访问网络并解析json数据
	public void run() {
		if(newsList==null){
			newsList=new ArrayList<News>();
		}
		httpUtils=new HttpUtils();

		httpUtils.send(HttpMethod.GET, url, new RequestCallBack<String>() {

			public void onFailure(HttpException arg0, String arg1) {
				Log.e("failure", "访问失败");
			}

			public void onSuccess(ResponseInfo<String> responseInfo) {
				Log.e("success", "访问成功");
				//访问成功，就进行数据解析
				NewsListBean newsListBean=gson.fromJson(responseInfo.result, NewsListBean.class);
				//for-each循环
				for(NewsListBean.NewsItem newsItem:newsListBean.data.news){
					news=new News();
					news.setTitle(newsItem.title);
					news.setListimage(newsItem.listimage);
					news.setUrl(newsItem.url);
					news.setPubdate(newsItem.pubdate);
					newsList.add(news);
					netUtils.addAll(newsList);
				}
			}
		});
	}

}
