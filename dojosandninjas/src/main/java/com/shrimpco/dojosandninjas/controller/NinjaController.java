package com.shrimpco.dojosandninjas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shrimpco.dojosandninjas.model.Dojo;
import com.shrimpco.dojosandninjas.model.Ninja;
import com.shrimpco.dojosandninjas.service.DojoService;
import com.shrimpco.dojosandninjas.service.NinjaService;

@Controller
public class NinjaController {

	
	//not sure what this is, was in one of learn platform videos?
	@Autowired
	NinjaService ninjaService;
	
	@Autowired
	DojoService dojoService;
	
	@RequestMapping(value="/ninja/create", method=RequestMethod.GET)
	public String addNinja(@ModelAttribute("ninja") Ninja ninja,
							Model model) {
		List<Dojo> dojolist = dojoService.allDojos();
		model.addAttribute("dojos", dojolist);
		return "addninja.jsp";
	}
	
	@RequestMapping(value="/ninja/create", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja,
							BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/ninja/new";
		} else {	
			ninjaService.createNinja(ninja);
			return "redirect:/";
		}
	}
	
}
