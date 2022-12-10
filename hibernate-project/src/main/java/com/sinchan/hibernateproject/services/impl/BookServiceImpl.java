package com.sinchan.hibernateproject.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinchan.hibernateproject.entity.Book;
import com.sinchan.hibernateproject.exceptions.DataIntegrityViolationException;
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

	@Override
	public BookDto findBookByName(String bookName) {
		Book book = this.bookRepo.findByBookName(bookName)
				.orElseThrow(() -> new ResourceNotFoundException("Book", "bookName",
						bookName));
		return this.modelMapper.map(book, BookDto.class);
	}

	@Override
	public List<BookDto> findBookByAuthor(String bookAuthor) {
		List<Optional<Book>> bookList = this.bookRepo.findByBookAuthorContaining(bookAuthor);
		List<BookDto> collectBookDtos = bookList.stream().map(book -> this.modelMapper.map(book, BookDto.class))
				.collect(Collectors.toList());
		return collectBookDtos;
	}

	@Override
	public List<BookDto> findBookByPublication(String bookPublication) {
		List<Optional<Book>> bookListsByPublication = this.bookRepo.findByBookPublicationContaining(bookPublication);
		List<BookDto> collecDtos = bookListsByPublication.stream()
				.map(book -> this.modelMapper.map(book, BookDto.class)).collect(Collectors.toList());
		return collecDtos;
	}

	@Override
	public List<BookDto> findBookByPublicationYear(String bookPublicationYear) {
		List<Optional<Book>> bookListsByPublicationYear = this.bookRepo
				.findByBookPublicationYearContaining(bookPublicationYear);
		List<BookDto> collecBookDtos = bookListsByPublicationYear.stream()
				.map(book -> this.modelMapper.map(book, BookDto.class))
				.collect(Collectors.toList());
		return collecBookDtos;

	}

	@Override
	public BookDto createBook(BookDto bookDto) {
		Book savedBook = new Book();
		try {
			savedBook = this.bookRepo.save(this.modelMapper.map(bookDto, Book.class));
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Book", "bookName", bookDto.getBookName());
		}
		return this.modelMapper.map(savedBook, BookDto.class);
	}

	@Override
	public BookDto updateBookDetails(Integer bookId, BookDto bookDto) {
		Book book = this.bookRepo.findByBookId(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book", "book id", bookId));
		book.setBookName(bookDto.getBookName());
		book.setBookCount(bookDto.getBookCount());
		book.setBookAuthor(bookDto.getBookAuthor());
		book.setBookDesc(bookDto.getBookDesc());
		book.setBookPublication(bookDto.getBookPublication());
		book.setBookPublicationYear(bookDto.getBookPublicationYear());

		Book savedBook = new Book();
		try {
			savedBook = this.bookRepo.save(book);
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Book", "bookName", bookDto.getBookName());
		}
		return this.modelMapper.map(savedBook, BookDto.class);

	}

	@Override
	public void deleteBook(Integer bookId) {
		Book book = this.bookRepo.findByBookId(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book", "bookId", bookId));
		this.bookRepo.delete(book);
	}

	@Override
	public List<BookDto> getAllBooks() {
		List<Book> allBooks = this.bookRepo.findAll();
		List<BookDto> allBookDtos = allBooks.stream().map(book -> this.modelMapper.map(book, BookDto.class))
				.collect(Collectors.toList());
		return allBookDtos;
	}

}
