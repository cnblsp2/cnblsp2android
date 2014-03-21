package com.cnblsp2.ui.actionbar;

import android.app.Activity;

public class ActivityItem {

	private String title;
	private String descri;
	private int imageRes;
	private Class<? extends Activity> clazz;

	public ActivityItem(String title, String descri, int imageRes, Class<? extends Activity> clazz) {
		this.title = title;
		this.descri = descri;
		this.imageRes = imageRes;
		this.clazz = clazz;
	}

	public String getTitle() {
		return title;
	}

	public String getDescri() {
		return descri;
	}

	public int getImageRes() {
		return imageRes;
	}

	public Class<? extends Activity> getClazz() {
		return clazz;
	}

}
