package com.wait.service;

import com.wait.model.Cart;
import com.wait.model.CartItem;

public interface CartItemService {

	void addCartItem(CartItem cartItem);
	void removeCartItem(CartItem cartItem);
	void removeAllCartItems(Cart cart);
	CartItem getCartItemByProductId(int productId);
}
