package com.shrimpco.hoppersrecipt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class hoppersreciptControllers {
	// class definition and imports here...
    @RequestMapping("/")
    public String index(Model model) {
        
        String name = "Grace 'large shrimp' Hopper";
        String itemName = "Copper shrimpin' wire";
        double price = 5.25;
        String description = "Metal shrimps, also an illustration of nanoshrimps.";
        String vendor = "Little Things Shrimp Store";
        
        model.addAttribute("name", name);
        model.addAttribute("itemName", itemName);
        model.addAttribute("price", price);
        model.addAttribute("description", description);
        model.addAttribute("vendor", vendor);
    
        return "index.jsp";
    }
    //...
}
