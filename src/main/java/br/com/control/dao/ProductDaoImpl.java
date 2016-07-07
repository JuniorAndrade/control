package br.com.control.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.control.model.Product;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {

	static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

	public Product findById(int id) {
		logger.info("Buscando produto: {}", id);
		Product product = getByKey(id);
		return product;
	}

	public void save(Product product) {
		persist(product);
	}

	public void delete(int id) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Product product = (Product) criteria.uniqueResult();
        delete(product);	
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Product> product = (List<Product>) criteria.list();
        	
		return product;
	}
}
