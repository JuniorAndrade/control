package br.com.control.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.control.model.Purchase;

@Service
public interface PurchaseService {

	Purchase findById(int id);
    
    void save(Purchase purchase);
    
    void update(Purchase purchase);

    void delete(int id);
     
    List<Purchase> findAll();
}
