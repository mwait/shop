package com.wait.service;

import java.util.List;

import com.wait.model.Customer;

public interface CustomerService {

	
	void addCustomer(Customer customer);
	Customer getCustomerById (int customerId);
	List<Customer> getAllCustomers();
	Customer getCustomerByUsername (String name);
}
