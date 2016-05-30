package com.yinbro.tc.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yinbro.tc.dao.UserDAO;
import com.yinbro.tc.pojo.UserBean;

@Controller
public class UserController {

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	private String registerPost(UserBean user) throws IOException {
		// TODO 解决表达提交的中文乱码问题
		UserDAO dao = new UserDAO();
		if (dao.signUp(user)) {
			return "<br><br><h1 align='center'>注册成功！！！</h1>";
		}
//		System.out.println(user.toString());

		return "<br><br><h1 align='center'>您已注册！</h1>";
	}

}
