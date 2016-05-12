package com.yinbro.tc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class PageController {

	@RequestMapping("login")
	public String loginPage() {
		return "login";
	}
	

	@RequestMapping("registe")
	public String registePage(Model model) {
		return "registe";
	}
	
		
	@RequestMapping("/newCapsule")
	public String newCapsule() {
		return "newCapsule";
	}
	
	
	@RequestMapping("/capsuleDetail")
	public String capsuleDetail() {
		return "capsule-detail";
	}
	
	
	@RequestMapping("/_blank")
	public String _blank() {
		return "_blank";
	}

}
