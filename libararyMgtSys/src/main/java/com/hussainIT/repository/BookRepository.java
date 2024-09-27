package com.hussainIT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hussainIT.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
	List<Book> findByAuthor(String author);  // Custom query method
    List<Book> findByCategoryName(String categoryName);  // Custom query method
    boolean existsByIsbn(String isbn);  // ISBN validation
}
