package com.sinchan.hibernateproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinchan.hibernateproject.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

    Optional<Book> findByBookId(Integer bookId);

    // Optional<Book> findByBookName(String bookName);
    //
    // Optional<Book> findByBookAuthor(String bookAuthor);
    //
    // Optional<Book> findByBookPublication(String bookPublication);
    //
    // Optional<Book> findByBookPublicationYear(String bookPublicationDate);

}
