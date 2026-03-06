package com.ui.pojo;

public class User {
	
	// to map "username":,"Password" from json file which stores username and password 
	
	private String userName;
	private String password;
	private String expectedResult;

	
	public User(String userName, String password,String expectedResult) {
		super();
		this.userName = userName;
		this.password = password;
		this.expectedResult = expectedResult;
	}

	public String getUserName() {
		return userName;
	}
	
	public String getExpectedResult() {
		return expectedResult;
	}

	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
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
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}

}
