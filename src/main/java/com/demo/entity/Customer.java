package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hello")
public class Customer {
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + "]";
	}

	@Id
	private int custId;
	
	private String name;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
