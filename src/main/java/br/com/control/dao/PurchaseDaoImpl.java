package br.com.control.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.control.model.Purchase;

@Repository
public class PurchaseDaoImpl extends AbstractDao<Integer, Purchase> implements PurchaseDao {

	static final Logger logger = LoggerFactory.getLogger(PurchaseDaoImpl.class);

	public Purchase findById(int id) {
		logger.info("Buscando compra: {}", id);
		Purchase purchase = getByKey(id);
		return purchase;		
	}

	public void save(Purchase purchase) {
		persist(purchase);
	}

	public void delete(int id) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Purchase purchase = (Purchase) criteria.uniqueResult();
        delete(purchase);
        logger.info("Removendo compra: {}", id);
	}

	@SuppressWarnings("unchecked")
	public List<Purchase> findAll() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("product"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Purchase> purchase = (List<Purchase>) criteria.list();

		return purchase;
	}
}
