package com.wait.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = -2558457194052726235L;
	
	@Id
	@GeneratedValue
	private int customerId;
	
	@NotEmpty(message="The customer must not be null")
	private String customerName;
	
	@NotEmpty(message="The customer email must not be null.")
	private String customerEmail;
	private String customerPhone;
	@NotEmpty(message="The username must not be null")
	private String username;
	@NotEmpty(message="The password must not be null")
	private String password;
	
	private boolean enabled;
	
	@OneToOne 
	@JoinColumn(name="billingAddressId")
	private BillingAddress billingAddress;
	
	@OneToOne 
	@JoinColumn(name="shippingAddressId")
	private ShippingAddress shippingAddress;
	
	@OneToOne
	@JoinColumn(name="cartId")
	@JsonIgnore
	private Cart cart;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
	
	
}
