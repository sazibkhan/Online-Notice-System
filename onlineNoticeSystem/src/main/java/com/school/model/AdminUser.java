package com.school.model;

public class AdminUser {
	
	private int id;
	private String email;
	private String password;
	private String search;

	
	
	public AdminUser() {
		super();
	}

	
	
	
	
	public AdminUser(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getSearch() {
		return search;
	}





	public void setSearch(String search) {
		this.search = search;
	}


}
