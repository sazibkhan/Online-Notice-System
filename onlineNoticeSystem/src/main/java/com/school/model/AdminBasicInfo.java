package com.school.model;

import org.springframework.web.multipart.MultipartFile;

public class AdminBasicInfo {
	
		private int id;
	  private String username;
	  private String password;
	  private String firstname;
	  private String lastname;
	  private String email;
	  private String address;
	  private int phone;
	  private String photoPath;
	  private MultipartFile files;
	  
	  public AdminBasicInfo() {
		super();
	}
	  
	  
	public AdminBasicInfo(String username, String password, String firstname, String lastname, String email,
			String address, int phone) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.phone = phone;
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
	  public String getFirstname() {
	  return firstname;
	  }
	  public void setFirstname(String firstname) {
	  this.firstname = firstname;
	  }
	  public String getLastname() {
	  return lastname;
	  }
	  public void setLastname(String lastname) {
	  this.lastname = lastname;
	  }
	  public String getEmail() {
	  return email;
	  }
	  public void setEmail(String email) {
	  this.email = email;
	  }
	  public String getAddress() {
	  return address;
	  }
	  public void setAddress(String address) {
	  this.address = address;
	  }
	  public int getPhone() {
	  return phone;
	  }
	  public void setPhone(int phone) {
	  this.phone = phone;
	  }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPhotoPath() {
		return photoPath;
	}


	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}


	public MultipartFile getFiles() {
		return files;
	}


	public void setFiles(MultipartFile files) {
		this.files = files;
	}

}
