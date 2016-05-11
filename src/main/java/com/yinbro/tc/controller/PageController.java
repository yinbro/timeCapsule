package com.yinbro.tc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	
	@RequestMapping("/capsuleDetail.do")
	public String capsuleDetail() {
		System.out.println("Controller2");
		return "capsule-detail";
	}
	
	

	@RequestMapping("/login.do")
	public String loginPage() {
		System.out.println("Controller1");
		return "redirect:/capsuleDetail.do";
	}

}
