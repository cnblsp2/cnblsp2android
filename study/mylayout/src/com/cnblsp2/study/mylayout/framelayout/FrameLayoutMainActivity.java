package com.cnblsp2.study.mylayout.framelayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.cnblsp2.study.mylayout.R;

public class FrameLayoutMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_framelayout_main);

		((Button) this.findViewById(R.id.framelayoutactivity_example1_btn)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FrameLayoutMainActivity.this, FrameLayoutEx1Activity.class);
				startActivity(intent);
			}
		});

		((Button) this.findViewById(R.id.framelayoutactivity_nhd_btn)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FrameLayoutMainActivity.this, FrameLayoutNHDActivity.class);
				startActivity(intent);
			}
		});
	}

}
