package com.cnblsp2.ui.actionbar.fragment;

public class AddressListFragment extends BaseAbstractFragment {

	public static AddressListFragment newInstance(int layoutRes, int sectionNumber) {
		AddressListFragment fragment = new AddressListFragment();
		setInfo(fragment, layoutRes, sectionNumber);
		return fragment;
	}

}
