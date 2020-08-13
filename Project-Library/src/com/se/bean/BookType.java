package com.se.bean;
/**
 * @ClassName: BookType
 * @Description:
 * @author: 赵越超
 * @date: 2020年4月17日 下午6:12:26
 * @param:
 */
public class BookType {
	private int bookTypeid;
	private String bookTypeName;
	private int days;
	
	
	public BookType() {
		super();
	}


	public BookType(int bookTypeid, String bookTypeName, int days) {
		super();
		this.bookTypeid = bookTypeid;
		this.bookTypeName = bookTypeName;
		this.days = days;
	}


	public int getBookTypeid() {
		return bookTypeid;
	}


	public void setBookTypeid(int bookTypeid) {
		this.bookTypeid = bookTypeid;
	}


	public String getBookTypeName() {
		return bookTypeName;
	}


	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}


	public int getDays() {
		return days;
	}


	public void setDays(int days) {
		this.days = days;
	}
	
}
