package com.cnblsp2.study.androidservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartAndStopServiceActivity extends Activity {

	private Button startServiceBtn;
	private Button stopServiceBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		this.setContentView(R.layout.activity_startandstopservice);

		startServiceBtn = (Button) this.findViewById(R.id.startandstopservice_activity_startservice_btn);
		stopServiceBtn = (Button) this.findViewById(R.id.startandstopservice_activity_stopservice_btn);

		// 创建启动Service的Intent
		final Intent intent = new Intent();

		intent.setAction("com.cnblsp2.study.AndroidService.FIRST_SERVICE");

		startServiceBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startService(intent);
			}
		});

		stopServiceBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stopService(intent);
			}
		});

	}
}
