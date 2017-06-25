package com.zhilinghui.news.utils;

	import java.util.ArrayList;
	import java.util.List;

	import com.google.gson.Gson;
	import com.zhilinghui.news.bean.News;
	import com.lidroid.xutils.HttpUtils;

public class NetUtils {
		//定义我们需要的变量
		private HttpUtils httpUtils;
		//全局变量
		private Gson gson=new Gson();
		private List<News> newsList=new ArrayList<News>();

		private News news;

		//获取新闻信息
		public List<News> getNews(String url){
			//访问网络是一个耗时操作，建议开启新线程
			GetNewsRunnable getNewsRunnable=new GetNewsRunnable(httpUtils, gson, newsList, news, url);
			getNewsRunnable.run();
			return newsList;
		}

		public void addAll(List<News> newsList){
			this.newsList.addAll(newsList);
		}
	}
