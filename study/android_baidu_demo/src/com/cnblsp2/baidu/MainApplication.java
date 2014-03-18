package com.cnblsp2.baidu;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.map.MKEvent;

public class MainApplication extends Application {

	private static final String TAG_LOG = MainApplication.class.getName();

	private static MainApplication mInstance = null;
	protected BMapManager mBMapManager = null;
	public boolean m_bKeyRight = true;
	public static final String strKey = "mzLcHMU6KV344QSoznpkMzNj";

	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;
		initEnginManager(this);
	}

	public void initEnginManager(Context context) {
		if (mBMapManager == null) {
			mBMapManager = new BMapManager(context);
		}

		if (!mBMapManager.init(strKey, new MyGeneralListener())) {
			Toast.makeText(MainApplication.getInstance().getApplicationContext(),
					"BMapManager初始化错误!", Toast.LENGTH_LONG).show();
		}
	}

	public static MainApplication getInstance() {
		return mInstance;
	}

	static class MyGeneralListener implements MKGeneralListener {

		@Override
		public void onGetNetworkState(int iError) {
			Log.i(TAG_LOG, "onGetNetworkState() --------> 【"+iError+"】");
			if (iError == MKEvent.ERROR_NETWORK_CONNECT) {
				Toast.makeText(MainApplication.getInstance().getApplicationContext(), "您的网络出错啦！",
						Toast.LENGTH_LONG).show();
			} else if (iError == MKEvent.ERROR_NETWORK_DATA) {
				Toast.makeText(MainApplication.getInstance().getApplicationContext(), "输入正确的检索条件!",
						Toast.LENGTH_LONG).show();
			}
		}

		@Override
		public void onGetPermissionState(int iError) {
			Log.i(TAG_LOG, "onGetPermissionState() --------> 【"+iError+"】");
			if (iError != 0) {
				Toast.makeText(MainApplication.getInstance().getApplicationContext(),
						"请在MainApplication.java文件输入正确的授权KEY,并检查您的网络连接是否正常!二楼error : " + iError,
						Toast.LENGTH_LONG).show();
				MainApplication.getInstance().m_bKeyRight = false;
			} else {
				MainApplication.getInstance().m_bKeyRight = true;
				Toast.makeText(MainApplication.getInstance().getApplicationContext(), "KEY认证成功!",
						Toast.LENGTH_LONG).show();
			}

		}

	}

}
