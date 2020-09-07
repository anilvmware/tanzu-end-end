package com.demo.bookservice.persistence;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.bookservice.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
