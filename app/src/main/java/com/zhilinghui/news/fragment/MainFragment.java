package com.zhilinghui.news.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.zhilinghui.news.DescriptActivity;
import com.zhilinghui.news.R;
import com.zhilinghui.news.adapter.NewsListAdapter;
import com.zhilinghui.news.bean.News;
import com.zhilinghui.news.utils.NetUtils;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class MainFragment extends Fragment {
	private int newsType;	//新闻的标签类型
	private ListView newsList;
	private NewsListAdapter newsListAdapter;
	private NetUtils netUtils;
	private List<News> newsDatas=new ArrayList<News>();
	public MainFragment(int newsType){
		this.newsType=newsType;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		View view=inflater.inflate(R.layout.fragment_list, null);
		newsList=(ListView) view.findViewById(R.id.newsList);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if(netUtils==null){
			netUtils=new NetUtils();
		}

		switch(newsType){
			case 0:
				getNews("http://zhbj.qianlong.com/static/api/news/10006/list_1.json");
				break;
			case 1:
				getNews("http://zhbj.qianlong.com/static/api/news/10008/list_1.json");
				break;
			case 2:
				getNews("http://zhbj.qianlong.com/static/api/news/10014/list_1.json");
				break;
			case 3:
				getNews("http://zhbj.qianlong.com/static/api/news/10010/list_1.json");
			case 4:
				getNews("http://zhbj.qianlong.com/static/api/news/10091/list_1.json");
				break;
			case 5:
				getNews("http://zhbj.qianlong.com/static/api/news/10012/list_1.json");
				break;
			case 6:
				getNews("http://zhbj.qianlong.com/static/api/news/10095/list_1.json");
				break;
			case 7:
				getNews("http://zhbj.qianlong.com/static/api/news/10192/list_1.json");
				break;
		}
		newsListAdapter=new NewsListAdapter(getActivity(), newsDatas);
		newsList.setAdapter(newsListAdapter);
		//更新一下适配器
		newsListAdapter.notifyDataSetChanged();
		//这里是ListView的滚动和点击事件
		newsList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
									long arg3) {

				//获取新闻详细信息的地址
				String descriptionUrl=newsDatas.get(position).getUrl();
				//定义并实例化Intent
				Intent intent=new Intent(getActivity().getApplicationContext(),DescriptActivity.class);
				String name="url";
				//将值放到intent当中
				intent.putExtra(name, descriptionUrl);
				//开启Activity
				startActivity(intent);
			}
		});
	}

	public void getNews(String url){
		newsDatas=netUtils.getNews(url);
	}
}
