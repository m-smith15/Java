package com.shrimpco.ProductsandCategories.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.shrimpco.ProductsandCategories.model.Product;
import com.shrimpco.ProductsandCategories.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	//todo create, find all, find 1, delete
	
	//find all
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	public Product updateProduct(Product product) {
		productRepository.save(product);
		return product;
	}
	
	public Product createProduct(Product product, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return null;
		} else {
			productRepository.save(product);
			return product;
		}
	}
	
	public Product singleProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
			if(optionalProduct != null) {
				return optionalProduct.get();
			} else {
				return null;
			}
	}
}
