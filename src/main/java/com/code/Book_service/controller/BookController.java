package com.code.Book_service.controller;

import com.code.Book_service.model.Book;
import com.code.Book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book newBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable String id){
        Optional<Book> book = bookService.getBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable String id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.deleteBookById(id));
    }

    @GetMapping("/getBooksByAuthorId/{id}")
    public ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByAuthorId(id));
    }
}
