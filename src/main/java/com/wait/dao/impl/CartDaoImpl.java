package com.wait.dao.impl;



import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wait.dao.CartDao;
import com.wait.model.Cart;

/**
 * Created by mc on 2016-02-27.
 */
@Repository
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;
	public Cart getCartById(int cartId) {
		Session session = sessionFactory.getCurrentSession();
		return (Cart) session.get(Cart.class, cartId);
	}

	public void update(Cart cart) {

		int cartId = cart.getCartId();
		//todo later
	}
	
	public Cart validate(int cartId) throws IOException {
		Cart cart = getCartById(cartId);
		if(cart==null||cart.getCartItem().size()==0){
			throw new IOException(cartId+" ");
		}
		update(cart);
		return cart;
		
	}


}
