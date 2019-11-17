package com.hcl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryImpl {
	@Autowired
	Repository repository;
	public User getUser(String user) {
		
		return repository.getUserByuser(user); 
		
	}
	

}
