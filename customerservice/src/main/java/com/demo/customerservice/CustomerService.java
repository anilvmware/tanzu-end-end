package com.demo.customerservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    
    public Optional<Customer> findById(long id) {
    	
    	 return customerRepository.findById(id);
    }

    
    public List<Customer> getAllCustomers() {
       
    	List<Customer> customers = new ArrayList<Customer>();
        customerRepository.findAll().forEach(customers::add);
        
        return customers;
    }

}
