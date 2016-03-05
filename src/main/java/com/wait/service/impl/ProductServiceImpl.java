package com.wait.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wait.dao.ProductDao;
import com.wait.model.Product;
import com.wait.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	public List<Product> getProductList() {
		return productDao.getProductList();
	}

	public Product getProductById(int id) {
		return productDao.getProductById(id);
		
	}

	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	public void editProduct(Product product) {
		productDao.editProduct(product);
	}

	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);
	}

}
