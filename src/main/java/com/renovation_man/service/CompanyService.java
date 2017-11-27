package com.renovation_man.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renovation_man.model.Company;
import com.renovation_man.repository.ICompanyRepository;

@Service
@Transactional
public class CompanyService implements IUserService<Company> {
    @Autowired
    ICompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(final Integer id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company save(final Company company) {
        return companyRepository.save(company);
    }

}
