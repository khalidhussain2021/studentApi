package com.hussainIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.hussainIT.model.Book;
import com.hussainIT.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book, @RequestParam Long categoryId) {
	    Book createdBook = bookService.addBook(book, categoryId);
	    return ResponseEntity.ok(createdBook);
	}
	
    // Retrieve all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Retrieve books by author
    @GetMapping("/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.getBooksByAuthor(author);
    }

    // Retrieve books by category
    @GetMapping("/category/{categoryName}")
    public List<Book> getBooksByCategory(@PathVariable String categoryName) {
        return bookService.getBooksByCategory(categoryName);
    }

    // Update a book
    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable Long bookId, @RequestBody Book bookDetails) {
        return bookService.updateBook(bookId, bookDetails);
    }

    // Delete a book
    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
    }
}
