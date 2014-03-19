package com.cnblsp2.baidu;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.SupportMapFragment;
import com.baidu.platform.comapi.basestruct.GeoPoint;

public class MapFragmentDemo extends FragmentActivity {
	private static final String LTAG = MapFragmentDemo.class.getSimpleName();

	SupportMapFragment map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		/**
		 * 使用地图SDK前需要先初始化BMapManager，
		 * BMapManager是全局的，可为多个MapView共用，它需要地图模块创建前创建；
		 * 并在地图模块销毁后销毁，只要还有地图模块在使用，BMapManager就不应该销毁。
		 */
		MainApplication app = (MainApplication) this.getApplication();
		if (app.mBMapManager == null) {
			app.mBMapManager = new BMapManager(getApplicationContext());
			/**
			 * 如果BMapManager没有初始化则初始化BMapManager
			 */
			app.mBMapManager.init(MainApplication.strKey, new MainApplication.MyGeneralListener());
		}
		Log.d(LTAG, "onCreate() ...... ");
		setContentView(R.layout.activity_fragment);
		map = SupportMapFragment.newInstance();
		FragmentManager manager = getSupportFragmentManager();
		manager.beginTransaction().add(R.id.map, map, "map_fragment").commit();
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);

		Log.d(LTAG, "onRestoreInstanceState() ....... ");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();

		Log.d(LTAG, "onRestart() ....... ");

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		Log.d(LTAG, "onStart() ....... ");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		Log.d(LTAG, "onResume() ....... ");

		MapController controller = map.getMapView().getController();
		controller.setCenter(MainApplication.newDefaultGeoPoint());
		controller.setZoom(17);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.d(LTAG, "onSaveInstanceState() ....... ");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		Log.d(LTAG, "onPause() ....... ");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d(LTAG, "onStop() ....... ");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(LTAG, "onDestroy() ....... ");
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		Log.d(LTAG, "onConfigurationChanged() ....... ");
	}

}
