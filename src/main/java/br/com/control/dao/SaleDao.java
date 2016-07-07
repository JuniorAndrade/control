package br.com.control.dao;

import java.util.List;

import br.com.control.model.Sale;

public interface SaleDao {
	
	Sale findById(int id);
    
    void save(Sale sale);

    void delete(int id);
     
    List<Sale> findAll();
}
