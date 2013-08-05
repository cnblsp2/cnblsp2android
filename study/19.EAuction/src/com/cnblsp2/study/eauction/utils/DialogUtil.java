package com.cnblsp2.study.eauction.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

public class DialogUtil {
	// 定义一个显示消息对话框
	public static void showDialog(final Context context, String msg, boolean closeSelf) {
		// 创建一个AlertDialog.Builder对象
		AlertDialog.Builder builder = new AlertDialog.Builder(context).setMessage(msg).setCancelable(false);

		if (closeSelf) {
			builder.setPositiveButton("确定", new OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// 结束当前Activity
					((Activity) context).finish();
				}
			});
		} else {
			builder.setPositiveButton("确定", null);
		}
		builder.create().show();
	}

	public static void showDialog(Context context, View view) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context).setView(view).setCancelable(false).setPositiveButton("确定", null);
		builder.create().show();
	}

}
