package edu.mum.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.login.dao.LoginDao;
import edu.mum.login.domain.User;
import edu.mum.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	private static final String USER_NAME = "admin";
	private static final String PASSSWORD = "test123";
	
	@Override
	public boolean authenticateUser(String userName, String password) {		
		return loginDao.authenticateUser(userName, password);
	}
		
	@Override	
	public boolean authenticate(User user) {
		
		String userName = user.getUserName();
		String password = user.getPassword();			
		
		if(userName.equals(USER_NAME) && password.equals(PASSSWORD))
			return true;
		return false;
	}
}
