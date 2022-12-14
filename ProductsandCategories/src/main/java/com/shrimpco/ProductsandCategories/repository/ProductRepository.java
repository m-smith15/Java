package com.shrimpco.ProductsandCategories.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shrimpco.ProductsandCategories.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findAll();
	Optional<Product> findByName(String name);
}
