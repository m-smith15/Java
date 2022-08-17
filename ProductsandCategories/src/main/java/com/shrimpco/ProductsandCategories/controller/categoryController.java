package com.shrimpco.ProductsandCategories.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shrimpco.ProductsandCategories.model.Category;
import com.shrimpco.ProductsandCategories.model.Product;
import com.shrimpco.ProductsandCategories.service.CategoryService;
import com.shrimpco.ProductsandCategories.service.ProductService;

@Controller
public class categoryController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/category/new", method=RequestMethod.GET)
	private String newCategory(Model model) {
		model.addAttribute("category", new Category());
		return "newcategory.jsp";
	}
	
	@RequestMapping(value="/category/new/create", method=RequestMethod.POST)
	private String createCategory(@Valid @ModelAttribute("category") Category category,
									BindingResult results) {
		Category potentialCategory = categoryService.createCategory(category, results);
		if(potentialCategory != null) {
			return "redirect:/";
		} else {
			return "newcategory.jsp";
		}
	}
	
	@RequestMapping(value="/category/{id}", method=RequestMethod.GET)
	private String singleCategory(Model model,
								@PathVariable("id") Long id) {
		
		model.addAttribute("category", categoryService.singleCategory(id));
		
		model.addAttribute("products", productService.allProducts());
		
		model.addAttribute("product", new Product());
		
		
		return "singlecategory.jsp";
	}
	
	@RequestMapping(value="/category/{id}/add", method=RequestMethod.PUT)
	private String addProductToCategory(@Valid @ModelAttribute("product") Product product,
										BindingResult results,
										@PathVariable("id") Long id) {
		Long num = product.getId();
		//System.out.println(num);
		
		Product selectedProduct = productService.singleProduct(num);
		//System.out.println(selectedProduct.getId());
		
		Category categoryToAdd = categoryService.singleCategory(id);
		
		categoryToAdd.getProducts().add(selectedProduct);
		//System.out.println(categoryToAdd.getProducts());
		
		//System.out.println(categoryService.createCategory(categoryToAdd, results));
		categoryService.updateCategory(categoryToAdd);
		
		return "redirect:/";
	}
}
