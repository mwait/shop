package com.wait.dao.impl;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wait.dao.ProductDao;
import com.wait.model.Product;

import java.util.List;

/**
 * Created by mc on 2016-02-21.
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

    @Autowired
    private SessionFactory sessionFactory;

    
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();
        return product;
    }

    public List<Product> getProductList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> products = query.list();
       session.flush();
        return products;
    }

    public void deleteProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();

    }
}
