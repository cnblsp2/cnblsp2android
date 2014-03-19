package com.cnblsp2.baidu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;

public class UISettingDemo extends Activity {

	private MapView mMapView = null;

	private MapController mMapController = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
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
		/**
		 * 由于MapView在setContentView()中初始化,所以它需要在BMapManager初始化之后
		 */
		setContentView(R.layout.activity_uisetting);

		mMapView = (MapView) this.findViewById(R.id.bmapView);
		mMapController = mMapView.getController();

		mMapController.enableClick(true);

		mMapController.setZoom(17);
		mMapController.setOverlooking(-30);

		mMapController.setCenter(MainApplication.newDefaultGeoPoint());

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		mMapView.onPause();
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub

		mMapView.onResume();
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub

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

	public void setBuiltInZoomControllEnable(View view) {
		boolean result = ((CheckBox) view).isChecked();
		mMapView.setBuiltInZoomControls(((CheckBox) view).isChecked());
		Toast.makeText(UISettingDemo.this, "setBuiltInZoomControllEnable:【" + result + "】",
				Toast.LENGTH_LONG).show();
	}

	public void setZoomEnable(View view) {
		boolean result = ((CheckBox) view).isChecked();
		mMapController.setZoomGesturesEnabled(result);
		Toast.makeText(UISettingDemo.this, "setZoomEnable:【" + result + "】", Toast.LENGTH_LONG)
				.show();
	}

	public void setScrollEnable(View view) {
		boolean result = ((CheckBox) view).isChecked();
		// mMapView.setscroll
		mMapController.setScrollGesturesEnabled(result);
		Toast.makeText(UISettingDemo.this, "setScrollEnable:【" + result + "】", Toast.LENGTH_LONG)
				.show();
	}

	public void setDoubleClickEnable(View view) {

		boolean result = ((CheckBox) view).isChecked();
		mMapView.setDoubleClickZooming(result);
		Toast.makeText(UISettingDemo.this, "setDoubleClickEnable:【" + result + "】",
				Toast.LENGTH_LONG).show();
	}

	public void setRotateEnable(View view) {
		boolean result = ((CheckBox) view).isChecked();
		mMapController.setRotationGesturesEnabled(result);
		Toast.makeText(UISettingDemo.this, "setRotateEnable:【" + result + "】", Toast.LENGTH_LONG)
				.show();
	}

	public void setOverlookEnable(View view) {
		boolean result = ((CheckBox) view).isChecked();
		mMapController.setOverlookingGesturesEnabled(result);
		Toast.makeText(UISettingDemo.this, "setOverlookEnable:【" + result + "】", Toast.LENGTH_LONG)
				.show();
	}

	public void setCompassLocation(View view) {
		boolean checked = ((RadioButton) view).isChecked();

		switch (view.getId()) {
		case R.id.lefttop:
			if (checked) {
				mMapController.setCompassMargin(100, 100);
			}
			break;
		case R.id.righttop:
			if (checked) {
				mMapController.setCompassMargin(mMapView.getWidth() - 100, 100);
			}
			break;
		}

	}

}
