package com.wait.service;

import com.wait.model.Cart;

public interface CartService {

	Cart getCartById(int cartId);
	void update(Cart cart);
}
