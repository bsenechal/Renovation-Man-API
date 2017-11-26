package com.renovation_man.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.renovation_man.model.Company;

public interface ICompanyRepository extends CrudRepository<Company, Long> {

    @Override
    public List<Company> findAll();

    public Company findById(Integer id);
}