package com.yinbro.tc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping()
public class PageController {


	@RequestMapping("/_blank")
	public String _blankPage() {
		return "_blank";
	}

}
