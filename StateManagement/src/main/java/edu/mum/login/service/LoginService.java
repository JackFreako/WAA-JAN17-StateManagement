package edu.mum.login.service;

import edu.mum.login.domain.User;

public interface LoginService {
	
	public boolean authenticateUser(String userName, String password);
	public boolean authenticate(User user);
}
