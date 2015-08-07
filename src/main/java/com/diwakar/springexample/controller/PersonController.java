package com.diwakar.springexample.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;

import com.diwakar.springexample.model.Person;
import com.diwakar.springexample.service.PersonService;

/**
 *  @author Diwakar
 *
 * Date:  Aug 6, 2015 2015
 * File: PersonRestController.java
 */

@Controller
public class PersonController {

	private PersonService personService;

	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}

	@RequestMapping(value="/")
	public ModelAndView loginPage() {

		ModelAndView model = new ModelAndView("index");
		model.addObject("login", "Navigate To Login Page");
		return model;
	}

	@RequestMapping(value="/home", method= RequestMethod.GET)
	public ModelAndView home() {

		ModelAndView model = new ModelAndView("home");
		model.addObject("login", "Navigate To Login Page");
		return model;
	}


	@RequestMapping(value="/indexpage", method = RequestMethod.GET)
	public ModelAndView indexPage() {

		ModelAndView model = new ModelAndView("index");
		return model;
	}


	@RequestMapping(value = "/personlist", method = RequestMethod.GET)
	public String listOfEmployees(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "personlist";
	}

	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public ModelAndView addPerson(@ModelAttribute("person") Person p){

		this.personService.addPerson(p);
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("status","true");
		return mv;

	}

	@RequestMapping("/remove/{id}")
	public ModelAndView removePerson(@PathVariable("id") int id){

		this.personService.removePerson(id);
		ModelAndView mv = new ModelAndView("personlist");
		mv.addObject("listPersons", this.personService.listPersons());
		mv.addObject("status",true);
		return mv;

	}


	@RequestMapping(value="/person/update", method = RequestMethod.POST)
	public String updatePerson(@ModelAttribute("person") Person p){
		
		System.out.println("Updated person: ===>  "+ p);
		
		this.personService.updatePerson(p);
		return "redirect:/personlist";

	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editPerson(@PathVariable("id") int id, Model model){

		ModelAndView mv = new ModelAndView("personlist");

		model.addAttribute("person", this.personService.getPersonById(id));
		model.addAttribute("showeditpage", true);
		model.addAttribute("listPersons", this.personService.listPersons());
		return mv;
	}
	
	@RequestMapping(value="getEmployeeBySearchID", method=RequestMethod.GET)
	public ModelAndView searchEmployee(@RequestParam(value="searchKey") String key)
	{
		ModelAndView mv = new ModelAndView("searchresult");
		int id = Integer.parseInt(key);
		
		ArrayList<Person> personList = new ArrayList<Person>();
		personList.add(this.personService.getPersonById(id));
		
		mv.addObject("listPersons", personList);
		
		
		return mv;
	}
	

}

