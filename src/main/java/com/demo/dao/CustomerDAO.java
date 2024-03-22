package com.demo.dao;

import java.util.List;

import com.demo.entity.Customer;

public interface CustomerDAO {
	List<Customer> showCustomer();
	
	int addCustomer(Customer c);
	
	int updateCustomer(Customer c);
	
	Customer getCustomerById(int custId);
}
