package com.cnblsp2.ui.actionbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseActivityAdapter extends BaseAdapter {

	private Context context;

	private ActivityItem[] items;

	public BaseActivityAdapter(Context context, ActivityItem[] items) {
		this.context = context;
		this.items = items;
	}

	@Override
	public int getCount() {
		return items.length;
	}

	@Override
	public Object getItem(int position) {
		return items[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = View.inflate(context, R.layout.base_activity_listitem, null);
		TextView titleView = (TextView) convertView.findViewById(R.id.listItemTitle);
		TextView descriView = (TextView) convertView.findViewById(R.id.ListItemDescri);
		titleView.setText(items[position].getTitle());
		descriView.setText(items[position].getDescri());

		ImageView imageView = (ImageView) convertView.findViewById(R.id.listItemImage);
		imageView.setImageResource(items[position].getImageRes());

		return convertView;
	}

}
