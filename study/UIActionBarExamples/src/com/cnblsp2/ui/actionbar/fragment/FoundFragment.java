package com.cnblsp2.ui.actionbar.fragment;


public class FoundFragment extends BaseAbstractFragment {
	public static FoundFragment newInstance(int layoutRes, int sectionNumber) {
		FoundFragment fragment = new FoundFragment();
		setInfo(fragment, layoutRes, sectionNumber);
		return fragment;
	}

	
}
