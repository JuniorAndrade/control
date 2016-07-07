package br.com.control.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.control.model.Provider;

@Repository("providerDao")
public class ProviderDaoImpl extends AbstractDao<Integer, Provider> implements ProviderDao{

	static final Logger logger = LoggerFactory.getLogger(ProviderDaoImpl.class);

	public Provider findById(int id) {
		logger.info("Buscando fornecedor: {}", id);
		Provider provider = getByKey(id);
		return provider;		
	}

	public void save(Provider provider) {
		persist(provider);
	}

	public void delete(int id) {
		logger.info("Excluíndo fornecedor: {}", id);
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Provider provider = (Provider) criteria.uniqueResult();
        delete(provider);
	}

	@SuppressWarnings("unchecked")
	public List<Provider> findAll() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Provider> providers = (List<Provider>) criteria.list();

		return providers;
	}
}
