package com.yinbro.tc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping()
public class PageController {

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerPage(Model model) {
		return "register";
	}
	
		
	@RequestMapping("/newCapsule")
	public String newCapsulePage() {
		return "newCapsule";
	}
	
	
	@RequestMapping("/capsuleDetail")
	public String capsuleDetailPage() {
		return "capsule-detail";
	}
	
	
	@RequestMapping("/_blank")
	public String _blankPage() {
		return "_blank";
	}

}
