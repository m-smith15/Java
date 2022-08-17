package com.shrimpco.ProductsandCategories.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.shrimpco.ProductsandCategories.model.Category;
import com.shrimpco.ProductsandCategories.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	//todo - create, find all, find 1, delete
	
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
	
	public Category createCategory(Category category, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return null;
		} else {
			categoryRepository.save(category);
			return category;
		}
	}
	
	public Category singleCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
			if(optionalCategory != null) {
				return optionalCategory.get();
			} else {
				return null;
			}
	}
	
	public Category updateCategory(Category category) {
		categoryRepository.save(category);
		return category;
	}
}
