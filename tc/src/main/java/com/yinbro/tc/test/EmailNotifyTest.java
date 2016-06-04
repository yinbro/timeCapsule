package com.yinbro.tc.test;

import org.junit.Test;

import com.yinbro.tc.notification.EmailNotify;

public class EmailNotifyTest {

	public static String host = "smtp.163.com";
	public static String username = "timeCapsule_admin";
	public static String pass = "tc222222";

	@Test
	public void testSend() {
		EmailNotify.sendMail("timeCapsule_admin@163.com", "yinbro@foxmail.com", "【时间胶囊通知】",
				"您创建的时间胶囊已到开启日期，请凭Key：1c402d08dbbb03083324215ddb983e28前往系统开启", host, username, pass);
	}

}
