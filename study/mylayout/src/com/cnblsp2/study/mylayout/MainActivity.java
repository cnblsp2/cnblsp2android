package com.cnblsp2.study.mylayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.cnblsp2.study.mylayout.linearlayout.LinearLayoutMainActivity;
import com.cnblsp2.study.mylayout.tablelayout.TableLayoutMainActivity;

public class MainActivity extends Activity {

	private Button linearLayoutBtn = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		((Button) this.findViewById(R.id.mainactivity_mainlinearlayout_button)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, LinearLayoutMainActivity.class);
				startActivity(intent);
			}
		});

		((Button) this.findViewById(R.id.mainactivity_maintablelayout_button)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, TableLayoutMainActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
