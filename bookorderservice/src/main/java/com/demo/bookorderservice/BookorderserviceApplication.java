package com.demo.bookorderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients("com.demo.bookorderservice")
public class BookorderserviceApplication implements CommandLineRunner {
	
	private static final Logger 
  	log = LoggerFactory.getLogger(BookorderserviceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookorderserviceApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	      log.info("\n----Begin logging bookorderservice app test----");
	}
	
	

}
