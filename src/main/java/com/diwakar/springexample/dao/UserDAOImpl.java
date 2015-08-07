/**
 * 
 */
package com.diwakar.springexample.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.diwakar.springexample.model.User;

/**
 *  @author Diwakar
 *
 * Date:  Aug 7, 2015 2015
 * File: UserDAOImpl.java
 */

@Repository
public class UserDAOImpl implements UserDAO{

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		logger.info("User created successfully, User Details="+user);

	}

	@Override
	public User getUser(String userID) {
		User user = null;
      try
      {
		Session session = this.sessionFactory.getCurrentSession();		
		user = (User) session.load(User.class,userID);
		logger.info("User loaded successfully, User details="+user);
      }
      catch(Exception e)
      {
    	  return null;
      }
		return user;
	}
}
