package br.com.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.control.dao.ProductDao;
import br.com.control.model.Product;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;
	
	public Product findById(int id) {
		return dao.findById(id);
	}

	public void save(Product product) {
		dao.save(product);
	}

	public void update(Product product) {
		Product entity = dao.findById(product.getId());
		if (entity != null) {
			entity.setName(product.getName());
			entity.setPrice(product.getPrice());
			entity.setAmount(product.getAmount());
		}
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public List<Product> findAll() {
		return dao.findAll();
	}
}
