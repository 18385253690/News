package com.zhilinghui.news.bean;

import java.util.ArrayList;

public class NewsListBean {
	//变量名跟json中一样
	public NewsList data;

	public static class NewsList{
		//变量名跟json中一样
		public ArrayList<NewsItem> news;
	}

	public static class NewsItem{
		public String title;
		public String url;
		public String listimage;
		public String pubdate;
	}
}