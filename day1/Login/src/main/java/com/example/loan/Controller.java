package com.example.loan;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {
       
	
	@RequestMapping("/home")
	public ModelAndView home() {
		
		ModelAndView mv  = new ModelAndView();
		mv.setViewName("HomePage");
		return mv;	
	}
	@RequestMapping("/existingCustomer")
	public ModelAndView login() {
		
		ModelAndView mv  = new ModelAndView();
		mv.setViewName("Login");
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView authenticate(Login log) {
		ModelAndView mv  = new ModelAndView();
		String x = log.getUsername();
		String y = log.getPassword();
		mv.addObject("sai",x);
		mv.addObject("siri", y);
		mv.setViewName("hai");
		return mv;
		
	}
	
}
