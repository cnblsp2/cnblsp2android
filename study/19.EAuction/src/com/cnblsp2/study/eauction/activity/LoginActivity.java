package com.cnblsp2.study.eauction.activity;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cnblsp2.study.eauction.MainActivity;
import com.cnblsp2.study.eauction.R;
import com.cnblsp2.study.eauction.utils.DialogUtil;
import com.cnblsp2.study.eauction.utils.HttpUtil;

public class LoginActivity extends Activity {

	private EditText usernameEt = null;
	private EditText passwordEt = null;
	private Button loginBtn = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_login);

		/**
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}*/

		initView();
		loginBtn.setOnClickListener(loginClickListener);
	}

	private void initView() {
		usernameEt = (EditText) this.findViewById(R.id.activity_login_usernameEditText);
		passwordEt = (EditText) this.findViewById(R.id.activity_login_passwordEditText);
		loginBtn = (Button) this.findViewById(R.id.activity_login_loginBtn);
	}

	private OnClickListener loginClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (validate()) {
				// 如果登录成功
				Toast.makeText(LoginActivity.this, "登录中......", Toast.LENGTH_SHORT).show();
				new LoginActionThread().start();
			}
		}
	};

	private boolean validate() {
		String username = usernameEt.getText().toString();
		if (username == null || "".equals(username)) {
			DialogUtil.showDialog(LoginActivity.this, "请输入用户名!", false);
			usernameEt.requestFocus();
			return false;
		}
		String password = passwordEt.getText().toString();
		if (password == null || "".equals(password)) {
			DialogUtil.showDialog(LoginActivity.this, "请输入密码!", false);
			passwordEt.requestFocus();
			return false;
		}
		return true;
	}

	private class LoginActionThread extends Thread {
		public void run() {
			boolean loginResult = false;
			Exception exception = null;
			try {
				loginResult = loginPro();
			} catch (Exception e) {
				exception = e;
			}
			Message message = new Message();
			Bundle msgData = new Bundle();
			msgData.putBoolean("loginResult", loginResult);
			msgData.putSerializable("exception", exception);
			message.setData(msgData);
			loginSuccessHandle.sendMessage(message);
		};
	};

	private Handler loginSuccessHandle = new Handler() {
		public void handleMessage(android.os.Message msg) {
			super.handleMessage(msg);
			Bundle msgData = msg.getData();

			if (msgData.containsKey("exception")) {
				Exception exception = (Exception) msgData.getSerializable("exception");
				DialogUtil.showDialog(LoginActivity.this, exception.getMessage(), false);
				return;
			}

			if (msgData.getBoolean("loginResult")) {
				Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			} else {
				DialogUtil.showDialog(LoginActivity.this, "用户名或者密码错误。", false);
			}

		};
	};

	private boolean loginPro() throws RuntimeException {
		String username = usernameEt.getText().toString();
		String password = passwordEt.getText().toString();
		JSONObject jsonObject;
		try {
			jsonObject = query(username, password);
			if (jsonObject.getInt("userId") > 0) {
				return true;
			}
		} catch (Exception e) {
			// DialogUtil.showDialog(LoginActivity.this, "服务器响应异常。", false);
			throw new RuntimeException("服务器响应异常...", e);
		}
		return false;
	}

	private JSONObject query(String username, String password) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);
		// 定义发送的请求的URL
		String url = HttpUtil.BASE_URL + "login";
		// 发送请求
		return new JSONObject(HttpUtil.postRequest(url, map));
	}

}

/**
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
