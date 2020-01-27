package com.DrvieTracker.pojo;

import java.sql.Date;

public class Register {

	String name;
	String email;
	String password;
	Date date;
	int role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Register [name=" + name + ", email=" + email + ", password=" + password + ", date=" + date + ", role="
				+ role + "]";
	}

}
