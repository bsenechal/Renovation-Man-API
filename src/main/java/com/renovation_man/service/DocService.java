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
    public List<Doc> findByAuthorId(final Integer authorId) {
        return docRepository.findByAuthorId(authorId);
    }

    @Override
    public List<Doc> findById(final Integer id) {
        return docRepository.findById(id);
    }

    @Override
    public Doc findLastVersionById(final Integer id) {
        return docRepository.findLastVersionById(id);
    }

    @Override
    public Doc save(final Doc doc) {
        final Integer versionNumber = docRepository.findLastVersionNumberForId(doc.getId());

        if (doc.getId() == null) {
            final Integer maxId = docRepository.findMaxId();

            doc.setId(maxId != null ? maxId + 1 : 1);
            doc.setVersionNumber(1);
        }
        else {
            if (versionNumber != null) {
                doc.setVersionNumber(versionNumber + 1);
            }
        }

        return docRepository.save(doc);
    }

}
