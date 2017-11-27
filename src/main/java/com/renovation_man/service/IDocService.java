package com.renovation_man.service;

import java.util.List;

import com.renovation_man.model.Doc;

public interface IDocService {
    public List<Doc> findAll();

    public List<Doc> findByAuthorId(Integer authorId);

    public List<Doc> findById(Integer id);

    public Doc findLastVersionById(Integer docId);

    public Doc save(final Doc doc);
}
