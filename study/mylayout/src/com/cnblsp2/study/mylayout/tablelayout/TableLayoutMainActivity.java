package com.cnblsp2.study.mylayout.tablelayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.cnblsp2.study.mylayout.R;

public class TableLayoutMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_tablelayout_main);

		((Button) this.findViewById(R.id.tablelayoutactivity_example1_btn)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(TableLayoutMainActivity.this, TableLayoutEx1Activity.class);
				startActivity(intent);
			}
		});

	}

}
