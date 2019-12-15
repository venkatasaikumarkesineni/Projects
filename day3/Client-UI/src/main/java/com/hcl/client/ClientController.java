package com.hcl.client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ClientController {
	@Autowired
	ClientRepository clientRepository;
	private Date date;

	@RequestMapping("/")
	public ModelAndView loginnpage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject(new Login());
		mv.setViewName("Login");
		return mv;
	}

	@RequestMapping("/authenticate")
	public ModelAndView login(@ModelAttribute("login") Login login) {
		ModelAndView mv = new ModelAndView();
		String res = clientRepository.login(login);

		ZoneId zoneId = ZoneId.systemDefault();
		LocalTime localtime = LocalTime.now(zoneId);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");
		String session = localtime.format(formatter);
		
		String user = login.getUsername();
		if (res.equals("sucess")) {
			mv.addObject("sai", user);
			mv.addObject("siri", session);
			mv.setViewName("HomePage");
		} else {
			mv.setViewName("failure");
		}
		return mv;
	}

	@RequestMapping("/register")
	public ModelAndView registercredentials() {
		ModelAndView mv = new ModelAndView();
		mv.addObject(new Login());
		mv.setViewName("Register");
		return mv;
	}

	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute("login") Login login) {
		ModelAndView mv = new ModelAndView();
		ResponseEntity<String> res = clientRepository.save(login);
		String result = res.getBody();
		if (result.equals("sucess")) {
			mv.addObject(new Login());
			mv.setViewName("Login");
		} else {
			mv.setViewName("RegisterCredentials");
		}
		return mv;
	}

	@RequestMapping("/search")
	public ModelAndView stdidcheck(@RequestParam("stdid") int stdid, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		ResponseEntity<String> res = clientRepository.stdid(stdid);
		String result = res.getBody();
		if (result.equals("sucess")) {
			List<Books> lst = clientRepository.AvailableBooks();

			HttpSession sessionn = request.getSession(true);
			sessionn.setAttribute("stdid", stdid);

			mv.addObject("list", lst);
			mv.setViewName("AvailableBooks");

		} else {
			mv.addObject("siri", 404);
			mv.setViewName("HomePage");
		}
		return mv;
	}

	@RequestMapping("/DistributeBooks")
	public ModelAndView DistributeBooks() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("StudentSearch");
		return mv;
	}
	@RequestMapping("/AvailableBooks")
	public ModelAndView AvailableBooks() {
		ModelAndView mv = new ModelAndView();
		List<Books> list = clientRepository.AllAvailableBookks();
		mv.addObject("list", list);
		mv.setViewName("AvailableBooksList");
		return mv;
	}

	@RequestMapping("/AddBooks")
	public ModelAndView AddBooks() {
		ModelAndView mv = new ModelAndView();
		mv.addObject(new Books());
		mv.setViewName("AddBooks");
		return mv;
	}

	@RequestMapping("/InsertBooks")
	public ModelAndView InsertBooks(@ModelAttribute("books") Books books) {
		ModelAndView mv = new ModelAndView();
		ResponseEntity<String> res = clientRepository.InsertBooks(books);
		String result = res.getBody();
		if (result.equals("sucess")) {
			List<Books> lst = clientRepository.AvailableBooks();
			mv.addObject("list", lst);
			int sucess=1;
			mv.addObject("status", sucess);
			mv.addObject(new Books());
			mv.setViewName("AddBooks");
			return mv;
		} else {
			int failure = 0;
			mv.addObject("status", failure);
			mv.setViewName("AddBooks");
			return mv;
		}
	}

	@RequestMapping("/distributeBooks")
	public ModelAndView distribute(@ModelAttribute("books") Books books, HttpServletResponse response,
			HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();
		ResponseEntity<String> res = clientRepository.distributeBooks(books);
		String result = res.getBody();
		if (result.equals("sucess")) {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDateTime now = LocalDateTime.now();
			String date = now.format(formatter);

			HttpSession session = request.getSession(false);
			Integer id = (Integer) session.getAttribute("stdid");

			BooksHistory bh = new BooksHistory();
			int no = books.getNo();
			Books bks = clientRepository.findbookbyno(no);
			// System.out.println(id+ "printing here" +bks.getBookid());
			Integer size = clientRepository.BookHistoryCheck(id, bks.getBookid());
			// int size = lst.size();
			if (size == 0) {
				bh.setNoofbooks(1);
				bh.setStdid(id);
				bh.setBookname(bks.getBookname());
				bh.setAuthor(bks.getAuthor());
				bh.setBookid(bks.getBookid());
				bh.setDate(date);
				ResponseEntity<String> ress = clientRepository.BooksHistoryy(bh);
				String resultt = ress.getBody();

				if (resultt.equals("Sucess")) {
					List<BooksHistory> lstt = clientRepository.findHHistoryofBooksByStdid(id);
					mv.addObject("lst", lstt);
					mv.setViewName("StudentBooksHistory");
				}

			} else {
				int taken = 1;
				mv.setViewName("AvailableBooks");
				mv.addObject("Historycheck", taken);
			}

		} else {
			mv.setViewName("AvailableBooks");
		}
		return mv;

	}

	@RequestMapping("/StudentRegister")
	public ModelAndView StudentRegister() {
		ModelAndView mv = new ModelAndView();
		mv.addObject(new Students());
		mv.setViewName("StudentRegister");
		return mv;
	}

	@RequestMapping("/Student-Register")
	public ModelAndView StudentRegister(@ModelAttribute("students") Students students) {
		ModelAndView mv = new ModelAndView();
		ResponseEntity<String> res = clientRepository.studentRegister(students);
		String result = res.getBody();
		if (result.equals("Sucess")) {
			mv.setViewName("StudentSearch");
			return mv;
		} else {
			mv.setViewName("Register");
			return mv;
		}
	}

	@RequestMapping("/ReturnBooks")
	public ModelAndView ReturnBooks() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ReturnBooksSearch");
		return mv;
	}

	@RequestMapping("/StdidSearch")
	public ModelAndView StudentBooksReturn(@RequestParam("stdid") int stdid, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession(true);
		session.setAttribute("studentid", stdid);

		List<BooksHistory> lst = clientRepository.PendingBooksToReturn(stdid);
		int z = lst.size();
		if (z != 0) {
			mv.addObject("sai", z);
			mv.addObject("list", lst);
			mv.setViewName("ReturnBooks");
		} else {
			mv.setViewName("ReturnBooks");
			int a = 404;
			mv.addObject("a", a);
		}
		return mv;
	}

	@RequestMapping("/return")
	public ModelAndView returnn(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		String bookids[] = request.getParameterValues("books");

		HttpSession sessioon = request.getSession(false);
		Integer stdid = (Integer) sessioon.getAttribute("studentid");
		// int z = sai.length;
		// mv.addObject("siri", z);
		String result = clientRepository.returnBooks(stdid, bookids);
		
		List<BooksHistory> list = clientRepository.findHHistoryofBooksByStdid(stdid);
		if (result.equals("Sucess")) {
			mv.addObject("a", 500);	
			mv.addObject("list", list);
			mv.addObject(new BooksHistory());
			mv.setViewName("ReturnBooks");
			
		} else {
			mv.addObject("list", list);
           mv.addObject("a", 501);
           mv.setViewName("ReturnBooks");
		}
		return mv;

	}
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("HomePage");
		return mv;
		
	}

}
