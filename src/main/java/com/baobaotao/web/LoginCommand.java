package com.baobaotao.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginCommand {
	private String userName;
	private String password;
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
	public static void main(String[] args) throws ParseException {
		DateFormat ds=new SimpleDateFormat("yyyy-MM");
		Date date=ds.parse("2017-01");
		System.out.println(date);
	}
}
