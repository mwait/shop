package com.wait.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wait.dao.CartDao;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mc on 2016-02-27.
 */
@Controller
@RequestMapping("/cart")
public class CartItemController {

    @Autowired
    CartDao cartDao;

    @RequestMapping("/")
    public String get (HttpServletRequest request) {
        return "redirect:/cart/"+request.getSession(true).getId();
    }

    @RequestMapping(value="/{cartId}", method = RequestMethod.GET)
    public String getCart(@PathVariable (value = "cartId") String cartId, Model model) {
        model.addAttribute("cartId", cartId);
        //for testing
        model.addAttribute("cartIdItems",cartDao.read(cartId));
        return "cart";
    }

}
