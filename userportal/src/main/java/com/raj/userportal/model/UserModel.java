package com.raj.userportal.model;

public class UserModel {

	private int id;
	private String userName;
	private String password;
	private String mobileNo;
	private String email;

	public UserModel() {
		super();

	}

	public UserModel(int id, String userName, String password, String mobileNo, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.mobileNo = mobileNo;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
