package br.com.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.control.dao.PurchaseDao;
import br.com.control.model.Purchase;

@Service("purchaseService")
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	PurchaseDao dao;
	
	public Purchase findById(int id) {
		return dao.findById(id);
	}

	public void save(Purchase purchase) {
		dao.save(purchase);
	}

	public void update(Purchase purchase) {
		Purchase entity = dao.findById(purchase.getId());
		if (entity != null) {
			entity.setProduct(purchase.getProduct());
			entity.setAmount(purchase.getAmount());
			entity.setAmount_paid(purchase.getAmount_paid());
		}
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public List<Purchase> findAll() {
		return dao.findAll();
	}
}
