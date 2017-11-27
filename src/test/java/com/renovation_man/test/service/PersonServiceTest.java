package com.renovation_man.test.service;

import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
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

import com.renovation_man.model.Person;
import com.renovation_man.repository.IPersonRepository;
import com.renovation_man.service.IUserService;
import com.renovation_man.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PersonService.class)
@AutoConfigureMockMvc
public class PersonServiceTest {
    private static final int PERSON_ID = 1;

    @Autowired
    private MockMvc mockMvc;

    private List<Person> personList;

    @MockBean
    private IPersonRepository personRepository;

    @Autowired
    private IUserService<Person> personService;
    private Person personTest;

    @Test
    public void findAllTest() {
        when(personRepository.findAll()).thenReturn(personList);

        final List<Person> result = personService.findAll();

        Assert.assertNotNull(result);
        Assert.assertEquals(personList.size(), result.size());
    }

    @Test
    public void findByIdTest() {
        when(personRepository.findById(PERSON_ID)).thenReturn(personTest);

        final Person result = personService.findById(PERSON_ID);

        Assert.assertNotNull(result);
        Assert.assertEquals(personTest, result);
    }

    @Before
    public void initObjects() {
        personTest = new Person(1, "PERSON", "Pawel", "Wilk", Date.from(Instant.parse("1984-04-22T06:00:00Z")));

        personList = new ArrayList<Person>();

        personList.add(personTest);
    }

    @Test
    public void saveTest() {
        when(personRepository.save(personTest)).thenReturn(personTest);

        final Person result = personService.save(personTest);

        Assert.assertNotNull(result);
        Assert.assertEquals(personTest, result);
    }
}
