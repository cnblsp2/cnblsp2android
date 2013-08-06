package com.cnblsp2.study.mylayout.linearlayout;

import com.cnblsp2.study.mylayout.MainActivity;
import com.cnblsp2.study.mylayout.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LinearLayoutMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_linearlayout_main);

		((Button) this.findViewById(R.id.linearlayoutactivity_example1_btn)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LinearLayoutMainActivity.this, LinearLayoutEx1Activity.class);
				startActivity(intent);
			}
		});

	}

}
