package com.sinchan.hibernateproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinchan.hibernateproject.payload.BookDto;
import com.sinchan.hibernateproject.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;

//	@GetMapping("/{bookId}")
//	public ResponseEntity<?> getBookById(@PathVariable Integer bookId) {
//		BookDto foundBookDto = this.bookService.findBookById(bookId);
//		return new ResponseEntity<BookDto>(foundBookDto, HttpStatus.OK);
//	}

	@PostMapping("/")
	public ResponseEntity<?> createBook(@RequestBody BookDto bookDto) {
		BookDto createdBook = this.bookService.createBook(bookDto);
		return new ResponseEntity<BookDto>(createdBook, HttpStatus.CREATED);
	}
}
