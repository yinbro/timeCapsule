package com.yinbro.tc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class PageController {

	@RequestMapping("login")
	public String loginPage(Model model) {
		System.out.println("Login Controller");
		return "login";
	}
	
	@RequestMapping("/capsuleDetail")
	public String capsuleDetail() {
		System.out.println("capsuleDetail Controller");
		return "capsule-detail";
	}


}
