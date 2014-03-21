package com.cnblsp2.ui.actionbar.fragment;


/**
 * 
 * @author linshaopeng
 *
 */
public class ChatFragment extends BaseAbstractFragment {

	public ChatFragment() {

	}

	public static ChatFragment newInstance(int layoutRes, int sectionNumber) {
		ChatFragment fragment = new ChatFragment();
		setInfo(fragment, layoutRes, sectionNumber);
		return fragment;
	}

}
