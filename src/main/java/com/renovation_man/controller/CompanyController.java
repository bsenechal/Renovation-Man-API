package com.renovation_man.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.renovation_man.model.Company;
import com.renovation_man.service.IUserService;

@Controller
@RequestMapping(value = "users")
public class CompanyController{
    @Autowired
    IUserService<Company> companyService;
    
    @RequestMapping(value = "/companies", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Company> findAllCompanies() {
        return companyService.findAll();
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Company addCompany(@Valid @ModelAttribute("Company") Company company) {
        companyService.save(company);
        return company;
    }
}
