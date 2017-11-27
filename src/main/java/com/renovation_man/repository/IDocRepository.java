package com.renovation_man.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.renovation_man.model.Doc;

public interface IDocRepository extends CrudRepository<Doc, Long> {
    @Override
    public List<Doc> findAll();

    public List<Doc> findByAuthorId(Integer authorId);

    @Query("SELECT d FROM Doc d WHERE id = :id")
    public List<Doc> findById(@Param("id") Integer id);

    @Query("SELECT d FROM Doc d WHERE d.id = :id and version_number = (select max(d2.versionNumber) from Doc d2)")
    public Doc findLastVersionById(@Param("id") Integer id);

    @Query("SELECT max(versionNumber) FROM Doc d WHERE d.id = :id")
    public Integer findLastVersionNumberForId(@Param("id") Integer id);

    @Query("SELECT max(id) FROM Doc d")
    public Integer findMaxId();
}