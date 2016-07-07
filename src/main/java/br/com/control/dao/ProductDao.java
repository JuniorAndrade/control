package br.com.control.dao;

import java.util.List;

import br.com.control.model.Product;

public interface ProductDao {

	Product findById(int id);
    
    void save(Product product);
     
    void delete(int id);
     
    List<Product> findAll();
}
