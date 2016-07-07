package br.com.control.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.control.model.Sale;

@Service
public interface SaleService {

	Sale findById(int id);
    
    void save(Sale sale);

    void update(Sale sale);
     
    void delete(int id);
     
    List<Sale> findAll();
	
}
