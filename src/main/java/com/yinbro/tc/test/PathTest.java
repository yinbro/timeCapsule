package com.yinbro.tc.test;

import java.io.File;

import com.yinbro.tc.util.QrCodeUtil;

public class PathTest {
	public static void main(String[] args){
		QrCodeUtil.getQrCodeImg("http://blog.csdn.net/gao36951/article/details/41148075");
		QrCodeUtil.getStrFromQr(new File("C:\\Users\\yinya\\Desktop\\new.png") );
	}

}
