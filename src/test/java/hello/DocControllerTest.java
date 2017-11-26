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

package hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.renovation_man.application.Application;
import com.renovation_man.service.IDocService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
@WebAppConfiguration
public class DocControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
        
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IDocService docService;

    // @Test
    // public void homePage() throws Exception {
    // // N.B. jsoup can be useful for asserting HTML content
    // mockMvc.perform(get("/index.html"))
    // .andExpect(content().string(containsString("Get your greeting")));
    // }
    //
    // @Test
    // public void greeting() throws Exception {
    // mockMvc.perform(get("/greeting"))
    // .andExpect(content().string(containsString("Hello, World!")));
    // }
    //
    // @Test
    // public void greetingWithUser() throws Exception {
    // mockMvc.perform(get("/greeting").param("name", "Greg"))
    // .andExpect(content().string(containsString("Hello, Greg!")));
    // }

    @Test
    public void getAllDocsTest() throws Exception {
//        when(docService.findAll()).thenReturn(null);
        
        mockMvc.perform(get("/docs"))
        .andExpect(status().isOk());
    }


}
