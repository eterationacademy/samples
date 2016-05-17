package com.eteration.workshop.bookstore.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eteration.workshop.bookstore.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	Author findByName(String name);
	
	List<Author> findByBirthDateBetween(Date firstDate, Date secondDate);
	
	@Query("select author from Author author inner join author.books book where book.caption=:bc")
	List<Author> findByBookName(@Param("bc") String bookName);
}
