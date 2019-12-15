package com.hcl.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ClientRepository {
	public String login(Login login);
	public ResponseEntity<String> save(Login login);
	public List<Books> AvailableBooks();
	public ResponseEntity<String> InsertBooks(Books books);
	public ResponseEntity<String> distributeBooks(Books books);
	public ResponseEntity<String> stdid(int stdid);
	public ResponseEntity<String> studentRegister(Students students);
	public Integer BookHistoryCheck(int stdid,String bookid);
	public Books findbookbyno(int no);
	public ResponseEntity<String> BooksHistoryy(BooksHistory bh);
	public List<BooksHistory> findHHistoryofBooksByStdid(int stdid);
	public List<BooksHistory> PendingBooksToReturn(int stdid);
	public String returnBooks(int stdid,String bookids[]);
	public List<Books> AllAvailableBookks();
	
}
