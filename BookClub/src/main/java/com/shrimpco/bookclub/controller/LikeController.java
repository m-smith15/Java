package com.shrimpco.bookclub.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shrimpco.bookclub.model.Book;
import com.shrimpco.bookclub.model.User;
import com.shrimpco.bookclub.service.BookService;
import com.shrimpco.bookclub.service.UserService;

@Controller
public class LikeController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping( value="/book/like/{id}", method=RequestMethod.POST)
	private String addLike(@PathVariable("id") Long id,
							HttpSession session,
							Model model) {
		//get user
		String email = (String) session.getAttribute("email");
		User currentUser = userService.singleUserByLogin(email);
		
		//get book
		Book currentBook = bookService.singleBook(id);
		
		currentUser.getBookLikes().add(currentBook);
		
		userService.createUser(currentUser);
		
		return "redirect:/dashboard";
	}

}
