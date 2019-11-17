package com.hcl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
@RequestMapping("/")
public class UserController {
	@Autowired
	UserRepositoryImpl userRepositoyImpl;
	@RequestMapping("/{user}/get")
public User getUser(@PathVariable("user") String user) {
	return userRepositoyImpl.getUser(user);
		
	}
}
