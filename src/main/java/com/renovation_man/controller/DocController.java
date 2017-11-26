package com.renovation_man.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.renovation_man.model.Doc;
import com.renovation_man.service.IDocService;

@Controller
@RequestMapping(value = "docs")
public class DocController{
    @Autowired
    IDocService docService;
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Doc> findAllDocs() {
        return docService.findAll();
    }
    
    @RequestMapping(value = "/created_by/{user_id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Doc> findDocByAuthorId(@PathVariable("user_id") Integer userId) {
        return docService.findByAuthorId(userId);
    }
       
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Doc saveOrUpdateDoc(@RequestBody Doc doc) {
        docService.save(doc);
        return doc;
    }
}
