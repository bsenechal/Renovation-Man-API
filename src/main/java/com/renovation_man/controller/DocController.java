package com.renovation_man.controller;

import java.util.List;

import javax.validation.Valid;

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
public class DocController {
	@Autowired
	IDocService docService;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Doc> findAllDocs() {
		return docService.findAll();
	}

	@RequestMapping(value = "/{doc_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Doc findByDocId(@PathVariable("doc_id") Integer docId) {
		return docService.findLastVersionById(docId);
	}
	
	@RequestMapping(value = "/{doc_id}/versions", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Doc> findAllVersionsById(@PathVariable(value = "doc_id", required = true) Integer docId) {
		return docService.findById(docId);
	}
	
	@RequestMapping(value = "/created_by/{user_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Doc> findDocByAuthorId(@PathVariable("user_id") Integer userId) {
		return docService.findByAuthorId(userId);
	}
	
	@RequestMapping(value = "/created_or_modified_by/{user_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Doc> findDocCreatedOrModifiedByAuthorId(@PathVariable("user_id") Integer userId) {
		return docService.findByAuthorId(userId);
	}

	@RequestMapping(value = "/{doc_id}", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Doc updateDoc(@Valid @RequestBody Doc doc,
			@PathVariable(value = "doc_id", required = true) Integer docId) {
		doc.setId(docId);
		return docService.save(doc);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Doc saveOrUpdateDoc(@RequestBody Doc doc) {
		docService.save(doc);
		return doc;
	}
}
