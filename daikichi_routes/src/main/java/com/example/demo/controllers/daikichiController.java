package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/daikichi/travel/{city}", method=RequestMethod.GET)
	public String fortuneCityPage(@PathVariable ("city") String city) {
		return "Congrats, it looks like you'll be heading to " + city +  " in the near future";
	}
	
	@RequestMapping(value = "/daikichi/lotto/{num}", method=RequestMethod.GET)
	public String fortuneCityPage(@PathVariable ("num") Integer number) {
		if(number % 2 == 0) {
			return "EVEN - You will take a grand journey in the near future, but be weary of tempting offers";
		}
		else {			
			return "ODD - You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
	}
}
