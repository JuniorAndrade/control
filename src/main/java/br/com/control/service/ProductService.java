package br.com.control.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.control.model.Product;

@Service
public interface ProductService {
	
	Product findById(int id);
    
    void save(Product product);

    void update(Product product);
     
    void delete(int id);
     
    List<Product> findAll();
}
