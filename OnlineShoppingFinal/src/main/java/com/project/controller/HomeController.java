package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller


public class HomeController {
	@RequestMapping({"/","/home"})
	public String Front1(){
		return "HomePage";
	}
	@RequestMapping("/aboutUs")
	public String aboutUs(){
		return "about";
	}

}
