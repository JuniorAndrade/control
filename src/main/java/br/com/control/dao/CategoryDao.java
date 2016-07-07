package br.com.control.dao;

import java.util.List;

import br.com.control.model.Category;

public interface CategoryDao {

	Category findById(int id);
     
    void save(Category category);
     
    void delete(int id);
     
    List<Category> findAll();
	
}
