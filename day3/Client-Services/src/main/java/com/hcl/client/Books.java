package com.hcl.client;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Books")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	private String bookid;
	private String bookname;
    private String author;
	private int availablebooks;
	@Override
	public String toString() {
		return "Books [no=" + no + ", bookid=" + bookid + ", bookname=" + bookname + ", author=" + author
				+ ", availablebooks=" + availablebooks + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getAvailablebooks() {
		return availablebooks;
	}
	public void setAvailablebooks(int availablebooks) {
		this.availablebooks = availablebooks;
	}

	

}
