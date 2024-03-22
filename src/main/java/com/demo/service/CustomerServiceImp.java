package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.CustomerDAO;
import com.demo.entity.Customer;
import com.demo.exception.DuplicateCustomerIDException;

@Service("service")
public class CustomerServiceImp implements CustomerService {

	@Autowired
	CustomerDAO custDao;

	@Override
	public List<Customer> showCustomer() {
		// TODO Auto-generated method stub
		System.out.println("Service layer Customer called");
		return custDao.showCustomer();
	}
	@Transactional
	@Override
	public int addCustomer(Customer c) throws DuplicateCustomerIDException {
		Customer cust=custDao.getCustomerById(c.getCustId());
		if(c!=null) {
			if(c.getCustId()==cust.getCustId()) {
				throw new DuplicateCustomerIDException("Customer with ID"+c.getCustId()+" already Exists");
			}
		}
		int custId=custDao.addCustomer(c);
		return custId;
	}
	@Transactional
	@Override
	public int updateCustomer(Customer c) {
		int custId=custDao.updateCustomer(c);
		return custId;
	}

}
