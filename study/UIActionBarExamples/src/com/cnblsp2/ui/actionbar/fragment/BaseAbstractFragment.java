package com.cnblsp2.ui.actionbar.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseAbstractFragment extends Fragment {
	protected static final String ARG_SECTION_NUMBER = "section_number";

	public static void setInfo(BaseAbstractFragment fragment, int layoutRes, int sectionNumber) {
		fragment.setLayoutRes(layoutRes);
		Bundle bundle = new Bundle();
		bundle.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(bundle);
	}

	protected int layoutRes;

	public void setLayoutRes(int layoutRes) {
		this.layoutRes = layoutRes;
	}

	public int getLayoutRes() {
		return layoutRes;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(this.getLayoutRes(), container, false);
		return rootView;
	}

}
