/**
 * 
 */
package com.diwakar.springexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.diwakar.springexample.common.MessageDigestHash;
import com.diwakar.springexample.model.User;
import com.diwakar.springexample.service.UserService;



/**
 *  @author Diwakar
 *
 * Date:  Aug 7, 2015 2015
 * File: RegisterUserController.java
 */
@Controller
public class RegisterUserController {

	private UserService userService;

	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService userService){
		this.userService = userService;
	}

	@RequestMapping(value= "/adduser", method = RequestMethod.GET)
	public ModelAndView navigateToAddUserPage() {
		ModelAndView mv = new ModelAndView("adduser");
		return mv;
	}

	@RequestMapping(value= "/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("resgisterForm") User user) {
		
		ModelAndView  mv = new ModelAndView("adduser");
		try
		{

			//Encrypting the password 
			String encryptedPassword = MessageDigestHash.sha1(user.getPassword());
			user.setPassword(encryptedPassword);

			userService.addUser(user);

			mv.addObject("status", true);
		}
		catch(Exception e)
		{
			mv.addObject("status", false);
		}

		return mv;

	}

}
