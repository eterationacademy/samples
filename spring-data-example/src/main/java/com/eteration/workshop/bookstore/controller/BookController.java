package com.eteration.workshop.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eteration.workshop.bookstore.model.Book;
import com.eteration.workshop.bookstore.repository.BookRepository;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@RequestMapping(path="", method = RequestMethod.GET)
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
}
