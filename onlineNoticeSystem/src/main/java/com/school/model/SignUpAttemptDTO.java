package com.school.model;

import java.io.Serializable;
import java.util.Date;


public class SignUpAttemptDTO {
	
	private Long signID;

	private String email;

	private int status;

	private Date date;

	private String activationCode;
 
	public SignUpAttemptDTO() {
		super();
	}

	public SignUpAttemptDTO(Long signID, String email, int status, Date date, String activationCode) {
		super();
		this.signID = signID;
		this.email = email;
		this.status = status;
		this.date = date;
		this.activationCode = activationCode;
	}

	public Long getSignID() {
		return signID;
	}

	public void setSignID(Long signID) {
		this.signID = signID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}


	
}
