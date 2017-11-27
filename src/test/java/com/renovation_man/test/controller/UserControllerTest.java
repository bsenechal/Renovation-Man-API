package com.renovation_man.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
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

import com.renovation_man.controller.UserController;
import com.renovation_man.model.Company;
import com.renovation_man.model.Person;
import com.renovation_man.model.User;
import com.renovation_man.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    private static final String companyTestJSON = "{\"type\":\"COMPANY\",\"id\":2,\"type\":\"COMPANY\",\"name\":\"Renovation Man\",\"businessEntityType\":\"Unlimited\"}";

    private static final String personTestJSON = "{\"type\":\"PERSON\",\"id\":1,\"type\":\"PERSON\",\"firstName\":\"Pawel\",\"lastName\":\"Wilk\",\"dateOfBirth\":451461600000}";

    @MockBean
    private IUserService<Company> companyService;

    private Company companyTest;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IUserService<Person> personService;

    private Person personTest;

    @MockBean
    private IUserService<User> userService;

    @Test
    public void getAllCompaniesTest() throws Exception {
        final List<Company> companyList = new ArrayList<Company>();
        companyList.add(companyTest);
        when(companyService.findAll()).thenReturn(companyList);

        this.mockMvc.perform(get("/users/companies"))
                .andExpect(status().isOk()).andExpect(content().json("[" + companyTestJSON + "]"));
    }

    @Test
    public void getAllPersonsTest() throws Exception {
        final List<Person> personList = new ArrayList<Person>();
        personList.add(personTest);
        when(personService.findAll()).thenReturn(personList);

        this.mockMvc.perform(get("/users/persons"))
                .andExpect(status().isOk()).andExpect(content().json("[" + personTestJSON + "]"));
    }

    @Test
    public void getAllUsersTest() throws Exception {
        final List<User> userList = new ArrayList<User>();
        userList.add(personTest);
        userList.add(companyTest);

        when(userService.findAll()).thenReturn(userList);

        this.mockMvc.perform(get("/users"))
                .andExpect(status().isOk()).andExpect(content().json("[" + personTestJSON + "," + companyTestJSON + "]"));
    }

    @Test
    public void getUserByIdTest() throws Exception {
        when(userService.findById(1)).thenReturn(personTest);

        this.mockMvc.perform(get("/users/1")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().json(personTestJSON));
    }

    @Before
    public void initObjects() {
        personTest = new Person(1, "PERSON", "Pawel", "Wilk", Date.from(Instant.parse("1984-04-22T06:00:00Z")));

        companyTest = new Company(2, "COMPANY", "Renovation Man", "Unlimited");
    }
}
