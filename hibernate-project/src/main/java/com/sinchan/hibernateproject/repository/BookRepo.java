package com.sinchan.hibernateproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sinchan.hibernateproject.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

//	Optional<Book> findByBookName(String bookName);
//
//	Optional<Book> findByBookAuthor(String bookAuthor);
//
//	Optional<Book> findByBookPublication(String bookPublication);
//
//	Optional<Book> findByBookPublicationYear(String bookPublicationDate);

}
