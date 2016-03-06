package com.wait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wait.model.Cart;
import com.wait.model.CartItem;
import com.wait.model.Customer;
import com.wait.model.Product;
import com.wait.service.CartItemService;
import com.wait.service.CartService;
import com.wait.service.CustomerService;
import com.wait.service.ProductService;

@Controller
@RequestMapping("/rest/cart")
public class CartResources {

	@Autowired
	private CartService cartService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CartItemService cartItemService;
	
	
	@RequestMapping("/{cartId}")
	public @ResponseBody Cart getCartById(@PathVariable("cartId") int cartId){
		return cartService.getCartById(cartId);
	}
	
	@RequestMapping(value="/add/{productId}", method= RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable("productId") int productId, @AuthenticationPrincipal User activeUser){
		Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
		Cart cart = customer.getCart();
		Product product = productService.getProductById(productId);
		List<CartItem> cartItems = cart.getCartItem();
		
		for(int i=0; i<cartItems.size(); i++){
			if(product.getProductId()==cartItems.get(i).getProduct().getProductId()){
				CartItem cartItem=cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity()+1);
				cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
				cartItemService.addCartItem(cartItem);
				return;
			}
		}
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
	}
	
	@RequestMapping(value ="/remove/{productId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable("productId") int productId)
	{
		CartItem cartItem = cartItemService.getCartItemByProductId(productId);
		cartItemService.removeCartItem(cartItem);
	}
	
	@RequestMapping(value="/{cartId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void clearCart(@PathVariable("cartId") int cartId){
		Cart cart = cartService.getCartById(cartId);
		cartItemService.removeAllCartItems(cart);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Illegal request, please verify you payload")
	public void handleClientErrors(Exception e) {
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Internal Server Error")
	public void handleServerErrors(Exception e) {
	}
}
