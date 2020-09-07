package com.demo.bookservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.bookservice.model.Book;
import com.demo.bookservice.persistence.BookRepository;


@SpringBootApplication
public class BookserviceApplication implements CommandLineRunner {

	private static final Logger 
  	log = LoggerFactory.getLogger(BookserviceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookserviceApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	      log.info("\n----Begin logging jpatest demo----");
	  }
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.deleteAll();
			
			
			repository.save(new Book("Blink", new Double(6), 7));
			repository.save(new Book("Mice and Men", new Double(20), 5));
			repository.save(new Book("Handmaid's Tales", new Double(15),4));
			repository.save(new Book("The Painting", new Double(10), 4));
			repository.save(new Book("Matilda", new Double(11), 5));
			 
			// fetch all books
			log.info("Book found with findAll():");
			log.info("-------------------------------");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			log.info("");

			// fetch an individual book by ID
			repository.findById(1L)
				.ifPresent(customer -> {
					log.info("Customer found with findById(1L):");
					log.info("--------------------------------");
					log.info(customer.toString());
					log.info("");
				});

			
		};
	}
}
