package br.com.control.dao;

import java.util.List;

import br.com.control.model.Purchase;

public interface PurchaseDao {
	
	Purchase findById(int id);
    
    void save(Purchase purchase);
     
    void delete(int id);
     
    List<Purchase> findAll();
	
}
