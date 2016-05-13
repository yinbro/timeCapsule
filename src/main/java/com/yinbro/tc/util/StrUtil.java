package com.yinbro.tc.util;

import java.io.UnsupportedEncodingException;

public class StrUtil {

	public static String str2ISO8859(String strSrc) {
		String rs = null;
		try {
			rs = new String(strSrc.getBytes(), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
