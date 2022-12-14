package com.shrimpco.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shrimpco.savetravels.models.Expense;
import com.shrimpco.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	 // creates a book
	 public Expense createExpense(Expense e) {
	     return expenseRepository.save(e);
	 }
	 
	 // finds all
	 public List<Expense> allExpenses() {
	     return expenseRepository.findAll();
	 }
	 // retrieves a expense
	 public Expense findExpense(Long id) {
	     Optional<Expense> optionalExpense = expenseRepository.findById(id);
	     if(optionalExpense.isPresent()) {
	         return optionalExpense.get();
	     } else {
	         return null;
	     }
	 }
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
}
