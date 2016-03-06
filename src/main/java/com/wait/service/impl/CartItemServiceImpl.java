package com.wait.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wait.dao.CartItemDao;
import com.wait.model.Cart;
import com.wait.model.CartItem;
import com.wait.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{

	@Autowired
	CartItemDao cartItemDao;

	public void addCartItem(CartItem cartItem) {
		cartItemDao.addCartItem(cartItem);
	}

	public void removeCartItem(CartItem cartItem) {
		cartItemDao.removeCartItem(cartItem);
	}

	public void removeAllCartItems(Cart cart) {
		cartItemDao.removeAllCartItems(cart);
		
	}

	public CartItem getCartItemByProductId(int productId) {
		return cartItemDao.getCartItemByProductId(productId);
	}

}
