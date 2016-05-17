package com.eteration.workshop.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eteration.workshop.bookstore.model.Author;
import com.eteration.workshop.bookstore.repository.AuthorRepository;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	AuthorRepository authorRepository;
	
	@RequestMapping(path="", method = RequestMethod.GET)
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}
	
}
