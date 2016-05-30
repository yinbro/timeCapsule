package com.yinbro.tc.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.imageio.stream.FileCacheImageOutputStream;
import javax.imageio.stream.FileImageInputStream;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class QiniuUtil {
	String ACCESS_KEY = "MQR1PkzdTyiZr--qxUNpv8tqDuWjoS6fXVYrbbCV";
	String SECRET_KEY = "gp2B2bNFk1dznamQHuNrCUU6__DX3CvTcQCjPzV8";
	String bucket = "yinbro";
	static String domainBase = "http://7xn0yn.com1.z0.glb.clouddn.com";

	Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	UploadManager uploadManager = new UploadManager();

	/**
	 * 
	 * @param file
	 * @param reName
	 * @return
	 */
	public void upload(File file, String reName) {
		Response res = null;
		try {
			// 调用put方法上传
			res = uploadManager.put(file, reName, auth.uploadToken(bucket));
			// 打印返回的信息
			// System.out.println(reName + " 文件上传成功：" + res.bodyString());
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			System.out.println(" 文件上传失败：" + r.toString());
		}
	}

	public void uploadByUrl(URL url, String reName) throws IOException {
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.connect();
		InputStream in = con.getInputStream();
		byte[] bytes = inputstream2ByteArray(in);
		Response res = uploadManager.put(bytes, reName, auth.uploadToken(bucket));
	}

	public static String getDownloadUrl(String key) {
		return domainBase + "/" + key;

	}

	private static byte[] inputstream2ByteArray(InputStream in) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024 * 4];
		int n = 0;
		while ((n = in.read(buffer)) != -1) {
			out.write(buffer, 0, n);
		}
		return out.toByteArray();
	}

	public static void main(String args[]) {
		try {
			new QiniuUtil().uploadByUrl(new URL("http://img16.3lian.com/gif2016/q10/60/d/42.jpg"), "gasgsgsgl");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
