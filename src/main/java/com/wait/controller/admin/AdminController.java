package com.wait.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wait.model.Product;
import com.wait.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductService productService;
	
	@RequestMapping
	public String adminPage(){
		return "admin";
	}
	
	@RequestMapping(value="/productInventory")
	public String productInventory(Model model) {
		List<Product> producsts = productService.getProductList();
		model.addAttribute("products", producsts);
		return "productInventory";
	}
	
	@RequestMapping(value="/customer")
	public String customerManagement(Model model) {
		//to add some customer service
		return "customerManagement";
	}
	
}
