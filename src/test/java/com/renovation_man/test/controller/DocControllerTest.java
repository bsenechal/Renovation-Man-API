package com.renovation_man.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.renovation_man.controller.DocController;
import com.renovation_man.model.Doc;
import com.renovation_man.service.IDocService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DocController.class)
@AutoConfigureMockMvc
public class DocControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IDocService docService;

	private Doc docTest;

	private List<Doc> docList;

	private static final String docTestJSON = "{\"id\":1,\"versionNumber\":2,\"text\":\"## Installation\n\nProvide code examples and explanations of how to get the project.\",\"authorId\":1}";

	@Before
	public void initObjects() {
		docTest = new Doc(
				1,
				2,
				"## Installation\n\nProvide code examples and explanations of how to get the project.",
				1);

		docList = new ArrayList<Doc>();

		docList.add(docTest);
	}

	@Test
	public void getAllDocsTest() throws Exception {

		when(docService.findAll()).thenReturn(docList);

		this.mockMvc.perform(get("/docs")).andExpect(status().isOk())
				.andExpect(content().json("[" + docTestJSON + "]"));
	}

	@Test
	public void getDocsCreatedByTest() throws Exception {
		when(docService.findByAuthorId(1)).thenReturn(docList);

		this.mockMvc.perform(get("/docs/created_by/1"))
				.andExpect(status().isOk())
				.andExpect(content().json("[" + docTestJSON + "]"));
	}

	@Test
	public void getDocsCreatedOrModifiedByTest() throws Exception {
		when(docService.findByAuthorId(1)).thenReturn(docList);

		this.mockMvc.perform(get("/docs/created_or_modified_by/1"))
				.andExpect(status().isOk())
				.andExpect(content().json("[" + docTestJSON + "]"));
	}

	@Test
	public void getDocByIdTest() throws Exception {
		when(docService.findLastVersionById(1)).thenReturn(docTest);

		this.mockMvc.perform(get("/docs/1")).andExpect(status().isOk())
				.andExpect(content().json(docTestJSON));
	}

	@Test
	public void getAllVersionsDocTest() throws Exception {
		when(docService.findById(1)).thenReturn(docList);

		this.mockMvc.perform(get("/docs/1/versions"))
				.andExpect(status().isOk())
				.andExpect(content().json("[" + docTestJSON + "]"));
	}
}
