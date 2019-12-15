package com.hcl.client;
import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ClientRepositoryImpl implements ClientRepository {
	@Autowired
	@LoadBalanced
	public RestTemplate restTemplate;
	public String serviceUrl;
	

	public ClientRepositoryImpl(String serviceUrl) {
		//System.out.println(serviceUrl);
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	@Override
	public String login(Login login) {
		// TODO Auto-generated method stub
		Login logg = restTemplate.getForObject(serviceUrl + "/login/" + login.getUsername(), Login.class, login);
		System.out.println(login.getUsername());
		System.out.println(logg.getUsername());
		if (logg.getUsername().equals(login.getUsername()) && 
				logg.getPassword().equals(login.getPassword())) {
			return "sucess";
		} else {
			return "failure";
		}
   	
	}

	@Override
	public ResponseEntity<String> save(Login login) {
		ResponseEntity<String> res = restTemplate.postForEntity(serviceUrl+"/register/", login, String.class); 
		return res;
	}

	@Override
	public List<Books> AvailableBooks() {
		// TODO Auto-generated method stub
		List<Books> lst = restTemplate.getForObject(serviceUrl+"/availablebooks/",List.class);
		return lst;
	}

	@Override
	public ResponseEntity<String> InsertBooks(Books books) {
		// TODO Auto-generated method stub
	ResponseEntity<String> res = restTemplate.postForEntity(serviceUrl+"/AddBooks/", books, String.class);
		return res;
	}

	@Override
	public ResponseEntity<String> distributeBooks(Books books) {
		// TODO Auto-generated method stub
		
		ResponseEntity<String> res = restTemplate.getForEntity(serviceUrl+"/distributeBooks/"+books.getNo(),String.class, books);
		return res;
	}

	@Override
	public ResponseEntity<String> stdid(int stdid) {
		// TODO Auto-generated method stub
		ResponseEntity<String> res  = restTemplate.getForEntity(serviceUrl+"/stdid/"+stdid, String.class,stdid);
		return res;
	}

	@Override
	public ResponseEntity<String> studentRegister(Students students) {
		// TODO Auto-generated method stub
		ResponseEntity<String> res  = restTemplate.postForEntity(serviceUrl+"/StudentsRegister/", students, String.class);
		return res;
	}
	@Override
	public Books findbookbyno(int no) {
		// TODO Auto-generated method stub
		Books books = restTemplate.getForObject(serviceUrl+"/findbookbyid/"+no, Books.class);
		return books;
	}

	@Override
	public ResponseEntity<String> BooksHistoryy(BooksHistory bh) {
		// TODO Auto-generated method stub
		ResponseEntity<String> res = restTemplate.postForEntity(serviceUrl+"/booksHistory/", bh, String.class);
		return res;
	}

	@Override
	public List<BooksHistory> findHHistoryofBooksByStdid(int stdid) {
		
		ResponseEntity<List> res = restTemplate.getForEntity(serviceUrl+"/BooksHistoryById/"+stdid, List.class, stdid);
		// TODO Auto-generated method stub
		List<BooksHistory> lst = res.getBody();
		return lst;
	}

	@Override
	public Integer BookHistoryCheck(int stdid,String bookid) {
		// TODO Auto-generated method stub
		System.out.println("here we are trying to hit the server");
		ResponseEntity<Integer> res = restTemplate.getForEntity(serviceUrl+"/BookHostoryy/"+stdid+"/"+ bookid, Integer.class,stdid,bookid); 			
		System.out.println("server hitting wwas done");
		int result = res.getBody();
		return result;
	
	}

	@Override
	public List<BooksHistory> PendingBooksToReturn(int stdid) {
		// TODO Auto-generated method stub
		List<BooksHistory> lst = restTemplate.getForObject(serviceUrl+"/BooksHistoryById/"+stdid, List.class, stdid);
		return lst;
	}

	@Override
	public String returnBooks(int stdid, String bookids[]) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList(bookids);
		ResponseEntity<String> res = restTemplate.postForEntity(serviceUrl+"/ReturnBooks/"+stdid, list,String.class);
		String result = res.getBody();
		return result;
	}

	@Override
	public List<Books> AllAvailableBookks() {
		// TODO Auto-generated method stub
		List<Books> list = (List<Books>) restTemplate.getForObject(serviceUrl+"/availablebooks", List.class);
		return list;
	}


}
