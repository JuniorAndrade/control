package br.com.control.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.control.model.UserProfile;

@Service("userProfileService")
public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
