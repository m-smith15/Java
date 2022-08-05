package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class daikichiController {
	@RequestMapping(value = "/daikichi", method=RequestMethod.GET)
	public String landingpage() {
		return "Welcome";
	}
	@RequestMapping(value = "/daikichi/today", method=RequestMethod.GET)
	public String todayPage() {
		return "Today you will find luck in all your endeavors!";
	}
	@RequestMapping(value = "/daikichi/tomorrow", method=RequestMethod.GET)
	public String tomorrowPage() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
}
