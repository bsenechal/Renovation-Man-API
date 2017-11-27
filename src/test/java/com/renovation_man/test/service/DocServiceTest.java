package com.renovation_man.test.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.renovation_man.model.Doc;
import com.renovation_man.repository.IDocRepository;
import com.renovation_man.service.DocService;
import com.renovation_man.service.IDocService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DocService.class)
@AutoConfigureMockMvc
public class DocServiceTest {
    private static final int AUTHOR_ID = 1;

    private static final int DOC_ID = 1;

    private static final int LAST_VERSION_DOC = 1;

    private static final int NEXT_VERSION_DOC = 2;

    private List<Doc> docList;
    @MockBean
    private IDocRepository docRepository;
    @Autowired
    private IDocService docService;
    private Doc docTest;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllTest() {
        when(docRepository.findAll()).thenReturn(docList);

        final List<Doc> result = docService.findAll();

        Assert.assertNotNull(result);
        Assert.assertEquals(docList.size(), result.size());
    }

    @Test
    public void findByAuthorIdTest() {

        when(docRepository.findByAuthorId(AUTHOR_ID)).thenReturn(docList);

        final List<Doc> result = docService.findByAuthorId(AUTHOR_ID);

        Assert.assertNotNull(result);
        Assert.assertEquals(docList.size(), result.size());

    }

    @Test
    public void findByIdTest() {
        when(docRepository.findById(DOC_ID)).thenReturn(docList);

        final List<Doc> result = docService.findById(DOC_ID);

        Assert.assertNotNull(result);
        Assert.assertEquals(docList.size(), result.size());

    }

    @Test
    public void findLastVersionByIdTest() {
        when(docRepository.findLastVersionById(DOC_ID)).thenReturn(docTest);

        final Doc result = docService.findLastVersionById(DOC_ID);

        Assert.assertNotNull(result);
        Assert.assertEquals(docTest, result);
    }

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
    public void saveTest() {
        final Doc docAfterUpdate = new Doc(docTest);
        docAfterUpdate.setVersionNumber(NEXT_VERSION_DOC);

        when(docRepository.save(docTest)).thenReturn(docTest);
        when(docRepository.findLastVersionNumberForId(LAST_VERSION_DOC)).thenReturn(LAST_VERSION_DOC);

        final Doc result = docService.save(docTest);

        Assert.assertNotNull(result);
        Assert.assertEquals(docAfterUpdate, result);
    }

}
