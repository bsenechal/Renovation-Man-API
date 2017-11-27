package com.renovation_man.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renovation_man.model.Person;
import com.renovation_man.repository.IPersonRepository;

@Service
@Transactional
public class PersonService implements IUserService<Person> {
    @Autowired
    IPersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(final Integer id) {
        return personRepository.findById(id);
    }

    @Override
    public Person save(final Person person) {
        return personRepository.save(person);
    }
}
