package br.com.control.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.control.model.Category;

@Service
public interface CategoryService {
	
	Category findById(int id);
    
    void save(Category category);
     
    void update(Category category);

    void delete(int id);
     
    List<Category> findAll();
	
}
