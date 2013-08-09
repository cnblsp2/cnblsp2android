package com.cnblsp2.study.androidservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BindService extends Service {

	private int count;
	private boolean quit;

	private MyBinder binder = new MyBinder();

	public static final String FLAG = "Service -- ";

	public class MyBinder extends Binder {
		public int getCount() {
			return count;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.i(FLAG, "---- service is Binded; ");
		return binder;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();

		Log.i(FLAG, "Service is created.");

		// 启动一条线程，动态修改count状态值
		new Thread() {
			@Override
			public void run() {
				while (!quit) {
					try {
						Thread.sleep(1000);
						;
					} catch (Exception e) {
						e.printStackTrace();
					}
					count++;
				}
			}
		}.start();
	}

	@Override
	public boolean onUnbind(Intent intent) {

		Log.i(FLAG, "Service is unBinded!");
		return true;

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		this.quit = true;
		Log.i(FLAG, "Service is destroyed!");
	}

}
