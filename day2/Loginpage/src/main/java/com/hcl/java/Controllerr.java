package com.hcl.java;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RestController
@RequestMapping("/")
public class Controllerr {
	@Autowired
	public LoginRepository loginRepository;
	@Autowired
	public StudentRepository studentRepository;
	@RequestMapping(value="/")
	public ModelAndView sai () {
		ModelAndView mv = new ModelAndView();
//		Login login = new Login();
//		mv.addObject("login", login);
		mv.addObject(new Login());
		mv.setViewName("Login");
		return mv;
	}
	@RequestMapping(value="/authentication")
	public ModelAndView loginAuthentication(@ModelAttribute("login")Login login) {
		String x = login.getUsername();
		String y = login.getPassword(); 
		ModelAndView mv = new ModelAndView();
		try {
		List<Login> log1 = loginRepository.findByUsername(x);
		Login log = log1.get(0);
		String a = log.getUsername();
		String b = log.getPassword();
		if( x.equals(a)&& y.equals(b) ) {
			mv.addObject("sai", "sucess");
			mv.addObject("username", a);
			mv.addObject(new Student());
		mv.setViewName("sucess");
		}
		}catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			mv.addObject(new Login());
			int a = 404;
			mv.addObject("sai", a);
			mv.setViewName("Login");
		}
		return mv;
	}
	@RequestMapping("/sairegister")
	public ModelAndView Registerpage() {
		ModelAndView mv  = new ModelAndView();
		//Login log = new Login();
		mv.addObject(new Login());
		mv.setViewName("registeruser");
		return mv;
	}
	
	@RequestMapping("/registerCredentials")
	public ModelAndView Register(@ModelAttribute("login") Login login) {
		ModelAndView mv  = new ModelAndView();
		String user = login.getUsername();
		String pwd = login.getPassword();
		Login log = new Login();
		log.setUsername(user);
		log.setPassword(pwd);
		loginRepository.save(log);
		mv.addObject(new Login());
		mv.setViewName("Login");
		return mv;
		
	}
	@RequestMapping("/studentdetails")
	public ModelAndView SaveStudentDetails(@ModelAttribute("student") Student student) {
		ModelAndView mv  = new ModelAndView();
		studentRepository.save(student);
		mv.setViewName("hai");
		return mv;
		
	}
	@RequestMapping("/ShowAllStudents")
	public ModelAndView studentsList() {
		ModelAndView mv  = new ModelAndView();
		List<Student> lst=(List<Student>) studentRepository.findAll();
		mv.addObject("sai", lst);
		mv.setViewName("StudentsList");
		return mv;
		
	}
	@RequestMapping("/delete/{stdid}")
	public ModelAndView DeleteStudent(@PathVariable int stdid) {
		ModelAndView mv  = new ModelAndView();
		studentRepository.deleteById(stdid);
		List<Student> lst=(List<Student>) studentRepository.findAll();
		mv.addObject("sai", lst);
		mv.setViewName("StudentsList");
		return mv;	
	}
	@RequestMapping("/search")
	public ModelAndView SearchStudent(@RequestParam("stdid") int stdid) {
		ModelAndView mv  = new ModelAndView();
		List<Student> lst = studentRepository.findByStdid(stdid);
		mv.addObject("sai", lst);
		mv.setViewName("StudentsList");
		return mv;
	}
	
}
