package com.abhiruchi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhiruchi.model.Book;
import com.abhiruchi.repositories.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book saveOrUpdateABook(Book book) {
        return bookRepository.save(book);
    }

    public Book findBookById(Long bookId) {
        return bookRepository.getByBookId(bookId);
    }

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
