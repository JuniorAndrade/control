package br.com.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.control.dao.CategoryDao;
import br.com.control.model.Category;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao dao;

	public Category findById(int id) {
		return dao.findById(id);
	}

	public void save(Category category) {
		dao.save(category);
	}

	public void update(Category category) {
		Category entity = dao.findById(category.getId());
		if (entity != null) {
			entity.setName(category.getName());
		}
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public List<Category> findAll() {
		return dao.findAll();
	}
}
