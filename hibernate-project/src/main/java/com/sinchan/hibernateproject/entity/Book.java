package com.sinchan.hibernateproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Integer bookId;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "book_author")
	private String bookAuthor;
	@Column(name = "book_publication")
	private String bookPublication;
	@Column(name = "book_desc")
	private String bookDesc;
	@Column(name = "book_count")
	private Integer bookCount;
	@Column(name = "book_publication_year")
	private String bookPublicationYear;

	public Book() {

	}

	public Book(Integer bookId, String bookName, String bookAuthor, String bookPublication, String bookDesc,
			Integer bookCount, String bookPublicationYear) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublication = bookPublication;
		this.bookDesc = bookDesc;
		this.bookCount = bookCount;
		this.bookPublicationYear = bookPublicationYear;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublication() {
		return bookPublication;
	}

	public void setBookPublication(String bookPublication) {
		this.bookPublication = bookPublication;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public String getBookPublicationYear() {
		return bookPublicationYear;
	}

	public void setBookPublicationYear(String bookPublicationYear) {
		this.bookPublicationYear = bookPublicationYear;
	}

	public Book(int bookId, String bookName, String bookAuthor, String bookPublication, String bookDesc, int bookCount,
			String bookPublicationYear) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublication = bookPublication;
		this.bookDesc = bookDesc;
		this.bookCount = bookCount;
		this.bookPublicationYear = bookPublicationYear;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPublication="
				+ bookPublication + ", bookDesc=" + bookDesc + ", bookCount=" + bookCount + ", bookPublicationYear="
				+ bookPublicationYear + "]";
	}

	public Book orElseThrow(Object object) {
		return null;
	}

}
