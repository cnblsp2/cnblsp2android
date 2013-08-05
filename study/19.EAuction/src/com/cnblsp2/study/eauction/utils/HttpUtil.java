package com.cnblsp2.study.eauction.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 提供Apache HttpClient与远程服务器通信。
 * <ul>
 * 		<li>getRequest : 发送GET请求</li>
 * 		<li>postRequest : 发送POST请求。</li>
 * </ul>
 * 
 * @author cpic
 *
 */
public class HttpUtil {

	public static HttpClient httpClient = new DefaultHttpClient();
	public static final String BASE_URL = "http://10.0.2.2:8080/eauction-web/";

	/**
	 * 
	 * @param url	发送请求的URL
	 * @return		服务器响应的字符串
	 */
	public static String getRequest(String url) throws Exception {
		// 创建HttpGet对象
		HttpGet get = new HttpGet(url);
		// 发送GET请求
		HttpResponse httpResponse = httpClient.execute(get);
		// 如果服务器成功地返回响应
		if (httpResponse.getStatusLine().getStatusCode() == 200) {
			// 获取服务器响应字符串
			String result = EntityUtils.toString(httpResponse.getEntity());
			return result;
		}
		return null;
	}

	/**
	 * 
	 * @param url			发送请求的URL
	 * @param rawParams		请求参数
	 * @return				服务器响应字符串
	 * @throws Exception
	 */
	public static String postRequest(String url, Map<String, String> rawParams) throws Exception {
		// 创建HttpPost对象
		HttpPost post = new HttpPost(url);
		// 如果传递参数个数比较多，可以对传递的参数进行封装
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for (String key : rawParams.keySet()) {
			// 封装请求参数
			params.add(new BasicNameValuePair(key, rawParams.get(key)));
		}
		// 设置请求参数
		post.setEntity(new UrlEncodedFormEntity(params, Constants.DEFAULT_ENCODING));
		// 发送POST请求
		HttpResponse httpResponse = httpClient.execute(post);
		// 如果服务器成功返回响应
		if (httpResponse.getStatusLine().getStatusCode() == 200) {
			// 获取服务器响应字符串
			String result = EntityUtils.toString(httpResponse.getEntity());
			return result;
		}
		return null;
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
 */

