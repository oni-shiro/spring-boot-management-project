package com.sinchan.hibernateproject.services;

import com.sinchan.hibernateproject.payload.BookDto;

public interface BookService {

	// get calls
//	BookDto findBookById(Integer bookId);

//	BookDto findBookByName(String bookName);
//
//	BookDto findBookByAuthor(String bookAuthor);
//
//	BookDto findBookByPublication(String bookPublication);
//
//	BookDto findBookByPublicationYear(String bookPublicationYear);
//
	// post call (create book)
	BookDto createBook(BookDto bookDto);
//
//	// Update book details
//	BookDto updateBookDetails(Integer bookId, BookDto bookDto);
//
//	// delete book details
//	void deleteBook(Integer bookId);

}
