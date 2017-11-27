package com.renovation_man.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renovation_man.model.Company;
import com.renovation_man.model.Person;
import com.renovation_man.model.User;

@Service
@Transactional
public class UserService implements IUserService<User> {
	@Autowired
	IUserService<Person> personService;

	@Autowired
	IUserService<Company> companyService;

	public List<User> findAll() {
		List<User> userList = new ArrayList<User>();

		userList.addAll(personService.findAll());

		userList.addAll(companyService.findAll());

		userList.sort(new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				if (o1.getId() == o2.getId())
					return 0;
				return o1.getId() < o2.getId() ? -1 : 1;
			}
		});
		return userList;
	}

	@Override
	public User findById(Integer id) {
		User user = personService.findById(id);

		if (user != null) {
			return user;
		} else {
			return companyService.findById(id);
		}
	}

	@Override
	public User save(User user) {
		User result = null;
		
		switch (user.getType()) {
		case "PERSON":
			Person person = personService.findById(user.getId());
			
			
			if (person != null) {
				result = new Person(person);
			}
			
			person = personService.save((Person) user);
			
			
			if (result == null) {
				return person;
			}
			
			break;
			
		case "COMPANY":
			Company company = companyService.findById(user.getId());
			
			
			if (company != null) {
				result = new Company(company);
			}
			
			company = companyService.save((Company) user);
			
			
			if (result == null) {
				return company;
			}
			
			
			break;
		default:
			// On met à null le user pour montrer qu'il y a une erreur
			return null;
		}
		return result;
	}
}
