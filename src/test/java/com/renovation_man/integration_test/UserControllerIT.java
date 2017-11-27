/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.renovation_man.integration_test;

import java.time.Instant;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.renovation_man.application.Application;
import com.renovation_man.model.Company;
import com.renovation_man.model.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserControllerIT {
    private static final String URL = "http://localhost:";

    private HttpHeaders headers = new HttpHeaders();

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void addCompanyIT() {
        final Company company = new Company("COMPANY", "Google", "LLC");

        final HttpEntity<Company> entityCompany = new HttpEntity<Company>(company, headers);

        final ResponseEntity<Company> response = restTemplate.exchange(
                createURLWithPort("/users"),
                HttpMethod.POST, entityCompany, Company.class);

        Assert.assertEquals("Incorrect status code", HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Incorrect type", company.getType(), response.getBody().getType());
        Assert.assertEquals("Incorrect name", company.getName(), response.getBody().getName());
        Assert.assertEquals("Incorrect business entity type", company.getBusinessEntityType(), response.getBody().getBusinessEntityType());
    }

    @Test
    public void addPersonIT() {

        final Person person = new Person("PERSON", "Paul", "Wik", Date.from(Instant.parse("1984-04-22T06:00:00Z")));

        final HttpEntity<Person> entity = new HttpEntity<Person>(person, headers);

        final ResponseEntity<Person> response = restTemplate.exchange(
                createURLWithPort("/users"),
                HttpMethod.POST, entity, Person.class);

        Assert.assertEquals("Incorrect status code", HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Incorrect type", person.getType(), response.getBody().getType());
        Assert.assertEquals("Incorrect firstname", person.getFirstName(), response.getBody().getFirstName());
        Assert.assertEquals("Incorrect lastname", person.getLastName(), response.getBody().getLastName());
        Assert.assertEquals("Incorrect date of birth", person.getDateOfBirth(), response.getBody().getDateOfBirth());
    }

    private String createURLWithPort(final String uri) {
        return URL + port + uri;
    }

    @Test
    public void updateCompanyIT() {

        final Company company = new Company("COMPANY", "Alphabet", "LLC ");

        final Company companyBeforeUpdate = new Company(1, "COMPANY", "Google", "LLC");
        ;

        final HttpEntity<Company> entity = new HttpEntity<Company>(company, headers);

        final ResponseEntity<Company> response = restTemplate.exchange(
                createURLWithPort("/users/1"),
                HttpMethod.POST, entity, Company.class);

        Assert.assertEquals("Incorrect status code", HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Incorrect response", companyBeforeUpdate, response.getBody());
    }

    @Test
    public void updatePersonIT() {

        final Person person = new Person("PERSON", "Paul", "Wilk", Date.from(Instant.parse("1984-04-22T06:00:00Z")));

        final Person personBeforeUpdate = new Person(2, "PERSON", "Paul", "Wik", Date.from(Instant.parse("1984-04-22T06:00:00Z")));

        final HttpEntity<Person> entity = new HttpEntity<Person>(person, headers);

        final ResponseEntity<Person> response = restTemplate.exchange(
                createURLWithPort("/users/2"),
                HttpMethod.POST, entity, Person.class);

        Assert.assertEquals("Incorrect status code", HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Incorrect response", personBeforeUpdate, response.getBody());
    }
}
