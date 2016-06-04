package com.yinbro.tc.notification;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailNotify {

	public static String host = "smtp.163.com";
	public static String username = "timeCapsule_admin";
	public static String pass = "tc222222";

	/**
	 * @param from
	 *            发件人
	 * @param to
	 *            收件人
	 * @param subject
	 *            邮件主题
	 * @param text
	 *            邮件内容
	 * @param host
	 *            邮件服务器类型(请传入smtp类型的邮件服务器)
	 * @param username
	 *            登录用户名
	 * @param password
	 *            登录密码
	 * @throws MessagingException
	 */
	public static void sendMail(String from, String to, String subject, String text, String host, String username,
			String password) {
		// 设置服务器验证信息
		Properties prop = new Properties();
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.smtp.timeout", "30000");
		prop.setProperty("mail.smtp.host", host);

		JavaMailSenderImpl javaMailSend = new JavaMailSenderImpl();
		MimeMessage message = javaMailSend.createMimeMessage();
		MimeMessageHelper messageHelper = null;
		try {
			messageHelper = new MimeMessageHelper(message, true, "utf-8");
			messageHelper.setFrom(from);
			messageHelper.setTo(to);
			messageHelper.setSubject(subject);
			messageHelper.setText(text, true);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		// 设置邮件服务器登录信息
		javaMailSend.setHost(host);
		javaMailSend.setUsername(username);
		javaMailSend.setPassword(password);
		javaMailSend.setJavaMailProperties(prop);

		javaMailSend.send(message);

	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		sendMail("timeCapsule_admin@163.com", "yinbro@foxmail.com", "【时间胶囊通知】", "您创建的时间胶囊已到期，Key：", host,
				username, pass);
	}

}
