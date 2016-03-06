package com.wait.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wait.dao.CustomerOrderDao;
import com.wait.model.Cart;
import com.wait.model.CartItem;
import com.wait.model.CustomerOrder;
import com.wait.service.CartService;
import com.wait.service.CustomerOrderService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private CustomerOrderDao customerOrderDao;
	@Autowired
	private CartService cartService;
	
	public void addCustomerOrder(CustomerOrder customerOrder) {
		
		customerOrderDao.addCustomerOrder(customerOrder);
	}

	public double getCustomerOrderGrandTotal(int cartId) {
		double grandTotal=0;
		Cart cart = cartService.getCartById(cartId);
		List<CartItem> cartItems = cart.getCartItem();
		for(CartItem item:cartItems){
			grandTotal+=item.getTotalPrice();
		}
		return grandTotal;
	}

}
