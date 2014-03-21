package com.cnblsp2.inputcontrol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.cnblsp2.inputcontrol.adapter.ActivityItem;
import com.cnblsp2.inputcontrol.adapter.BaseActivityAdapter;

public class MainActivity extends Activity {

	private ActivityItem[] items = new ActivityItem[] {
			new ActivityItem("Button", "按钮示例...", R.drawable.button, ButtonsActivity.class),
			new ActivityItem("TextField", "Text field examples", R.drawable.textfield,
					TextFieldActivity.class),
			new ActivityItem("Spinner", "Spinner examples", R.drawable.text_dropcaps,
					SpinnersActivity.class) };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView listView = (ListView) this.findViewById(R.id.listView);

		final BaseActivityAdapter baseActivityAdapter = new BaseActivityAdapter(MainActivity.this,
				items);

		listView.setAdapter(baseActivityAdapter);

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				ActivityItem activityItem = (ActivityItem) baseActivityAdapter.getItem(position);
				Intent intent = new Intent(MainActivity.this, activityItem.getClazz());
				startActivity(intent);
			}
		});

	}
}
