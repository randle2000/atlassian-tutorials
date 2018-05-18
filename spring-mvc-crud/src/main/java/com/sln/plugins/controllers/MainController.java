package com.sln.plugins.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	//private final Logger logger = LoggerFactory.getLogger(MainController.class);

	//@RequestMapping(value = {"/", "/spring/a", "/signin**"}, method = RequestMethod.GET)
	@RequestMapping(value = "*", method = RequestMethod.GET)
	public String aaa() {
		System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
		return "redirect:/myservlet";
	}

}
