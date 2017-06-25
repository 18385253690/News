package com.zhilinghui.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.zhilinghui.news.R;
import com.zhilinghui.news.bean.News;

import java.util.List;

public class NewsListAdapter extends BaseAdapter {

	//定义变量
	private List<News> newsList;
	private LayoutInflater mInflater;	//获取外部布局用的
	private BitmapUtils mBitmapUtils;	//加载和显示图片用的

	public NewsListAdapter(Context context,List<News> newsList){
		this.newsList=newsList;
		this.mInflater=LayoutInflater.from(context);
		mBitmapUtils=new BitmapUtils(context);
	}

	//返回newsList的长度
	public int getCount() {
		return newsList.size();
	}

	//通过position返回每一项item
	public Object getItem(int position) {

		return newsList.get(position);
	}

	public long getItemId(int position) {

		return position;
	}

	//真正存放东西的方法
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder=null;
		if(convertView==null){//如果传进来的view为空，就进行创建，并填充内容
			holder=new ViewHolder();
			convertView=mInflater.inflate(R.layout.fragment_list_item, null);
			holder.newIcon=(ImageView) convertView.findViewById(R.id.newIcon);
			holder.newTime=(TextView) convertView.findViewById(R.id.newTime);
			holder.newTitle=(TextView) convertView.findViewById(R.id.newTitle);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}

		//将数据放到我们的控件当中
		News news=newsList.get(position);
		holder.newTitle.setText(news.getTitle());
		holder.newTime.setText(news.getPubdate());
		mBitmapUtils.display(holder.newIcon, news.getListimage());
		return convertView;
	}

	//模拟我们传递的控件
	class ViewHolder{
		ImageView newIcon;
		TextView newTitle;
		TextView newTime;
	}

	//把所有News加进List中
	public void addListItem(List<News> list){
		newsList.addAll(list);
	}
}
