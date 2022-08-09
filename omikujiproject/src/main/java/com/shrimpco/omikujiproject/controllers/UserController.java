package com.shrimpco.omikujiproject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shrimpco.omikujiproject.modules.Omikuji;

@Controller
public class UserController {
	
	@RequestMapping(value="/")
	public String landingPage() {
		
		
		return "index.jsp";
	}
	
	@RequestMapping(value="/create/omikuji", method=RequestMethod.POST)
	public String createOmikuji (@RequestParam(value="years") Integer years,
								 @RequestParam(value="city") String city,
								 @RequestParam(value="person") String person,
								 @RequestParam(value="hobby") String hobby,
								 @RequestParam(value="creature") String creature,
								 @RequestParam(value="nice") String nice,
								 HttpSession session) {
		
		session.setAttribute("years", years);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("creature", creature);
		session.setAttribute("nice", nice);
		
		return "redirect:/omikuji";
		
	}
	
	@RequestMapping(value="/omikuji")
	public String omikujiPage() {
		return "Omikuji.jsp";
	}

}


//years
//city 
//person
//hobby
//creature
//nice