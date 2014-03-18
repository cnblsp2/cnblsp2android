package com.cnblsp2.baidu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.MKMapViewListener;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapView;
import com.baidu.platform.comapi.basestruct.GeoPoint;

public class BaseMapActivity extends Activity {

	private static final String TAG_LOG = MainActivity.class.getSimpleName();

	/**
	 * MapView是地图主控件
	 */
	private MapView mMapView = null;

	/**
	 * 用MapController完成地图控制
	 */
	private MapController mMapController = null;

	/**
	 * MKMapViewListener用于处理地图事件架设
	 */
	MKMapViewListener mMapListener = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/**
		 * 使用地图sdk前需先初始化BMapManager.
		 * BMapManager是全局的，可为多个MapView共用，它需要地图模块创建前创建，
		 * 并在地图地图模块销毁后销毁，只要还有地图模块在使用，BMapManager就不应该销毁
		 */
		MainApplication app = (MainApplication) this.getApplication();
		if (app.mBMapManager == null) {
			app.mBMapManager = new BMapManager(getApplicationContext());
			/**
			 * 如果BMapManager没有初始化则初始化BMapManager
			 */
			app.mBMapManager.init(MainApplication.strKey, new MainApplication.MyGeneralListener());
		}

		setContentView(R.layout.activity_basemap);

		mMapView = (MapView) findViewById(R.id.bmapView);

		mMapController = mMapView.getController();

		mMapController.enableClick(true);

		mMapController.setZoom(17);
		// 113.341139,23.147467
		GeoPoint geoPoint;
		double cLat = 23.147467;
		double cLon = 113.341139;
		Intent intent = getIntent();
		if (intent.hasExtra("x") && intent.hasExtra("y")) {
			Bundle b = intent.getExtras();
			geoPoint = new GeoPoint(b.getInt("x"), b.getInt("y"));
		} else {
			geoPoint = new GeoPoint((int) (cLat * 1E6), (int) (cLon * 1E6));
		}

		mMapController.setCenter(geoPoint);

		/**
		 * MapVIew的生命周期与Activity同步，当Activity扶起时需要调用MapView.OnPause（）
		 */
		mMapListener = new MKMapViewListener() {

			@Override
			public void onMapMoveFinish() {
				/**
				 * 在此处理地图移动完成回调
				 * 缩放，平移等操作完成后，此回调被触发
				 */
			}

			/**
			 * 在此处理地图载入完成事件
			 */
			@Override
			public void onMapLoadFinish() {
				Toast.makeText(BaseMapActivity.this, "地图加载完成【"+mMapView.getZoomLevel()+"】", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onMapAnimationFinish() {
				/**
				 *  地图完成带动画的操作（如: animationTo()）后，此回调被触发
				 */
				Toast.makeText(BaseMapActivity.this, "绘制地图完成【"+mMapView.getZoomLevel()+"】", Toast.LENGTH_LONG).show();
			}

			@Override
			public void onGetCurrentMap(Bitmap arg0) {
				/**
				 *  当调用过 mMapView.getCurrentMap()后，此回调会被触发
				 *  可在此保存截图至存储设备
				 */
			}

			@Override
			public void onClickMapPoi(MapPoi mapPoi) {
				/**
				 * 在此处理底图poi点击事件
				 * 显示底图poi名称并移动至该点
				 * 设置过： mMapController.enableClick(true); 时，此回调才能被触发
				 * 
				 */

				String title = "";
				if (mapPoi != null) {
					title = mapPoi.strText;
					Toast.makeText(BaseMapActivity.this, title, Toast.LENGTH_LONG).show();
					mMapController.animateTo(mapPoi.geoPt);
				}

			}
		};
		mMapView.regMapViewListener(MainApplication.getInstance().mBMapManager, mMapListener);
	}

	@Override
	protected void onPause() {
		/**
		 * MapView的生命周期与Activity同步，当Activity挂起时需要调用MapView.onPause()
		 */
		mMapView.onPause();
		super.onPause();
	}

	@Override
	protected void onResume() {
		mMapView.onResume();
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		mMapView.destroy();
		super.onDestroy();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		mMapView.onSaveInstanceState(outState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		mMapView.onRestoreInstanceState(savedInstanceState);
	}

}
