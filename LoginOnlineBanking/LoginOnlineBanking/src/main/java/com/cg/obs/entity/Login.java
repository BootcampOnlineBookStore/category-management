package com.cg.obs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="login_online")
public class Login {
	@Id
	@Column(name="user_name",length=15)
	private String userName;
	
	@Column(name="user_pass",length=15)
	private String userPass;
	
	@Column(name="user_cust_id")
	private long userCustId;

	public Login(String userName, String userPass, long userCustId) {
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.userCustId = userCustId;
	}

	public Login() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public long getUserCustId() {
		return userCustId;
	}

	public void setUserCustId(long userCustId) {
		this.userCustId = userCustId;
	}
	
	
	
}
