package com.sinchan.hibernateproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinchan.hibernateproject.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

    Optional<Book> findByBookId(Integer bookId);

    Optional<Book> findByBookName(String bookName);

    List<Optional<Book>> findByBookAuthorContaining(String bookAuthor);

    List<Optional<Book>> findByBookPublicationContaining(String bookPublication);

    List<Optional<Book>> findByBookPublicationYearContaining(String bookPublicationDate);

}
