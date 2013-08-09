package com.cnblsp2.study.androidservice;

import com.cnblsp2.study.androidservice.service.BindService;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Button;

public class BinsServiceActivity extends Activity {

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
			
			//获取Service的onBind方法所返回的MyBinder对象
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
		
		bindServiceBtn = (Button) this.findViewById(R.id.bindservice_activity_bindservice_btn);
		unBindServiceBtn = (Button) this.findViewById(R.id.bindservice_activity_unbindservice_btn);
		getServiceStatusBtn = (Button) this.findViewById(R.id.bindservice_activity_getservicestatus_btn);
		
		
	}

}
