package com.yinbro.tc.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by zhoux on 2016-05-16.
 */
public class ShortUrlUtil {

	public static void main(String[] args) {
		System.out.println(getShortUrl("http://www.baidu.com"));
	}

	public static String getShortUrl(String srcUrl) {
    	
    	String reqUrl = "{'type': 1, 'url': ['"+srcUrl+"']}";
        String short_url = null;
        
        StringBuffer result = new StringBuffer();
        try {
            URL url = new URL("http://apis.baidu.com/chazhao/shorturl/shorturl");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            con.setRequestProperty("apikey", "0c139d95715ac0485a4cf4f7724be785");
            con.setDoOutput(true);
            con.getOutputStream().write(reqUrl.getBytes("UTF-8"));
            con.connect();
            InputStream is = con.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                result.append(strRead);
                result.append("\r\n");
            }
            reader.close();
            String s = result.toString();
//            System.out.println(s);
            JSONObject object  = new JSONObject(s);
            JSONArray array = (JSONArray)((JSONObject)object.get("data")).get("urls");
//            for(Object o:array){
//                short_url = ((JSONObject) o).get("short_url").toString();
//            }
            short_url = ((JSONObject) array.get(0)).get("short_url").toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return short_url;
    }

}