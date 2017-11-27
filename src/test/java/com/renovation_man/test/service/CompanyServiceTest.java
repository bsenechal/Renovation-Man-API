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

import com.renovation_man.model.Company;
import com.renovation_man.repository.ICompanyRepository;
import com.renovation_man.service.CompanyService;
import com.renovation_man.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CompanyService.class)
@AutoConfigureMockMvc
public class CompanyServiceTest {
    private static final int COMPANY_ID = 1;

    private List<Company> companyList;

    @MockBean
    private ICompanyRepository companyRepository;

    @Autowired
    private IUserService<Company> companyService;

    private Company companyTest;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllTest() {
        when(companyRepository.findAll()).thenReturn(companyList);

        final List<Company> result = companyService.findAll();

        Assert.assertNotNull(result);
        Assert.assertEquals(companyList.size(), result.size());
    }

    @Test
    public void findByIdTest() {
        when(companyRepository.findById(COMPANY_ID)).thenReturn(companyTest);

        final Company result = companyService.findById(COMPANY_ID);

        Assert.assertNotNull(result);
        Assert.assertEquals(companyTest, result);
    }

    @Before
    public void initObjects() {
        companyTest = new Company(2, "COMPANY", "Renovation Man", "Unlimited");

        companyList = new ArrayList<Company>();

        companyList.add(companyTest);
    }

    @Test
    public void saveTest() {
        when(companyRepository.save(companyTest)).thenReturn(companyTest);

        final Company result = companyService.save(companyTest);

        Assert.assertNotNull(result);
        Assert.assertEquals(companyTest, result);
    }
}
