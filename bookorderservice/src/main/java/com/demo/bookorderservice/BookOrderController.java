package com.demo.bookorderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.micrometer.core.annotation.Timed;


@RestController
public class BookOrderController {
	
	@Autowired
	  private BookServiceProxy bookserviceProxy;
	 
	@Autowired
	  private CustomerServiceProxy customerserviceProxy;
	
	@Autowired
	  private EventProxy eventProxy;
	
	private static final Logger 
  	log = LoggerFactory.getLogger(BookOrderController.class);
	
	@Timed("mybookorder.responsetime")
	@GetMapping("/orderBook")
    public String getBook(
    		@RequestParam(name = "customerId") long customerId,
    		@RequestParam(name = "bookId") long bookId) {
		
		// get customer details
		CustomerBean customer = customerserviceProxy.getCustomer(customerId);
		log.info("\n----book info for " + customerId);
		log.info(customer.toString());
		
		// get book details
		BookBean book = bookserviceProxy.getBook(bookId);
		log.info("\n----book info for " + bookId);
		log.info(book.toString());
		
		if ( book.getName().equalsIgnoreCase("Matilda")) {
			// increment the book counter
			log.info(" ***** " + book.getName());
			RegistryConfig.bookOrderApiCounter.increment();
		}
		
		// get event details
		eventProxy.getEvents();
		
		return " Book order ** " + book.getName() + " for "+ customer.getFirstName() + " " + customer.getLastName() + "  completed";
        
    }

}
