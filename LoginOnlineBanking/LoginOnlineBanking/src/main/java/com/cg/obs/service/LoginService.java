package com.cg.obs.service;

import com.cg.obs.entity.Login;
import com.cg.obs.exception.LoginException;

public interface LoginService {
	public String validate(String userName,String userPass) throws LoginException;
	public Login create(Login login) throws LoginException;
}
