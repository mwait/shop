package com.wait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wait.model.Customer;
import com.wait.service.CustomerService;

@Controller
@RequestMapping("/customer/cart")
public class CartController {

	@Autowired
	CustomerService customerService;
	@RequestMapping
	public String getCart(@AuthenticationPrincipal User activeUser){
		
		Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
		int cartId = customer.getCart().getCartId();
		
		return "redirect:/customer/cart/"+cartId;
	}
	
	@RequestMapping ("/{cartId}")
	public String getCartRedirect(@RequestParam("cartId") int cartId, Model model){
		model.addAttribute("cartId", cartId);
		return "cart";
	}
}
