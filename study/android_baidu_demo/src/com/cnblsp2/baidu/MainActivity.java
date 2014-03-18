package com.cnblsp2.baidu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.baidu.mapapi.VersionInfo;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView mListView = (ListView) this.findViewById(R.id.listView);
		mListView.setAdapter(new DemoListAdapter());
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int index, long arg3) {
				onListItemClick(index);
			}
		});
	}

	@Override
	protected void onResume() {
		MainApplication app = (MainApplication) this.getApplication();
		TextView textView = (TextView) findViewById(R.id.text_Info);
		if (!app.m_bKeyRight) {
			textView.setText(R.string.key_error);
			textView.setTextColor(Color.RED);
		} else {
			textView.setTextColor(Color.YELLOW);
			textView.setText("欢迎使用百度地图Android SDK v" + VersionInfo.getApiVersion());
		}

		super.onResume();
	}

	/**
	 *  建议在APP整体退出之前调用MapApi的destroy()函数，不要在每个activity的OnDestroy中调用，
	 	避免MapApi重复创建初始化，提高效率
	 */
	@Override
	protected void onDestroy() {
		MainApplication app = (MainApplication) getApplication();
		if (app.mBMapManager != null) {
			app.mBMapManager.destroy();
			app.mBMapManager = null;
		}
		super.onDestroy();
		System.exit(0);
	}

	void onListItemClick(int index) {
		Intent intent = null;
		intent = new Intent(MainActivity.this, demos[index].demoClass);
		MainActivity.this.startActivity(intent);
	}

	private static final DemoInfo[] demos = { new DemoInfo(R.string.activity_title_basemap,
			R.string.activity_desc_basemap, BaseMapActivity.class) };

	private class DemoListAdapter extends BaseAdapter {

		public DemoListAdapter() {
			super();
		}

		@Override
		public int getCount() {
			return demos.length;
		}

		@Override
		public Object getItem(int position) {
			return demos[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			convertView = View.inflate(MainActivity.this, R.layout.demo_info_item, null);
			TextView titleView = (TextView) convertView.findViewById(R.id.title);
			TextView descView = (TextView) convertView.findViewById(R.id.desc);

			titleView.setText(demos[position].title);
			descView.setText(demos[position].desc);
			return convertView;
		}
	}

	private static class DemoInfo {
		private final int title;
		private final int desc;
		private final Class<? extends android.app.Activity> demoClass;

		public DemoInfo(int title, int desc, Class<? extends android.app.Activity> demoClass) {
			this.title = title;
			this.desc = desc;
			this.demoClass = demoClass;
		}

	}

}
