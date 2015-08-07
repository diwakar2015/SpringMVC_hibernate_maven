/**
 * 
 */
package com.diwakar.springexample.service;

import com.diwakar.springexample.model.User;

/**
 *  @author Diwakar
 *
 * Date:  Aug 7, 2015 2015
 * File: UserService.java
 */
public interface UserService {

	public void addUser(User user);
	public User getUser(String userID);
	
}
