package com.demo.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Customer;
import com.demo.exception.DuplicateCustomerIDException;
import com.demo.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	CustomerService custService;
	
	@GetMapping(value ="/show",produces = "application/json")
	List<Customer> showCustomer(){
		System.out.println("Customer Controller");
		List<Customer> custList=custService.showCustomer();
		return custList;
	}
	
	@PostMapping(consumes = "application/json",produces = "application/json")
	ResponseEntity<Customer> addCustomer(@RequestBody Customer cust) throws DuplicateCustomerIDException{
		int custId=custService.addCustomer(cust);
		if(custId==0) {
			throw new DuplicateCustomerIDException("Customer with ID"+cust.getCustId()+" already Exists");
		}
		
		System.out.println("Customer ID in controller is "+custId);		
		return ResponseEntity.ok(cust);
		
	}

	
	
	@PutMapping(consumes = "application/json",produces = "application/json")
	ResponseEntity<Customer> updateCustomer(@RequestBody Customer cust){
		int custId=custService.updateCustomer(cust);
		System.out.println("Customer ID in controller is "+custId);		
		return ResponseEntity.status(200).build();
	}
}
