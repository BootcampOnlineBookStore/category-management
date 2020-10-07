package com.cg.obs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.obs.dao.LoginDao;
import com.cg.obs.entity.Login;
import com.cg.obs.exception.LoginException;
@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginDao loginDao;
	@Override
	public String validate(String userName, String userPass) throws LoginException {
		Login login=loginDao.validate(userName, userPass);
		if(login==null)
		{
			throw new LoginException("Login Failed");
		}
		return ""+login.getUserCustId();
	}
	@Override
	public Login create(Login login) throws LoginException {
		if(loginDao.findUser(login.getUserName())!=null)
			throw new LoginException("User already exist");
		return loginDao.create(login);
	}
}
