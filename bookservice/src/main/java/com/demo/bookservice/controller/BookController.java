package com.demo.bookservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bookservice.model.Book;
import com.demo.bookservice.service.BookService;



@RestController
public class BookController {
	
	@Autowired
    private BookService bookservice;

    @GetMapping("/books")
    public List<Book>  getAllBooks() {
        List<Book> allBooks = (List<Book>) bookservice.getAllBooks();
		return  allBooks;
    }

    @GetMapping("/getBook/{id}")
    public Book getBook(@PathVariable("id") Long bookId){
        return bookservice.getBook(bookId);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        bookservice.addBook(book);
    }

    @PutMapping("/books/{id}")
    public void updateBook(@PathVariable String bookId, @RequestBody Book book) {
        bookservice.updateBook(bookId, book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable String bookId) {
        bookservice.deleteBook(bookId);
    }
}
