package br.com.control.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.control.model.Sale;

@Repository("saleDao")
public class SaleDaoImpl extends AbstractDao<Integer, Sale> implements SaleDao {

	static final Logger logger = LoggerFactory.getLogger(SaleDaoImpl.class);

	public Sale findById(int id) {
		logger.info("Buscando venda: {}", id);
		Sale sale = getByKey(id);
		return sale;		
	}

	public void save(Sale sale) {
		persist(sale);
	}

	public void delete(int id) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Sale sale = (Sale) criteria.uniqueResult();
        delete(sale);
        logger.info("Excluíndo venda: {}", id);
	}

	@SuppressWarnings("unchecked")
	public List<Sale> findAll() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("product"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Sale> sale = (List<Sale>) criteria.list();

		return sale;
	}
}
