package com.yinbro.tc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	
	@RequestMapping("/capsuleDetail")
	public String capsuleDetail() {
		System.out.println("Controller");
		return "capsule-detail";
	}
	

}
