package com.se.bean;

public class Admin {
	/*����Ա�û���*/
	private int id;
	private String username;
	/*��½����*/
	private String password;
	
	public Admin() {
		super();
	}
	
	
	public Admin(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
