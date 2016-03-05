package com.wait.dao;

import java.util.List;

import com.wait.model.Customer;

public interface CustomerDao {

	void addCustomer(Customer customer);
	Customer getCustomerById (int customerId);
	List<Customer> getAllCustomers();
	Customer getCustomerByUsername (String name);
}
