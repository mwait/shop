package com.wait.dao;


import org.springframework.stereotype.Repository;

import com.wait.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mc on 2016-02-21.
 */

public interface ProductDao {
    void editProduct(Product product);
    void addProduct(Product product);
    Product getProductById(String id);
    List<Product> getAllProduct();
    void deleteProduct(String id);
}
