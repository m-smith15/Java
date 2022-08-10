package com.shrimpco.books.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shrimpco.books.mvc.models.Book;
import com.shrimpco.books.mvc.services.BookService;

@Controller
public class BooksController {

	@Autowired
	BookService bookService;
	
	@RequestMapping( value = "/books/{bookId}")
	public String homePage(Model model, @PathVariable("bookId") Long bookId) {
		
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		System.out.println(book);
		
		//ArrayList<Book> books = bookService.getAllBooks();
		
		model.addAttribute("book", book);
		//model.addAttribute("books", books);
		
		
		return "index.jsp";
	}
	
	    
	 	@RequestMapping("/books")
	    public String index(Model model) {
	        List<Book> books = bookService.allBooks();
	        model.addAttribute("books", books);
	        return "allbooks.jsp";
	    }
}
	

