package com.wait.dao;


import org.springframework.stereotype.Repository;

import com.wait.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mc on 2016-02-21.
 */

public interface ProductDao {
	List<Product> getProductList();
	Product getProductById(int id);
	void addProduct(Product product);
	void editProduct(Product product);
	void deleteProduct(Product product);
}
