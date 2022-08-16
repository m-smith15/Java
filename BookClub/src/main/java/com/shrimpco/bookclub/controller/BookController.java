package com.shrimpco.bookclub.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shrimpco.bookclub.model.Book;
import com.shrimpco.bookclub.model.User;
import com.shrimpco.bookclub.service.BookService;
import com.shrimpco.bookclub.service.UserService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping( value="/dashboard", method=RequestMethod.GET)
	private String dashboard(Model model,
							HttpSession session) {
		List<Book> listOBooks = bookService.allBooks();
		model.addAttribute("books", listOBooks);
		
		String email = (String) session.getAttribute("email");
		User currentUser = userService.singleUserByLogin(email);
		model.addAttribute("user", currentUser);
		return "dashboard.jsp";
	}
	
	@RequestMapping( value="/book/create", method=RequestMethod.GET)
	private String CreateABook(Model model) {
		model.addAttribute("book", new Book());
		return "createbook.jsp";
	}
	
	@RequestMapping( value="/book/create/new", method=RequestMethod.POST)
	private String createBook(@Valid @ModelAttribute("book") Book book,
							BindingResult bindingResults) {
		
		Book potentialBook = bookService.createBook(book, bindingResults);
		if(potentialBook != null) {
			return "redirect:/dashboard";
		}else {
			return "createbook.jsp";
		}
	}
	
	@RequestMapping( value="/book/view/{id}", method=RequestMethod.GET)
	private String viewBook(@PathVariable("id") Long id,
							Model model,
							HttpSession session) {
		String email = (String) session.getAttribute("email");
		User currentUser = userService.singleUserByLogin(email);
//		System.out.println(currentUser.getId());
		model.addAttribute("book", bookService.singleBook(id));
		model.addAttribute("user", currentUser);
	
		
		return "viewbook.jsp";
	}
	
	@RequestMapping( value="/book/edit/{id}", method=RequestMethod.GET)
	private String editBook(@PathVariable("id") Long id,
							Model model,
							HttpSession session) {
		model.addAttribute("book", bookService.singleBook(id));
		
		return "editbook.jsp";
	}
	
	@RequestMapping( value="/book/edit/{id}", method=RequestMethod.PUT)
	private String processEditBook(@Valid @ModelAttribute("book") Book book,
									BindingResult bindingResult,
									@PathVariable("id") Long id,
									Model model,
									HttpSession session) {
		
		boolean potentialUpdate = bookService.editBook(book, bindingResult);
		if(potentialUpdate == true) {
			return "redirect:/dashboard";
		} else {
			return "editbook.jsp";
		}	
	}
									

}
