package br.com.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.control.dao.ProviderDao;
import br.com.control.model.Provider;

@Service("providerService")
@Transactional
public class ProviderServiceImpl implements ProviderService {

	@Autowired
	ProviderDao dao;

	public Provider findById(int id) {
		return dao.findById(id);
	}

	public void save(Provider provider) {
		dao.save(provider);
	}

	public void update(Provider provider) {
		Provider entity = dao.findById(provider.getId());
		if (entity != null) {
			entity.setName(provider.getName());
			entity.setPrice(provider.getPrice());
			entity.setProducts(provider.getProducts());
			entity.setAmount(provider.getAmount());
		}
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public List<Provider> findAll() {
		return dao.findAll();
	}	
}
