package com.renovation_man.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.renovation_man.model.Doc;

public interface IDocRepository extends CrudRepository<Doc, Long> {

    @Override
    public List<Doc> findAll();
    
    public Doc findById(Integer id);
    
    public List<Doc> findByAuthorId(Integer authorId);
}