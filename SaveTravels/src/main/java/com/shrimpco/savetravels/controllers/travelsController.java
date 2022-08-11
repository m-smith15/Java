package com.shrimpco.savetravels.controllers;

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

import com.shrimpco.savetravels.models.Expense;
import com.shrimpco.savetravels.services.ExpenseService;

@Controller
public class travelsController {
	
	@Autowired
	ExpenseService expenseService;
	
	@RequestMapping ( value = "/", method=RequestMethod.GET)
	public String expensePage(@ModelAttribute("expense") Expense expense,
								Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
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
	
	@RequestMapping(value = "/expenses/edit/{id}")
	public String editExpense(@ModelAttribute("editExpense") Expense expense, 
						@PathVariable("id") Long id,
						Model model) {
//		@SuppressWarnings("unchecked")
//		List<Expense> expense2eidt = (List<Expense>) expenseService.findExpense(id);
		
		expense = expenseService.findExpense(id);
		
		model.addAttribute("editExpense", expense);
		
		return "editexpense.jsp";
	}
	
	@RequestMapping(value = "/edit/{id}", method=RequestMethod.PUT)
	public String edit(@Valid @ModelAttribute("editExpense") Expense expense,
						BindingResult bindingResult,
						Model model) {
		if(bindingResult.hasErrors() ) {
			return "editexpense.jsp";
		} else {
		
		expenseService.createExpense(expense);
		return "redirect:/";
		}
	}
}
