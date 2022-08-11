package com.shrimpco.savetravels.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shrimpco.savetravels.models.Expense;
import com.shrimpco.savetravels.services.ExpenseService;

@Controller
public class travelsController {
	
	@Autowired
	ExpenseService expenseService;
	
	@RequestMapping ( value = "/", method=RequestMethod.GET)
	public String expensePage(@ModelAttribute("expense") Expense expense,
								HttpSession session) {
		List<Expense> expenses = expenseService.allExpenses();
		session.setAttribute("expenses", expenses);
		//System.out.println(expenses);
		return "expense.jsp";
	}
	
	@RequestMapping ( value = "/create", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("expense") Expense expense, 
						BindingResult result) {
		if (result.hasErrors()) {
			return "/";
		} else {
			expenseService.createExpense(expense);
			return"redirect:/";
		}
		
	}
}
