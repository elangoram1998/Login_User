package com.wipro.bean;

public class LoginBean {
	private String user_id;
	private String password;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginBean(String user_id, String password) {
		super();
		this.user_id = user_id;
		this.password = password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
