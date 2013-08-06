package com.cnblsp2.study.mylayout.relativelayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.cnblsp2.study.mylayout.R;

public class RelativeLayoutMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		this.setContentView(R.layout.activity_relativelayout_main);

		((Button) this.findViewById(R.id.relativelayoutactivity_example1_btn)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(RelativeLayoutMainActivity.this, RelativeLayoutMeihuaActivity.class);
				startActivity(intent);
			}
		});

	}

}
