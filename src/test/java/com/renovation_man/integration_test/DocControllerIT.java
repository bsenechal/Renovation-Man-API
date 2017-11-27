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

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.renovation_man.application.Application;
import com.renovation_man.model.Doc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application.properties")
public class DocControllerIT {
	private static final String URL = "http://localhost:";

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testRetrieveStudentCourse() {
        

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/docs"),
                HttpMethod.GET, entity, String.class);

        String expected = "{id:Course1,name:Spring,description:10 Steps}";
        System.out.println("ici");
    }

    @Test
    public void addDocIT() {
        Doc doc = new Doc("## Synopsis\nAt the top of the file there should be a short introduction and/ or overview.", 1);

        HttpEntity<Doc> entity = new HttpEntity<Doc>(doc, headers);

        ResponseEntity<Doc> response = restTemplate.exchange(
                createURLWithPort("/docs"),
                HttpMethod.POST, entity, Doc.class);

        Assert.assertEquals("Incorrect status code", HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Incorrect id", new Integer(1), response.getBody().getId());
        Assert.assertEquals("Incorrect version number", new Integer(1), response.getBody().getVersionNumber());
        Assert.assertEquals("Incorrect text", doc.getText(), response.getBody().getText());
        Assert.assertEquals("Incorrect author id", doc.getAuthorId(), response.getBody().getAuthorId());
    }

    private String createURLWithPort(String uri) {
        return URL + port + uri;
    }

    
    @Test
    public void updateDocIT() {
    	
    	Doc doc = new Doc("UPDATED GOOGLE NOTICE BY GERARD MENDES. Please Be Advised !!!", 1);
        
        HttpEntity<Doc> entity = new HttpEntity<Doc>(doc, headers);

        ResponseEntity<Doc> response = restTemplate.exchange(
                createURLWithPort("/docs/1"),
                HttpMethod.POST, entity, Doc.class);

        doc.setId(1);
        doc.setVersionNumber(2);
        
        Assert.assertEquals("Incorrect status code", HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Incorrect response", doc, response.getBody());
    }
    
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private IUserService userService;
//
//    @MockBean
//    private IPersonService personService;
//
//    // @Test
//    // public void homePage() throws Exception {
//    // // N.B. jsoup can be useful for asserting HTML content
//    // mockMvc.perform(get("/index.html"))
//    // .andExpect(content().string(containsString("Get your greeting")));
//    // }
//    //
//    // @Test
//    // public void greeting() throws Exception {
//    // mockMvc.perform(get("/greeting"))
//    // .andExpect(content().string(containsString("Hello, World!")));
//    // }
//    //
//    // @Test
//    // public void greetingWithUser() throws Exception {
//    // mockMvc.perform(get("/greeting").param("name", "Greg"))
//    // .andExpect(content().string(containsString("Hello, Greg!")));
//    // }
//
//    @Test
//    public void getUserTest() throws Exception {
//        List<User> userList = new ArrayList<User>();
//        
//        when(userService.findAllUsers()).thenReturn(userList);
//        
//        mockMvc.perform(get("/users"))
////        .andExpect(status().isOk())
//        .andExpect(content().json("") );
//    }
//
//    @Test
//    public void postPersonTest() throws Exception {
//        mockMvc.perform(post("/users").param("1", "PERSON", "Paul", "Wik", "1984-04-22T06:00:00Z"))
//                .andExpect(content().json("{\r\n" + "  id: \"1\",\r\n" + "  type: \"PERSON\",\r\n" + "  firstName: \"Paul\",\r\n"
//                        + "  lastName: \"Wik\",\r\n" + "  dateOfBirth: \"1984-04-22T06:00:00Z\"\r\n" + "}"));
//    }

}
