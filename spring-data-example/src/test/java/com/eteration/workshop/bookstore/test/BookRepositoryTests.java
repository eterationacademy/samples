package com.eteration.workshop.bookstore.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eteration.workshop.bookstore.BookStoreApplication;
import com.eteration.workshop.bookstore.model.Book;
import com.eteration.workshop.bookstore.repository.BookRepository;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(BookStoreApplication.class)
@Transactional
public class BookRepositoryTests {

	@Autowired
	BookRepository bookRepository;
	
	List<Book> firstBookList = new ArrayList<Book>();
	
	@Before
	public void setup() {
		Calendar calendar = Calendar.getInstance();
		
		//------------------------------------------
		//
		// İlk kitap objemizi oluşturuyoruz
		Book book1 = new Book("Kürk Mantolu Madonna", "Roman");
		
		//
		// Kitabın yayınlanma tarihini set ediyoruz
		
		calendar.set(1943, 10, 18);
		Date book1pd = calendar.getTime();
		book1.setPublishDate(book1pd);
		
		// İlk kitabımızı kaydediyoruz
		
		bookRepository.save(book1);
		
		firstBookList.add(book1);
		
		
		//------------------------------------------
		//
		// İkinci kitap objemizi oluşturuyoruz
		Book book2 = new Book("Suç Ve Ceza", "Roman");
		
		//
		// Kitabın yayınlanma tarihini set ediyoruz
		calendar.set(1886, 0, 1);
		Date book2pd = calendar.getTime();
		book2.setPublishDate(book2pd);
		
		// İlk kitabımızı kaydediyoruz
		bookRepository.save(book2);
		
		firstBookList.add(book2);
		
		
		//------------------------------------------
		//
		// Üçüncü kitap objemizi oluşturuyoruz
		Book book3 = new Book("Çalıkuşu", "Roman");
		
		//
		// Kitabın yayınlanma tarihini set ediyoruz
		calendar.set(1922, Calendar.JANUARY, 1);
		Date book3pd = calendar.getTime();
		book3.setPublishDate(book3pd);
		
		// İlk kitabımızı kaydediyoruz
		bookRepository.save(book3);
		
		firstBookList.add(book3);
		
		
		//------------------------------------------
		//
		// Üçüncü kitap objemizi oluşturuyoruz
		Book book4 = new Book("Aşk Hikayeleri", "Hikaye");
		
		//
		// Kitabın yayınlanma tarihini set ediyoruz
		calendar.set(2016, Calendar.MARCH, 1);
		Date book4pd = calendar.getTime();
		book3.setPublishDate(book4pd);
		
		// İlk kitabımızı kaydediyoruz
		bookRepository.save(book4);
		
		firstBookList.add(book4);
	}
	
	
	@Test
	public void testFindAllBooks_shouldReturnSavedBookList() {
		
		List<Book> bookList = bookRepository.findAll();
		
		assertNotNull(bookList);
		assertTrue(bookList.size() == firstBookList.size());
	}
	
	@Test
	public void testFindByCaptionLike_shouldReturnBookListCaptionsContainingText() {
		List<Book> booksContainingKeyword = bookRepository.findByCaptionContaining("Suç");
		
		assertNotNull(booksContainingKeyword);
		assertTrue(booksContainingKeyword.size() == 1);
	}
	
	@Test
	public void testFindByType_shouldReturnBooksGivenType() {
		
		List<Book> booksWithType = bookRepository.findByType("Hikaye");
		
		assertNotNull(booksWithType);
		assertTrue(booksWithType.size() == 1);
	}
}
