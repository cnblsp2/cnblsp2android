package com.cnblsp2.study.mylayout.framelayout;

import java.util.Timer;
import java.util.TimerTask;

import com.cnblsp2.study.mylayout.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

/**
 * 霓虹灯效果
 * @author cpic
 *
 */
public class FrameLayoutNHDActivity extends Activity {

	private int currentColor = 0;

	final int[] colors = new int[] { R.color.color7, R.color.color6, R.color.color5, R.color.color4, R.color.color3, R.color.color2, R.color.color1 };

	final int[] viewNames = new int[] {

	R.id.activity_framelayout_ex1_View01, R.id.activity_framelayout_ex1_View02, R.id.activity_framelayout_ex1_View03,
			R.id.activity_framelayout_ex1_View04, R.id.activity_framelayout_ex1_View05, R.id.activity_framelayout_ex1_View06,
			R.id.activity_framelayout_ex1_View07, };

	TextView[] views = new TextView[7];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_framelayout_ex1);
		for (int i = 0; i < 7; i++) {
			views[i] = (TextView) findViewById(viewNames[i]);
		}

		final Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (msg.what == 0x1122) {
					// 依次改变7个TextView的背景色
					for (int i = 0; i < 7 - currentColor; i++) {
						views[i].setBackgroundResource(colors[i + currentColor]);
					}
					for (int i = 7 - currentColor, j = 0; i < 7; i++, j++) {
						views[i].setBackgroundResource(colors[j]);
					}
				}
				super.handleMessage(msg);
			}
		};

		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {

				currentColor++;
				if (currentColor >= 6) {
					currentColor = 0;
				}

				Message message = new Message();
				message.what = 0x1122;
				handler.sendMessage(message);

			}
		}, 0, 100);

	}
}
