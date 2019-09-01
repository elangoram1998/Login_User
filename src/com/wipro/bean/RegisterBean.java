package com.wipro.bean;

public class RegisterBean {
	private String firstname;
	private String lastname;
	private String emailid;
	private String userid;
	private String password;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public RegisterBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public RegisterBean(String firstname, String lastname, String emailid, String userid, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
		this.userid = userid;
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
