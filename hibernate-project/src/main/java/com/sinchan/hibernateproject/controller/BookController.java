package com.sinchan.hibernateproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sinchan.hibernateproject.constants.StringConstants;
import com.sinchan.hibernateproject.payload.ApiResponse;
import com.sinchan.hibernateproject.payload.BookDto;
import com.sinchan.hibernateproject.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;

	// Create mapping
	@PostMapping("/addBook")
	public ResponseEntity<?> createBook(@RequestBody BookDto bookDto) {
		BookDto createdBook = this.bookService.createBook(bookDto);
		return new ResponseEntity<BookDto>(createdBook, HttpStatus.CREATED);
	}

	// put/update mappings
	@PutMapping(value = "/updateBook/{bookId}")
	public ResponseEntity<?> updateBookDetails(@PathVariable Integer bookId, @RequestBody BookDto bookDto) {
		BookDto updatedBookDetails = this.bookService.updateBookDetails(bookId, bookDto);
		return new ResponseEntity<BookDto>(updatedBookDetails, HttpStatus.OK);
	}

	// delete mapping
	@DeleteMapping("/deleteBook/{bookId}")
	public ResponseEntity<?> deleteBook(@PathVariable Integer bookId) {
		this.bookService.deleteBook(bookId);
		return new ResponseEntity<ApiResponse>(
				new ApiResponse("Book Id - " + Integer.toString(bookId) + StringConstants.DELETE_MESSAGE, "200 OK"),
				HttpStatus.OK);
	}

	// Get mappings

	@GetMapping("/id/{bookId}")
	public ResponseEntity<?> getBookById(@PathVariable Integer bookId) {
		BookDto foundBookDto = this.bookService.findBookById(bookId);
		return new ResponseEntity<BookDto>(foundBookDto, HttpStatus.OK);
	}

	@GetMapping("/name/{bookName}")
	public ResponseEntity<?> getBookByName(@PathVariable String bookName) {
		BookDto foundBookDto = this.bookService.findBookByName(bookName);
		return new ResponseEntity<BookDto>(foundBookDto, HttpStatus.OK);
	}

	@GetMapping("/getBooks")
	public ResponseEntity<?> getBookByType(@RequestParam String type, @RequestParam String value) {

		List<BookDto> foundBookDtos = new ArrayList<>();
		switch (type) {
			case "author": {
				foundBookDtos = this.bookService.findBookByAuthor(value);
				break;
			}
			case "publication": {
				foundBookDtos = this.bookService.findBookByPublication(value);
				break;
			}
			case "publicationYear": {
				foundBookDtos = this.bookService.findBookByPublicationYear(value);
				break;
			}
		}
		return new ResponseEntity<List<BookDto>>(foundBookDtos, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllBooks() {
		List<BookDto> allBooks = this.bookService.getAllBooks();
		return new ResponseEntity<List<BookDto>>(allBooks, HttpStatus.OK);
	}

}
