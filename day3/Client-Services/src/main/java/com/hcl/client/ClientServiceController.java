package com.hcl.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ClientServiceController {
	@Autowired
	public ClientServiceRepository clientServiceRepository;
	@Autowired
	public ClientServiceBooksRepository clientServiceBooksRepository;
	@Autowired
	public StudentsRepository studentsRepository;
	@Autowired
	BooksHistoryRepository booksHistoryRepository;
	@RequestMapping("/login/{username}")
	public @ResponseBody Login login(@PathVariable("username") String username) {
		List<Login> lst = clientServiceRepository.findByUsername(username);
		Login log = lst.get(0);
		if(lst.size()!= 0) {
			return log;
		}
		else {
			Login logg = new Login();
			logg.setUsername("xx");
			logg.setPassword("yy");
			return logg;
		}
		
	}
	@RequestMapping("/register")
	public @ResponseBody String save(@RequestBody Login login){
		clientServiceRepository.save(login);
		return "sucess";
	}
	@RequestMapping("/availablebooks")
	public @ResponseBody List<Books> findall(){
		List<Books> lst=(List<Books>) clientServiceBooksRepository.findAll();
		return lst;
	}
	@RequestMapping("/AddBooks")
	public @ResponseBody String InsertBooks(@RequestBody Books books) {
		clientServiceBooksRepository.save(books);
		return "sucess";
	}
	@RequestMapping("/distributeBooks/{no}")
	public @ResponseBody String DistributeBooks(@PathVariable("no") int no) {
		List<Books> lst = clientServiceBooksRepository.findByNo(no);
		Books books  = lst.get(0);
		int z = books.getAvailablebooks();
		System.out.println("Hai sai kumar" +z);
		int availablebooks = z-1;
		clientServiceBooksRepository.UpdateBooks(no,availablebooks);
		return "sucess";
	}
	@RequestMapping("/stdid/{stdid}")
	public @ResponseBody String stdidcheck(@PathVariable("stdid") int stdid)  {
		List<Students> lst = studentsRepository.findByStdid(stdid);
		int size = lst.size();
		if(size != 0) {
			return "sucess";
		}else {
			return "failure";
		}
	}
	@RequestMapping("/StudentsRegister")
	public @ResponseBody String StudentRegister(@RequestBody Students students) {
		studentsRepository.save(students);
		return "Sucess";
	}
	@RequestMapping("/findbookbyid/{no}")
	public @ResponseBody Books findbookbyno(@PathVariable("no") int no) {
		List<Books> lst = clientServiceBooksRepository.findByNo(no);
		Books books = lst.get(0);
		return books;
	}
	
	@RequestMapping(value = "/BookHostoryy/{stdid}/{bookid}")
	public @ResponseBody Integer bookHistoryForGivingBook(@PathVariable("stdid") int stdid,@PathVariable("bookid") String bookid) {
		int z;
		System.out.println("1st micro service hitted");
		Optional<BooksHistory> lst =  booksHistoryRepository.findByBookidStdid(stdid, bookid);
		if(lst.isPresent()) {
			BooksHistory booksHistory = lst.get();
			 z = booksHistory.getNoofbooks();
		}else {
			 z = 0;
		}
		return z;
			
	}

	@RequestMapping("/booksHistory")
	public @ResponseBody String BooksHistory(@RequestBody BooksHistory bh) {
		booksHistoryRepository.save(bh);
		return "Sucess";
	}
	@RequestMapping("/BooksHistoryById/{stdid}")
	public @ResponseBody List<BooksHistory> HistoryOfbooksByStdid(@PathVariable("stdid") int stdid){
		List<BooksHistory> lst = booksHistoryRepository.findByStdid(stdid);
		return lst;
	}
	@RequestMapping(value = "/ReturnBooks/{stdid}")
	public @ResponseBody String ReturnBooks(@PathVariable("stdid") int stdid,@RequestBody List<String> list) {
         System.out.println("Accepted");
		for(int i=0;i<list.size();i++) {
			booksHistoryRepository.deleteOneByOne(stdid,list.get(i));
		}
		return "Sucess";
	}
	
}
