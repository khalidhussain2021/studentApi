package com.hussainIT.service;

import java.util.List;

import com.hussainIT.model.Book;

public interface BookService {
	public Book addBook(Book book,Long categoryId);
	public Book addBook(Book book);
	public List<Book> getAllBooks();
	public List<Book> getBooksByAuthor(String author);
	public List<Book> getBooksByCategory(String categoryName);
	public Book updateBook(Long bookId, Book bookDetails);
	public void deleteBook(Long bookId);
	// book history based on the book and author
	public List<Book> recommendBooksByCategory(String categoryName);
}
