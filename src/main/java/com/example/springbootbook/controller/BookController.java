package com.example.springbootbook.controller;

import com.example.springbootbook.model.Book;
import com.example.springbootbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// use @RestController annotation to describe book controller
// as a rest controller class
// @RestController specifies the class as a restful web service,
// so book controller class will have accessible endpoints with the rest api.
@RestController
// @RequestMapping to add pre path for all methods on book controller.
@RequestMapping("api/book") //pre-path
public class BookController {
    @Autowired
    private BookService bookService;
    // now can create methods our api methods
    // define every method with response encapsulation.
    // Response entity is encapsulation that contains http header,
    // http status and response body for our save book method.

    // method to save a book
    // use post request
    @PostMapping //api/book
    // did not state anything, so it would be just pre-path:

    // reach the form data with request with @RequestBody annotation
    public ResponseEntity<?> saveBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.OK);
    }

    // method to delete a book by id
    // use delete mapping
    @DeleteMapping("{bookId}")//api/book/{bookId}
    // can send the book id as a path variable
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId){
        // call the delete method from book service
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // method to get all books
    // get request
    @GetMapping //api/book
    // api paths can be the same for different kinds of request mapping.
    // but if we use the same mapping type and same path, then it will be a problem
    public ResponseEntity<?> getAllBooks(){
        // return the body with ok http status
        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
    }
}

