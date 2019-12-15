package com.hcl.client;

public class Books {
	private int id;
	private int no;
	private String bookid;
	private String bookname;
    private String	author;
	private String availablebooks;
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
	public String getAvailablebooks() {
		return availablebooks;
	}
	public void setAvailablebooks(String availablebooks) {
		this.availablebooks = availablebooks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", no=" + no + ", bookid=" + bookid + ", bookname=" + bookname + ", author=" + author
				+ ", availablebooks=" + availablebooks + "]";
	}
	
	

}
