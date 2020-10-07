package com.cg.obs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.obs.entity.Login;
import com.cg.obs.exception.LoginException;
@Repository
@Transactional
public class LoginDaoImpl implements LoginDao{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Login validate(String userName, String userPass) throws LoginException {
		String qry="Select e from Login e where e.userName=:userName and e.userPass=:userPass";
		TypedQuery<Login>query= entityManager.createQuery(qry, Login.class);
		List<Login> list=query.setParameter("userName", userName).setParameter("userPass", userPass).getResultList();
		Login login=null;
		if(!list.isEmpty())
			login=list.get(0);
		return login;
	}

	@Override
	public Login create(Login login) throws LoginException {
		entityManager.persist(login);
		return login;
	}

	@Override
	public Login findUser(String userName) throws LoginException {
		Login login=entityManager.find(Login.class, userName);
		return login;
	}

}
