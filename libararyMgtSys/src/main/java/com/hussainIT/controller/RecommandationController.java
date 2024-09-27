package com.hussainIT.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hussainIT.model.Book;
import com.hussainIT.service.BookService;

@RestController
@RequestMapping("/api/recommendations")
public class RecommandationController {
	
	private BookService bookService;
	
	@GetMapping("/category/{categoryName}")
    public List<Book> recommendBooks(@PathVariable String categoryName) {
        return bookService.recommendBooksByCategory(categoryName);
    }
}
