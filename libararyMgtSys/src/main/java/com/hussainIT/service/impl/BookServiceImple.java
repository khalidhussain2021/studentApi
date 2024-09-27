package com.hussainIT.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hussainIT.model.Book;
import com.hussainIT.model.Category;
import com.hussainIT.repository.BookRepository;
import com.hussainIT.repository.CategoryRepository;
import com.hussainIT.service.BookService;

@Service
public class BookServiceImple implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public Book addBook(Book book,Long categoryId) {
		if (bookRepository.existsByIsbn(book.getIsbn())) {
            throw new IllegalArgumentException("ISBN must be unique");
        }
		Category category = categoryRepository.findById(categoryId)
		        .orElseThrow(() -> new RuntimeException("Category not found"));
		    book.setCategory(category);
		   
        return bookRepository.save(book);
	}
	
	public Book addBook(Book book) {
        if (bookRepository.existsByIsbn(book.getIsbn())) {
            throw new IllegalArgumentException("ISBN must be unique");
        }
        return bookRepository.save(book);
    }

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	@Override
	public List<Book> getBooksByCategory(String categoryName) {
		   return bookRepository.findByCategoryName(categoryName);
	}

	@Override
	public Book updateBook(Long bookId, Book bookDetails) {
		Book book = bookRepository.findById(bookId)
	            .orElseThrow(() -> new IllegalArgumentException("Book not found"));
	        book.setTitle(bookDetails.getTitle());
	        book.setAuthor(bookDetails.getAuthor());
	        book.setIsbn(bookDetails.getIsbn());
	        book.setPublicationDate(bookDetails.getPublicationDate());
	        book.setCategory(bookDetails.getCategory());
	        return bookRepository.save(book);
	}

	@Override
	public void deleteBook(Long bookId) {
		bookRepository.deleteById(bookId);
	}
   // history book and author
	@Override
	public List<Book> recommendBooksByCategory(String categoryName) {
		return bookRepository.findByCategoryName(categoryName);
	}

}
