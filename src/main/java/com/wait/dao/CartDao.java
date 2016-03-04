package com.wait.dao;

import com.wait.model.Cart;

/**
 * Created by mc on 2016-02-27.
 */
public interface CartDao {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update (String cartId, Cart cart);
    void delete (String cartId);

}
