package com.code.Book_service.repo;

import com.code.Book_service.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends MongoRepository<Book,String> {
    List<Book> findByBookAuthorId(String id);

    Optional<Book> findByBookId(String bookId);
}
