package com.example.springbootbook.service;

import com.example.springbootbook.model.Book;

import java.util.List;

public interface BookService {
    // BookServiceImpl will override these methods

    // method to save a new book / update existing book
    Book saveBook(Book book);

    // delete a book with an id
    void deleteBook(Long id);

    // method to find all books
    List<Book> findAllBooks();
}
