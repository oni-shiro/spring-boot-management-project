package com.sinchan.hibernateproject.services;

import java.util.List;

import com.sinchan.hibernateproject.payload.BookDto;

public interface BookService {

    // get calls
    BookDto findBookById(Integer bookId);

    BookDto findBookByName(String bookName);

    List<BookDto> findBookByAuthor(String bookAuthor);

    List<BookDto> findBookByPublication(String bookPublication);

    List<BookDto> findBookByPublicationYear(String bookPublicationYear);

    List<BookDto> getAllBooks();

    // post call (create book)
    BookDto createBook(BookDto bookDto);

    // Update book details
    BookDto updateBookDetails(Integer bookId, BookDto bookDto);

    // delete book details
    void deleteBook(Integer bookId);

    // get book count
    int getBookCount(Integer bookId);

    //updates book count depending on bookName
    void updateBookCountAfterBorrow(String bookName);

}
