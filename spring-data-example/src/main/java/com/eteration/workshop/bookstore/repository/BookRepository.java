package com.eteration.workshop.bookstore.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eteration.workshop.bookstore.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	List<Book> findByCaption(String caption);

	List<Book> findByCaptionContaining(String string);
	
	List<Book> findByType(String type);
	
	List<Book> findByCaptionAndType(String caption, String type);
	
	List<Book> findByPublishDateGreaterThan(Date date);
	
	@Query("select book from Book book where book.author.name=:authorName")
	List<Book> findByAuthorName(@Param("authorName") String name);
}
