package com.demo.bookservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bookservice.model.Book;
import com.demo.bookservice.persistence.BookRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
       
    	List<Book> books = new ArrayList<Book>();
        bookRepository.findAll().forEach(books::add);
        
        return books;
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseGet(Book::new);
    	
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(String id, Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(new Long(id));
    }

}
