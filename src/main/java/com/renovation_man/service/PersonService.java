package com.renovation_man.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renovation_man.model.Person;
import com.renovation_man.repository.IPersonRepository;

@Service
@Transactional
public class PersonService implements IPersonService {
	@Autowired
	IPersonRepository personRepository;

	@Override
	public List<Person> findAllPersons() {
		return personRepository.findAll();
	}

}
