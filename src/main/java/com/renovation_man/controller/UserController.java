package com.renovation_man.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.renovation_man.model.Person;
import com.renovation_man.service.IPersonService;

@Controller
@RequestMapping(value="users")
public class UserController {
	@Autowired
	IPersonService personService;
    
//    @RequestMapping(value = "/{:user_id}", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
//    public Event findByIdEvent(@RequestParam(value="userId", required=true) Integer userId) {
//    	System.out.println(personService.findAllPersons());
//        return eventService.findByIdEvent(userId);
//    }
	
  @RequestMapping(value = "/persons", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public List<Person> findAllPersons() {
      return personService.findAllPersons();
  }
    
}
