package com.school.model;

import java.util.Date;

public class Notice {
	
	private int id;
	private String notice;
	private String admin;
	private Date create_date;
	private int is_valid;
	private int valueable;
	private String admin_email;
	private String notice_title;
	private String search;
	private String admin_name;
	private String photoPath;
	
	
	public Notice() {
		super();
	}
	public Notice(int id, String notice, String admin, Date create_date, int is_valid, int valueable) {
		super();
		this.id = id;
		this.notice = notice;
		this.admin = admin;
		this.create_date = create_date;
		this.is_valid = is_valid;
		this.valueable = valueable;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public int getIs_valid() {
		return is_valid;
	}
	public void setIs_valid(int is_valid) {
		this.is_valid = is_valid;
	}
	public int getValueable() {
		return valueable;
	}
	public void setValueable(int valueable) {
		this.valueable = valueable;
	}
	
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	
	

}
