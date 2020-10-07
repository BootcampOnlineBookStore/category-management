package com.cg.obs.dao;

import com.cg.obs.entity.Login;
import com.cg.obs.exception.LoginException;

public interface LoginDao {
	public Login validate(String userName,String userPass) throws LoginException;
	public Login create(Login login) throws LoginException;
	public Login findUser(String userName)throws LoginException;
}
