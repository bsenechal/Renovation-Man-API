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

import com.renovation_man.model.Company;
import com.renovation_man.model.Person;
import com.renovation_man.model.User;
import com.renovation_man.service.IUserService;
import com.renovation_man.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserService.class)
@AutoConfigureMockMvc
public class UserServiceTest {
    private static final int COMPANY_ID = 2;

    private static final int INDEX_COMPANY = 1;

    private static final int INDEX_PERSON = 0;

    private static final int PERSON_ID = 1;

    private List<Company> companyList;

    @MockBean
    private IUserService<Company> companyService;

    private Company companyTest;

    @Autowired
    private MockMvc mockMvc;

    private List<Person> personList;
    @MockBean
    private IUserService<Person> personService;

    private Person personTest;
    @Autowired
    IUserService<User> userService;

    @Test
    public void findAll() {
        when(personService.findAll()).thenReturn(personList);
        when(companyService.findAll()).thenReturn(companyList);

        final List<User> result = userService.findAll();

        Assert.assertNotNull(result);
        Assert.assertEquals(personList.size() + companyList.size(),
                result.size());
        Assert.assertEquals(personTest, result.get(INDEX_PERSON));
        Assert.assertEquals(companyTest, result.get(INDEX_COMPANY));
    }

    @Test
    public void findById() {
        when(personService.findById(PERSON_ID)).thenReturn(personTest);
        when(companyService.findById(COMPANY_ID)).thenReturn(companyTest);

        User result = userService.findById(PERSON_ID);

        Assert.assertEquals(personTest, result);

        result = userService.findById(COMPANY_ID);

        Assert.assertEquals(companyTest, result);
    }

    @Before
    public void initObjects() {
        personTest = new Person(PERSON_ID, "PERSON", "Pawel", "Wik", Date.from(Instant
                .parse("1984-04-22T06:00:00Z")));

        personList = new ArrayList<Person>();

        personList.add(personTest);

        companyTest = new Company(COMPANY_ID, "COMPANY", "Renovation Man", "Unlimited");

        companyList = new ArrayList<Company>();

        companyList.add(companyTest);

    }

    @Test
    public void save() {
        final Person person2Test = new Person(PERSON_ID, "PERSON", "Pawel", "Wik",
                Date.from(Instant.parse("1984-04-22T06:00:00Z")));
        final Company company2Test = new Company(COMPANY_ID, "COMPANY", "Renovation Man",
                "LLC");

        when(personService.save(personTest)).thenReturn(personTest);
        when(personService.findById(PERSON_ID)).thenReturn(null);

        User result = userService.save(personTest);

        Assert.assertEquals(personTest, result);

        when(personService.save(person2Test)).thenReturn(personTest);
        when(personService.findById(PERSON_ID)).thenReturn(personTest);

        result = userService.save(personTest);

        Assert.assertEquals(personTest, result);

        when(companyService.save(companyTest)).thenReturn(companyTest);
        when(companyService.findById(COMPANY_ID)).thenReturn(null);

        result = userService.save(companyTest);

        Assert.assertEquals(companyTest, result);

        when(companyService.save(company2Test)).thenReturn(companyTest);
        when(companyService.findById(PERSON_ID)).thenReturn(companyTest);

        result = userService.save(companyTest);

        Assert.assertEquals(companyTest, result);
    }
}
