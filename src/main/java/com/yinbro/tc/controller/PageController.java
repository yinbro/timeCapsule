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
	@RequestMapping("index")
	public String indexPage() {
		return "index";
	}

	@RequestMapping("registe")
	public String registePage(Model model) {
		return "registe";
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
