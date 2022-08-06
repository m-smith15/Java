package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class elloHumanController {
	@RequestMapping( "/" )
	public String landPage() {
		System.out.println("hit landing page");
		return "Oi ello my fellow human gov";
	}
	
	@RequestMapping( "/test/{firstName}/{lastName}" ) //hard-coded into the URL localhost/test/shrimp/shrimpton
	public String namePage( @PathVariable("firstName") String firstName, 
							@PathVariable("lastName") String lastName) {
		System.out.println(firstName + lastName);
		return "Ello gov with a first name of " + firstName + " and lastName of " + lastName;
	}
	
	//http://localhost:8080/test2/?firstName=Shrimp&lastName=Shrimpton&times=3
	@RequestMapping("/test2/")
	public String nameAndTimesPage( @RequestParam( value = "firstName") String firstName,
									@RequestParam( value = "lastName") String lastName,
									@RequestParam ( value = "times") Integer times) {
		
		System.out.println(firstName + lastName + times);
		String output = "ello " + firstName + " " + lastName;
		return output.repeat(times); //repeat with times here
	}

}
