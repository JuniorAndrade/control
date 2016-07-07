package br.com.control.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.control.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao {

	static final Logger logger = LoggerFactory.getLogger(CategoryDaoImpl.class);

	public Category findById(int id) {
		logger.info("Buscando categoria: {}", id);
		Category category = getByKey(id);
		return category;
	}

	public void save(Category category) {
		persist(category);
	}

	public void delete(int id) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Category category = (Category) criteria.uniqueResult();
        delete(category);	
	}

	@SuppressWarnings("unchecked")
	public List<Category> findAll() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Category> category = (List<Category>) criteria.list();
        	
		return category;
	}
}
