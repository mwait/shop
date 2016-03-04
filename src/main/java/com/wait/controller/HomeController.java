package com.wait.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wait.dao.ProductDao;
import com.wait.model.Product;

import java.util.List;

/**
 * Created by mc on 2016-02-21.
 * 06/ 02 minuta 6.50
 */

@Controller
public class HomeController {


    @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> products = productDao.getAllProduct();

        model.addAttribute("products",products);
        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model){
        Product product = productDao.getProductById(productId);
        model.addAttribute(product);
        return "viewProduct";
    }


}
