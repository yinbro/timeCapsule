package com.yinbro.tc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class PageController {


	@RequestMapping("/_blank")
	public String _blankPage() {
		return "_blank";
	}

	@RequestMapping(value = "/wxOnly")
	public String wxOnly() {
		return "wxOnly";
	}

	
}
