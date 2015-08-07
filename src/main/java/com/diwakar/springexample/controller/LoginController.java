/**
 * 
 */
package com.diwakar.springexample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.diwakar.springexample.common.MessageDigestHash;
import com.diwakar.springexample.model.Person;
import com.diwakar.springexample.model.User;
import com.diwakar.springexample.service.PersonService;
import com.diwakar.springexample.service.UserService;

/**
 *  @author Diwakar
 *
 * Date:  Aug 6, 2015 2015
 * File: LoginController.java
 */
@Controller
public class LoginController {


	private PersonService personService;

	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}

	private UserService userService;

	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService userService){
		this.userService = userService;
	}


	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public ModelAndView login(
			@ModelAttribute("LoginInfoForm") User user, HttpSession session) {

		String encryptedPassFromReq = MessageDigestHash.sha1(user.getPassword());

		User getUser = userService.getUser(user.getUserName());
		if(getUser!=null)
		{	
			if(getUser.getPassword().equals(encryptedPassFromReq))
			{
				System.out.println("Authentication Successfull!!");
				session.setAttribute("userInfo", user);

				ModelAndView mv = new ModelAndView("home");

				mv.addObject("person", new Person());
				mv.addObject("listPersons", this.personService.listPersons());
				return mv;
			}
			else
			{
				ModelAndView mv = new ModelAndView("index");
				mv.addObject("status",false);
				return mv;
			}
		}
		else
		{
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("status",false);
			return mv;

		}

	}
	
	@RequestMapping(value= "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session)
	{
		ModelAndView mv = new ModelAndView("index");
		
		session.invalidate();
		
		return mv;
		
	}

}
