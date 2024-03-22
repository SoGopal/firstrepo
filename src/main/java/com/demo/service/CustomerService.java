package com.demo.service;

import java.util.List;

import com.demo.entity.Customer;
import com.demo.exception.DuplicateCustomerIDException;

public interface CustomerService {
	
	List<Customer> showCustomer();
	
	int addCustomer(Customer c) throws DuplicateCustomerIDException;
	
	int updateCustomer(Customer c);

}
