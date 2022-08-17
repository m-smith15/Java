package com.shrimpco.ProductsandCategories.controller;

import java.util.List;

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
public class productController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	private String indexPage(Model model) {
		
		List<Product> allProducts = productService.allProducts();
		model.addAttribute("products", allProducts);
		
		List<Category> allCategories = categoryService.allCategories();
		model.addAttribute("category", allCategories);
		
		return "index.jsp";
		
	}
	
	@RequestMapping(value="/product/new", method=RequestMethod.GET)
	private String newProduct(Model model) {
		model.addAttribute("product", new Product());
		
		return "newproduct.jsp";
	}
	
	@RequestMapping(value="/product/new/create", method=RequestMethod.POST)
	private String createProduct(@Valid @ModelAttribute("product") Product product,
								BindingResult result) {
		Product potentialProduct = productService.createProduct(product, result);
		if(potentialProduct != null) {
			return "redirect:/";
		} else {
			return "newproduct.jsp";
		}
	}
	
	@RequestMapping(value="/product/{id}", method=RequestMethod.GET)
	private String singleProduct(Model model,
								@PathVariable("id") Long id) {
		
		model.addAttribute("product", productService.singleProduct(id));
		
		model.addAttribute("categories", categoryService.allCategories());
		
		model.addAttribute("category", new Category());

		
		return "singleproduct.jsp";
	}
	
	@RequestMapping(value="/product/{id}/add", method=RequestMethod.POST)
	private String addCategoryToProduct(@Valid @ModelAttribute("category") Category category,
										BindingResult results,
										@PathVariable("id") Long id) {
		Long num = category.getId();
		//System.out.println(num);
		
		Category selectedCategory = categoryService.singleCategory(num);
		//System.out.println(selectedCategory.getId());
		
		Product productToAdd = productService.singleProduct(id);
		
		productToAdd.getCategories().add(selectedCategory);
		//System.out.println(productToAdd.getCategories());
		
		//System.out.println(productService.createProduct(productToAdd, results));
		productService.updateProduct(productToAdd);
		
		return "redirect:/";
	}
}
