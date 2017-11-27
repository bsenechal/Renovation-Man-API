package com.renovation_man.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.renovation_man.model.Company;
import com.renovation_man.model.Person;
import com.renovation_man.model.User;
import com.renovation_man.service.IUserService;

@Controller
@EnableWebMvc
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	IUserService<Company> companyService;

	@Autowired
	IUserService<Person> personService;

	@Autowired
	IUserService<User> userService;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<User> findAllUsers() {
		return userService.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public User addUser(@Valid @RequestBody User user) {
		return userService.save(user);
	}

	@RequestMapping(value = "/{user_Id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public User findByUserId(
			@PathVariable(value = "user_Id", required = true) Integer userId) {
		return userService.findById(userId);
	}

	@RequestMapping(value = "/{user_id}", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public User updateUser(@Valid @RequestBody User user,
			@PathVariable(value = "user_id", required = true) Integer userId) {
		user.setId(userId);
		return userService.save(user);
	}

	@RequestMapping(value = "/persons", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Person> findAllPersons() {
		return personService.findAll();
	}

	@RequestMapping(value = "/companies", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Company> findAllCompanies() {
		return companyService.findAll();
	}

}
