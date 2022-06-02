package com.example.springbootbook.repository;

import com.example.springbootbook.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

// use UserRepository for notes
public interface BookRepository extends JpaRepository<Book, Long> {
}
