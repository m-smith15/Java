package com.shrimpco.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class counterController {

	 	@RequestMapping("/")
		public String index(HttpSession session) {
			
	    	// If the count is not already in session
			if (session.getAttribute("count") == null) {
			// Use setAttribute to initialize the count in session
				session.setAttribute("count", 0);
			}

			return "Index.jsp";
		}
	 	
	 	@RequestMapping("/counter")
		public String counter(HttpSession session) {
			int tempCount = (int) session.getAttribute("count");
			tempCount += 1;
			session.setAttribute("count",tempCount);
			
	    	session.getAttribute("count");
			return "Counter.jsp";
		}
	 	
	 	@RequestMapping("/reset")
		public String reset(HttpSession session) {
	    	session.removeAttribute("count");
			return "reset.jsp";
		}
	 	
	 	@RequestMapping("/counter2")
		public String counter2(HttpSession session) {
			int tempCount = (int) session.getAttribute("count");
			tempCount += 2;
			session.setAttribute("count",tempCount);
			
	    	session.getAttribute("count");
	    	return "Counter2.jsp";
	 	}

}