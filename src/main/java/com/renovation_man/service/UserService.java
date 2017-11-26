package com.renovation_man.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renovation_man.model.User;
import com.renovation_man.repository.ICompanyRepository;
import com.renovation_man.repository.IPersonRepository;

@Service
@Transactional
public class UserService {
    @Autowired
    IPersonRepository personRepository;
    
    @Autowired
    ICompanyRepository companyRepository;

    public List<User> findAll() {
        List<User> userList = new ArrayList<User>();
        
        userList.addAll(personRepository.findAll());
        
        userList.addAll(companyRepository.findAll());
        return userList;
    }

    
    
}
