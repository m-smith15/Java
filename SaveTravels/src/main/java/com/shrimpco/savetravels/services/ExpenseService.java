package com.shrimpco.savetravels.services;

import java.util.List;

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
}
