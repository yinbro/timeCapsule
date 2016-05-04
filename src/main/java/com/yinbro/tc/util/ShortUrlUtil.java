package com.yinbro.tc.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;




public class ShortUrlUtil {

	public static void main(String[] args) {
		String httpUrl = "http://apis.baidu.com/chazhao/shorturl/shorturl";
		String strUrl = "http://www.baidu.com";
		StringBuffer sbParam = new StringBuffer();
		sbParam.append("{ \"type\": 1, ");
		sbParam.append("\"url\": [ \"");
		sbParam.append(strUrl);
		sbParam.append("\"]}");

//		System.out.println();

		String jsonResult = request(httpUrl, sbParam.toString());
		System.out.println(jsonResult);

		
		
//		JSONObject obj = new JSONObject(jsonResult);
//		JSONObject o = obj.getJSONObject("data");
//		System.out.println(o.getJSONObject("type"));
//		System.out.println(o.getJSONArray("urls").get(0));
	}

	/**
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果
	 */
	public static String request(String httpUrl, String httpArg) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();

		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
			// 填入apikey到HTTP header
			connection.setRequestProperty("apikey", "0c139d95715ac0485a4cf4f7724be785");
			connection.setDoOutput(true);
			connection.getOutputStream().write(httpArg.getBytes("UTF-8"));
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
