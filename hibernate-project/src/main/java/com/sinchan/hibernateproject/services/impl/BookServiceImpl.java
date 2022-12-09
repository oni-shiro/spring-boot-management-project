package com.sinchan.hibernateproject.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinchan.hibernateproject.entity.Book;
import com.sinchan.hibernateproject.exceptions.ResourceNotFoundException;
import com.sinchan.hibernateproject.payload.BookDto;
import com.sinchan.hibernateproject.repository.BookRepo;
import com.sinchan.hibernateproject.services.BookService;

@Component
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BookDto findBookById(Integer bookId) {
		Book book = this.bookRepo.findByBookId(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book", "bookId", bookId));
		return this.modelMapper.map(book, BookDto.class);
	}

	// @Override
	// public BookDto findBookByName(String bookName) {
	// Book book = this.bookRepo.findByBookName(bookName)
	// .orElseThrow(() -> new ResourceNotFoundException("Book", "bookName",
	// bookName));
	// return this.modelMapper.map(book, BookDto.class);
	// }
	//
	// @Override
	// public BookDto findBookByAuthor(String bookAuthor) {
	// Book book = this.bookRepo.findByBookAuthor(bookAuthor)
	// .orElseThrow(() -> new ResourceNotFoundException("Book", "bookAuthor",
	// bookAuthor));
	// return this.modelMapper.map(book, BookDto.class);
	// }
	//
	// @Override
	// public BookDto findBookByPublication(String bookPublication) {
	// Book book = this.bookRepo.findByBookPublication(bookPublication)
	// .orElseThrow(() -> new ResourceNotFoundException("Book", "bookPublication",
	// bookPublication));
	// return this.modelMapper.map(book, BookDto.class);
	// }
	//
	// @Override
	// public BookDto findBookByPublicationYear(String bookPublicationYear) {
	// Book book = this.bookRepo.findByBookPublicationYear(bookPublicationYear)
	// .orElseThrow(() -> new ResourceNotFoundException("Book",
	// "bookPublicationYear", bookPublicationYear));
	// return this.modelMapper.map(book, BookDto.class);
	// }
	//
	@Override
	public BookDto createBook(BookDto bookDto) {
		Book savedBook = this.bookRepo.save(this.modelMapper.map(bookDto, Book.class));
		return this.modelMapper.map(savedBook, BookDto.class);
	}
	//
	// @Override
	// public BookDto updateBookDetails(Integer bookId, BookDto bookDto) {
	// Book book = this.bookRepo.findById(bookId).get();
	// book.setBookName(bookDto.getBookName());
	// book.setBookCount(bookDto.getBookCount());
	// book.setBookAuthor(bookDto.getBookAuthor());
	// book.setBookDesc(bookDto.getBookDesc());
	// book.setBookPublication(bookDto.getBookPublication());
	// book.setBookPublicationYear(bookDto.getBookPublicationYear());
	//
	// Book savedBook = this.bookRepo.save(book);
	// return this.modelMapper.map(savedBook, BookDto.class);
	//
	// }
	//
	// @Override
	// public void deleteBook(Integer bookId) {
	// Book book = this.bookRepo.findById(bookId)
	// .orElseThrow(() -> new ResourceNotFoundException("Book", "bookId", bookId));
	// this.bookRepo.delete(book);
	// }

}
