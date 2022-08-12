package com.shrimpco.dojosandninjas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shrimpco.dojosandninjas.model.Dojo;
import com.shrimpco.dojosandninjas.service.DojoService;


@Controller
public class DojoController {
	
	//not sure what this is, was in one of learn platform videos?
//	@Autowired
//	DojoService dojoService;
//	
//	@Autowired
//	NinjaService ninjaService;
	
	private final DojoService dojoService;
	
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping ( value="/")
	public String homePage(@ModelAttribute("dojos") Dojo dojo,
							Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		
		return "index.jsp";
	}
	
	@RequestMapping ( value="/dojo/create", method=RequestMethod.GET)
	public String createDojoPage(@ModelAttribute("dojo") Dojo dojo,
								Model model) {
		
		return "createdojo.jsp";
	}
	
	@RequestMapping(value="/dojo/create", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo,
							BindingResult result) {
		if(result.hasErrors()) {
			return "createdojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/dojo/{id}", method=RequestMethod.GET)
	public String viewDojo(@ModelAttribute("dojo") Dojo dojo,
							@PathVariable("id") Long id,
							Model model) {
		
		dojo = dojoService.singleDojo(id);
		
		model.addAttribute("dojo", dojo);
		
		return "viewdojo.jsp";
	}
	
}
