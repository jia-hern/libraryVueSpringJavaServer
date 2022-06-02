package com.example.springbootbook.service;

import com.example.springbootbook.model.Book;
import com.example.springbootbook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

// book service will keep business logic operations for the book
// use @Service to define that this class is a spring service class
@Service
public class BookServiceImpl implements BookService{
    // use autowired for dependency injection
    // can use autowired on properties, setters and constructors
    @Autowired
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @Override
    public Book saveBook(Book book) {
        // set createTime
        book.setCreateTime(LocalDateTime.now());
        // save the book
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        // use jpa deleteById method
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAllBooks() {
        // use jpa find all method
        return bookRepository.findAll();
    }
}
