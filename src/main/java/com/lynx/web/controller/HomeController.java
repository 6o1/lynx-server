package com.lynx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@RequestMapping(path = { "/", "index" })
	public String getIndexPage() {
		log.debug("Getting home page");
		return "redirect:/home";
	}

	@RequestMapping("/home")
	public String getHomePage() {
		log.debug("Getting home page");
		return "home";
	}

}
