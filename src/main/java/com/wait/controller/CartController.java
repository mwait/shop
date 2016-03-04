package com.wait.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.wait.dao.CartDao;
import com.wait.dao.ProductDao;
import com.wait.model.Cart;
import com.wait.model.CartItem;
import com.wait.model.Product;
import com.wait.model.TestowyModel;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mc on 2016-02-27.
 */
@Controller
@RequestMapping("/rest/cart")
public class CartController {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value="/test/{cartId}", method = RequestMethod.GET)
    public @ResponseBody  TestowyModel test (@PathVariable(value="cartId") String cardId){
       // Cart cart = cartDao.read(cardId);
        //return "OK"+" "+cart.getCartId()+" "+cart.getGrandTotal();
        //Product product = new Product(); product.setProductCategory("test"); product.setProductName("Test");
        TestowyModel tm = new TestowyModel(); tm.setAge(4); tm.setName("mc"); tm.setSurname("you");
        return tm;
    }

    @RequestMapping(value="/{cartId}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Cart read (@PathVariable(value="cartId") String cardId){
        Cart cart = cartDao.read(cardId);

        return cartDao.read(cardId);
    }

    @RequestMapping(value="/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value="cartId") String cartId, @RequestBody Cart cart) {
    cartDao.update(cartId, cart);
    }

    @RequestMapping(value="/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value="cartId") String cartId){
        cartDao.delete(cartId);
    }

    @RequestMapping(value="/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable (value="productId") String productId, HttpServletRequest request){
        String sessionId=request.getSession(true).getId();
        Cart cart = cartDao.read(sessionId);
        if(cart==null) {
            cart=cartDao.create(new Cart(sessionId));
        }

        Product product = productDao.getProductById(productId);
        if(product==null){
            throw new IllegalArgumentException(new Exception());
        }

        cart.addCartItem(new CartItem(product));
        cartDao.update(sessionId, cart);
    }

    @RequestMapping(value="/remove/{productId}", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value="productId") String productId, HttpServletRequest request){
        String sessionId=request.getSession(true).getId();
        Cart cart = cartDao.read(sessionId);
        if(cart==null) {
            cart=cartDao.create(new Cart(sessionId));
        }

        Product product = productDao.getProductById(productId);
        if(product==null){
            throw new IllegalArgumentException(new Exception());
        }

        cart.removeCartItem(new CartItem(product));
        cartDao.update(sessionId, cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify youf payload")
    public void handleClientErrors(Exception e){

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors(Exception e){

    }
}
