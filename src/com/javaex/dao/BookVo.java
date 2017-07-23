package com.javaex.dao;

public class BookVo {
	private int bookId;
	private String title;
	private String pubs;
	private String date;
	private int authorId;
	
	

	public BookVo(String title, String pubs) {
		
		this.title = title;
		this.pubs = pubs;
	}

	public BookVo(int bookId, String title, String pubs, String date, int authorId) {

		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.date = date;
		this.authorId = authorId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

}
