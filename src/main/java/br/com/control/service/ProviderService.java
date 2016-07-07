package br.com.control.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.control.model.Provider;

@Service
public interface ProviderService {

	Provider findById(int id);
    
    void save(Provider provider);
     
    void update(Provider provider);

    void delete(int id);
     
    List<Provider> findAll();
}
