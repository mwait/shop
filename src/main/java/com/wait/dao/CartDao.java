package com.wait.dao;

import java.io.IOException;

import com.wait.model.Cart;

/**
 * Created by mc on 2016-02-27.
 */
public interface CartDao {
	Cart getCartById(int cartId);
	void update(Cart cart);
	Cart validate(int cartId) throws IOException;

}
