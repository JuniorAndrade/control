package br.com.control.dao;

import java.util.List;

import br.com.control.model.Provider;

public interface ProviderDao {
	
	Provider findById(int id);
    
    void save(Provider provider);
     
    void delete(int id);
     
    List<Provider> findAll();
	
}
