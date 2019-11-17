package com.hcl.user;

import org.aspectj.apache.bcel.util.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AccountController {
	@Autowired
	AccountRepository repository;
	@PostMapping("/add")
	public String addAccount(@RequestBody Account account) {
		repository.save(account);
		return "account added sucessfully";
	}
	

}
