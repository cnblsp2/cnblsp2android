package com.cnblsp2.study.androidservice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		((Button) this.findViewById(R.id.mainactivity_startandstopservice_btn)).setOnClickListener(new NewActivityClickListener(this,
				StartAndStopServiceActivity.class));

		return true;
	}

	class NewActivityClickListener implements OnClickListener {

		private Context context;
		private Class clazz;

		public NewActivityClickListener(Context context, Class newIntentClazz) {
			this.context = context;
			this.clazz = newIntentClazz;
		}

		@Override
		public void onClick(View v) {

			Intent intent = new Intent(context, clazz);
			startActivity(intent);

		}
	}

}
