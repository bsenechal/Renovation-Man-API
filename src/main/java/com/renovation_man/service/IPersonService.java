package com.renovation_man.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.renovation_man.model.Person;

@Component
public interface IPersonService {
	
	public List<Person> findAllPersons();
	
}
