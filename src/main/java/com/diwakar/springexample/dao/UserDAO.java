/**
 * 
 */
package com.diwakar.springexample.dao;

import com.diwakar.springexample.model.User;

/**
 *  @author Diwakar
 *
 * Date:  Aug 7, 2015 2015
 * File: UserDAO.java
 */

public interface UserDAO {

	public void addUser(User user);
	public User getUser(String userID);
	
}
