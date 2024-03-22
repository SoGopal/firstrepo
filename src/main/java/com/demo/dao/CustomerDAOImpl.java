package com.demo.dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.demo.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Customer> showCustomer() {
		// TODO Auto-generated method stub
		System.out.println("DAO customer called");
		TypedQuery<Customer> emptqury=em.createQuery("select c from Customer c",Customer.class);
		List<Customer> custList=emptqury.getResultList();
		Iterator<Customer> c=custList.iterator();
		while(c.hasNext()) {
			System.out.println(c.next());
		}
		return custList;
	}
	@Override
	public int addCustomer(Customer c) {
		em.persist(c);
		return c.getCustId();
	}
	@Override
	public int updateCustomer(Customer c) {
		em.merge(c);
		return c.getCustId();
	}
	@Override
	public Customer getCustomerById(int custId) {
		
		return em.find(Customer.class,custId);
	}

}
