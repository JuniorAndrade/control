package br.com.control.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.control.model.UserProfile;

@Repository
public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
