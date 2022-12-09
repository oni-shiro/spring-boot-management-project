package com.sinchan.hibernateproject.payload;

public class BookDto {

	private Integer bookId;
	private String bookName;
	private String bookAuthor;
	private String bookPublication;
	private String bookDesc;
	private Integer bookCount;
	private String bookPublicationYear;

	public BookDto() {
		super();
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
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

}
