package com.yinbro.tc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	

	@RequestMapping("/login")
	public String loginPage() {
		System.out.println("Login Controller");
		return "login";
	}
	
	
	@RequestMapping("/capsuleDetail.do")
	public String capsuleDetail() {
		System.out.println("Controller2");
		return "capsule-detail";
	}
	
	


}
