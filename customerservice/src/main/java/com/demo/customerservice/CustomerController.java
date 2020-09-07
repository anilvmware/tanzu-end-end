package com.demo.customerservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomerController {
	
	@Autowired
    private CustomerService customerservice;

    @GetMapping("/customers")
    public List<Customer>  getAllCustomers() {
        List<Customer> allCustomers = (List<Customer>) customerservice.getAllCustomers();
		return  allCustomers;
    }

    @GetMapping("/getCustomer/{id}")
    public Optional<Customer> getCustomer(@PathVariable("id") Long customerId){
        return customerservice.findById(customerId);
    }
}