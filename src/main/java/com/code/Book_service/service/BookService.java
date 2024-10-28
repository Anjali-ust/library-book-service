package com.code.Book_service.service;

import com.code.Book_service.model.Book;
import com.code.Book_service.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public Book addBook(Book book){
        Book newBook = bookRepo.save(book);
        return newBook;
    }
    public List<Book> getAllBooks()
    {
        List<Book> books = bookRepo.findAll();
        return books;
    }
    public Optional<Book> getBookById(String bookId){
        Optional<Book> book = bookRepo.findByBookId(bookId) ;
        return book;
    }
    public String deleteBookById(String bookId){
//        Optional<Book> book = bookRepo.findByBookId(bookId);
//        if(book.isPresent())
//        {
//            bookRepo
//            return "Book deleted";
//        }
//        return "Book not found";
        bookRepo.deleteById(bookId);
        return "book deleted";
    }

    public List<Book> getBooksByAuthorId(String id){
        return bookRepo.findByBookAuthorId(id);
    }
}
