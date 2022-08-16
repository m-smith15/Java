package com.shrimpco.bookclub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.shrimpco.bookclub.model.Book;
import com.shrimpco.bookclub.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	//basics - create, find all, find 1, delete
	
	public Book createBook(Book book, BindingResult bindingResults) {
		if(bindingResults.hasErrors()) {
			return null;
		} else {
			bookRepository.save(book);
			return book;
		}
	}
	
	public boolean editBook(Book book, BindingResult bindingResults) {
		if(bindingResults.hasErrors()) {
			return false;
		} else {
			bookRepository.save(book);
			return true;
		}
	}
	
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	public Book singleBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
			if(optionalBook.isPresent()) {
				return optionalBook.get();
			} else {
				return null;
			}
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
}
