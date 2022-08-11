package com.shrimpco.savetravels.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shrimpco.savetravels.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
	
	List<Expense> findAll();
	Optional<Expense> findById(Long id);
	void deleteById(Long id);
	
}
