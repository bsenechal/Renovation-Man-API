package com.renovation_man.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.renovation_man.model.Person;

public interface IPersonRepository extends CrudRepository<Person, Long> {

    @Override
    public List<Person> findAll();
    
    public Person findById(Integer id);

}