package br.com.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.control.dao.SaleDao;
import br.com.control.model.Sale;

@Service("saleService")
@Transactional
public class SaleServiceImpl implements SaleService {

	@Autowired
	SaleDao dao;
	
	public Sale findById(int id) {
		return dao.findById(id);
	}

	public void save(Sale sale) {
		dao.save(sale);
	}

	public void update(Sale sale) {
		Sale entity = dao.findById(sale.getId());
		if (entity != null) {
			entity.setProduct(sale.getProduct());
			entity.setAmount(sale.getAmount());
			entity.setSale_value(sale.getSale_value());
		}
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public List<Sale> findAll() {
		return dao.findAll();
	}
}
