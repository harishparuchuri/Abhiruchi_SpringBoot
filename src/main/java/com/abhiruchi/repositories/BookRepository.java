package com.abhiruchi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abhiruchi.model.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Book getByBookId(Long bookId);
}
