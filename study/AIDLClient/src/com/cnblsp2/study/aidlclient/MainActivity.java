package com.cnblsp2.study.aidlclient;

import android.R.color;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.cnblsp2.studyt.aidlservice.ICat;

public class MainActivity extends Activity {

	private ICat catService;

	private Button getBtn = null;
	private EditText colorEt = null;
	private EditText weightEt = null;

	private ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// 获取远程Service的onBind方法返回的对象的代码
			catService = ICat.Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			catService = null;
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getBtn = (Button) this.findViewById(R.id.activity_client_get_btn);
		colorEt = (EditText) this.findViewById(R.id.activity_client_color_et);
		weightEt = (EditText) this.findViewById(R.id.activity_client_weight_et);

		// 创建所需绑定服务的Intent
		Intent intent = new Intent();
		intent.setAction("com.cnblsp2.studyt.aidlservice.AIDL_SERVICE");

		// 绑定远程服务
		bindService(intent, conn, Service.BIND_AUTO_CREATE);
		getBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				try {
					colorEt.setText(catService.getColor());
					weightEt.setText(catService.getWeight() + "");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		this.unbindService(conn);
	}

}
