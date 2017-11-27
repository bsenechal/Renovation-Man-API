package com.renovation_man.service;

import java.util.List;

import com.renovation_man.model.Doc;

public interface IDocService {
    public List<Doc> findAll();
    
    public Doc save(final Doc doc);
    
    public List<Doc> findById(Integer id);
    
    public List<Doc> findByAuthorId(Integer authorId);
    
    public Doc findLastVersionById(Integer docId);
}
