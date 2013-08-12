package com.cnblsp2.study.androidservice;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.cnblsp2.study.androidservice.service.BindService;

public class BindServiceActivity extends Activity {

	private Button bindServiceBtn;
	private Button unBindServiceBtn;
	private Button getServiceStatusBtn;

	private BindService.MyBinder binder;

	public static final String TAG = "BinsServiceActivity:";

	private ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.i(TAG, "-------- service disconnected!");
		}

		/**
		 * 当该Activity与Service连接成功时回调该方法
		 */
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.i(TAG, " -------- service connected ------- ");
			// 获取Service的onBind方法所返回的MyBinder对象
			binder = (BindService.MyBinder) service;
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		this.setContentView(R.layout.activity_bindservice);

		bindServiceBtn = (Button) this.findViewById(R.id.bindservice_activity_bindservice_btn);
		unBindServiceBtn = (Button) this.findViewById(R.id.bindservice_activity_unbindservice_btn);
		getServiceStatusBtn = (Button) this.findViewById(R.id.bindservice_activity_getservicestatus_btn);

		// 启动Service的Intent
		final Intent intent = new Intent();
		intent.setAction("com.cnblsp2.study.androidservice.service.BIND_SERVICE");

		bindServiceBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bindService(intent, conn, Service.BIND_AUTO_CREATE);
			}
		});

		unBindServiceBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				unbindService(conn);
			}
		});

		getServiceStatusBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(BindServiceActivity.this, "service count is :" + binder.getCount(), Toast.LENGTH_SHORT).show();
			}
		});

	}
}
