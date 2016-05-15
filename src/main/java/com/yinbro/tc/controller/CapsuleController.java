package com.yinbro.tc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yinbro.tc.pojo.CapsuleBean;

@Controller
public class CapsuleController {

	@RequestMapping(value = "/newCapsulePost", method = RequestMethod.POST)
	private String newCapsulePost(HttpServletRequest request) {
		System.out.println("Controller");
		return "index";
	}

}
