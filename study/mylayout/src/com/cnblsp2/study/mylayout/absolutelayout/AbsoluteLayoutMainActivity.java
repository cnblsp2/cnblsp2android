package com.cnblsp2.study.mylayout.absolutelayout;

import com.cnblsp2.study.mylayout.R;
import com.cnblsp2.study.mylayout.framelayout.FrameLayoutMainActivity;
import com.cnblsp2.study.mylayout.framelayout.FrameLayoutNHDActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AbsoluteLayoutMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		this.setContentView(R.layout.activity_absolutelayout_main);

		// absolutelayoutactivity_example1_btn

		((Button) this.findViewById(R.id.absolutelayoutactivity_example1_btn)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AbsoluteLayoutMainActivity.this, AbsoluteLayoutLoginActivity.class);
				startActivity(intent);
			}
		});

	}

}
