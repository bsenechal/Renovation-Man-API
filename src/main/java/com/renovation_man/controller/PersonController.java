package com.renovation_man.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.renovation_man.model.Person;
import com.renovation_man.service.IUserService;

@Controller
@RequestMapping(value = "users")
public class PersonController {
    @Autowired
    IUserService<Person> personService;
    
    @RequestMapping(value = "/persons", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Person> findAllPersons() {
        return personService.findAll();
    }
}
