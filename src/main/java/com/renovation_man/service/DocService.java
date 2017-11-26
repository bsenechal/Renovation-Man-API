package com.renovation_man.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renovation_man.model.Doc;
import com.renovation_man.repository.IDocRepository;

@Service
@Transactional
public class DocService implements IDocService {
    @Autowired
    IDocRepository docRepository;
    
    @Override
    public List<Doc> findAll() {
        return docRepository.findAll();
    }

    @Override
    public Doc save(Doc doc) {
        return docRepository.save(doc);
    }

    @Override
    public Doc findById(Integer id) {
        return docRepository.findById(id);
    }

    @Override
    public List<Doc> findByAuthorId(Integer authorId) {
        return docRepository.findByAuthorId(authorId);
    }

}
