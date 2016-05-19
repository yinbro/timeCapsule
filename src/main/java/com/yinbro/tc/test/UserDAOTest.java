package com.yinbro.tc.test;

import java.sql.SQLException;

import org.junit.Test;

import com.yinbro.tc.dao.UserDAO;
import com.yinbro.tc.pojo.UserBean;


public class UserDAOTest {
	
	@Test
	public void signUpTester(){
		System.out.println("注册测试");
		UserBean user = new UserBean();
		user.setName("yinbro");
		user.setGender(1);
		user.setPassword("yinbro");
		user.setShowMsg("hello,TimeCapsule");
		user.setEmail("yinbro@foxmail.com");
		user.setTele("13800000000");
		user.setWxname("wxyinbro");
		user.setWxopenid("010001");
		
		UserDAO userDAO = new UserDAO();
		System.out.println("注册是否成功：" + userDAO.signUp(user));
	}
	
	@Test
	public void loginTest() {
		System.out.println("登录测试");
		String strUserName = "yinbro";
		String strPassword = "yinbro";
		UserDAO dao = new UserDAO();
		UserBean user  = dao.login(strUserName, strPassword);
		
		if (user == null) {
			System.out.println("用户名或密码错误");
			return;
		}
		System.out.println("登录成功，用户信息：\n "+ user.toString());
	}
	
	
}
