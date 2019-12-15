package com.hcl.client;


public class BooksHistory {
	private int id;
	private int stdid;
	private String bookname;
	private String author;
	private String date;
	private int noofbooks;
	private String bookid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNoofbooks() {
		return noofbooks;
	}
	public void setNoofbooks(int noofbooks) {
		this.noofbooks = noofbooks;
	}
	public int getStdid() {
		return stdid;
	}
	public void setStdid(int stdid) {
		this.stdid = stdid;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	@Override
	public String toString() {
		return "BooksHistory [id=" + id + ", stdid=" + stdid + ", bookname=" + bookname + ", author=" + author
				+ ", date=" + date + ", noofbooks=" + noofbooks + ", bookid=" + bookid + "]";
	}
	
	
	
}
