package com.eteration.workshop.bookstore.test;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eteration.workshop.bookstore.BookStoreApplication;
import com.eteration.workshop.bookstore.model.Author;
import com.eteration.workshop.bookstore.model.Book;
import com.eteration.workshop.bookstore.repository.AuthorRepository;
import com.eteration.workshop.bookstore.repository.BookRepository;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(BookStoreApplication.class)
@Transactional
public class AuthorRepositoryTests {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@Before
	public void setup() {
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(1881, Calendar.FEBRUARY, 9);
		Author author1 = new Author("Dostotevski", calendar.getTime());
		
		calendar.set(1946, Calendar.APRIL, 7);
		Book book1 = new Book("İnsancıklar", "Roman");
		book1.setPublishDate(calendar.getTime());
		
		calendar.set(1966, Calendar.APRIL, 7);
		Book book2 = new Book("Suç Ve Ceza", "Roman");
		book2.setPublishDate(calendar.getTime());
		
		book1.setAuthor(author1);
		book2.setAuthor(author1);
		
		author1.getBooks().add(book1);
		author1.getBooks().add(book2);
		
		authorRepository.save(author1);
	}
	
	
	@Test
	public void testFetchAuthorList_shouldReturnAllAuthors() {
		
		List<Author> allAuthors = authorRepository.findAll();
		assertNotNull(allAuthors);
	}
	
	@Test
	public void testFetchAuthorByName_shouldReturnAuthor() {
		
		Author author = authorRepository.findByName("Dostotevski");
		assertNotNull(author);
	}
	
	@Test
	public void testFetchAuthorByBook() {
		
		List<Author> findByBookName = authorRepository.findByBookName("İnsancıklar");
		
		assertNotNull(findByBookName);
	}
	
	
}
