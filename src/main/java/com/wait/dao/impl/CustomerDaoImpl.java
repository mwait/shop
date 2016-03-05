package com.wait.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wait.dao.CustomerDao;
import com.wait.model.Authorities;
import com.wait.model.Cart;
import com.wait.model.Customer;
import com.wait.model.Users;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	public void addCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		customer.getBillingAddress().setCustomer(customer);
		customer.getShippingAddress().setCustomer(customer);
		session.saveOrUpdate(customer);
		session.saveOrUpdate(customer.getBillingAddress());
		session.saveOrUpdate(customer.getShippingAddress());
		
		Users newUser = new Users();
		newUser.setUsername(customer.getUsername());
		newUser.setPassword(customer.getPassword());
		newUser.setEnabled(true);
		newUser.setCustomerId(customer.getCustomerId());
		
		Authorities authorities = new Authorities();
		authorities.setAuthority("ROLE_USER");
		authorities.setUsername(customer.getUsername());
		
		session.saveOrUpdate(newUser);
		session.saveOrUpdate(authorities);
		
		Cart newCart = new Cart();
		newCart.setCustomer(customer);
		customer.setCart(newCart);
		session.saveOrUpdate(newUser);
		session.saveOrUpdate(newCart);
	}

	public Customer getCustomerById(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, customerId);
		return customer;
	}

	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer");
		List<Customer> customerList = query.list();
		
		return customerList;
	}
	
	public Customer getCustomerByUsername (String username){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer where username=?");
		query.setString(0, username);
		return (Customer) query.uniqueResult();
	
	}
	
}
