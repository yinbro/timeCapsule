package com.yinbro.tc.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class QiniuUtil {
	String ACCESS_KEY = "MQR1PkzdTyiZr--qxUNpv8tqDuWjoS6fXVYrbbCV";
	String SECRET_KEY = "gp2B2bNFk1dznamQHuNrCUU6__DX3CvTcQCjPzV8";
	String bucket = "yinbro";
	String domainBase = "http://7xn0yn.com1.z0.glb.clouddn.com";
	
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
			System.out.println(reName + " 文件上传成功：" + res.bodyString());
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			System.out.println(" 文件上传失败：" + r.toString());
		}
	}


	public String getDownloadUrl(String key) {
		return domainBase + "/"+ key;

	}
	
	

	public static void main(String args[]) {
		new QiniuUtil().upload(new File("G:/TimeCapsuleImage.jpg"), "testUpload.jpg");
	}

}
