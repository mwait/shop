package com.wait.dao;

import com.wait.model.Cart;

/**
 * Created by mc on 2016-02-27.
 */
public interface CartDao {
	Cart getCartById(int cartId);
	void update(Cart cart);

}
