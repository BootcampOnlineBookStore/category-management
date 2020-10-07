package com.cg.obs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.cg.obs.exception.LoginException;
import com.cg.obs.service.LoginService;

@RestController
@CrossOrigin("*")
//@RequestMapping("login")
public class LoginController {
	@Autowired
	LoginService loginService;
	@GetMapping("login/validate/{user}/{pass}")
	public ResponseEntity<String> validate(@PathVariable("user") String userName,@PathVariable("pass") String userPass)throws LoginException
	{
		String userCustId=loginService.validate(userName, userPass);
		return new ResponseEntity<String>(userCustId,HttpStatus.OK);
	}
	
}
