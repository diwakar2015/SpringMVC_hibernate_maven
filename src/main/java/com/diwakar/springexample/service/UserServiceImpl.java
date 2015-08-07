/**
 * 
 */
package com.diwakar.springexample.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.diwakar.springexample.dao.UserDAO;
import com.diwakar.springexample.model.User;

/**
 *  @author Diwakar
 *
 * Date:  Aug 7, 2015 2015
 * File: UserServiceImpl.java
 */
@Service
public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	@Transactional
	public void addUser(User user) {
	
		userDAO.addUser(user);
		
	}
	
	@Override
	@Transactional
	public User getUser(String userID) {
		
		return userDAO.getUser(userID);
	}

}
