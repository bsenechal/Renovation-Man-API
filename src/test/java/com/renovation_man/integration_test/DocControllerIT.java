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
import com.renovation_man.model.Doc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class DocControllerIT {
    private static final String URL = "http://localhost:";

    private HttpHeaders headers = new HttpHeaders();

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void addDocIT() {
        final Doc doc = new Doc("## Synopsis\nAt the top of the file there should be a short introduction and/ or overview.", 1);

        final HttpEntity<Doc> entity = new HttpEntity<Doc>(doc, headers);

        final ResponseEntity<Doc> response = restTemplate.exchange(
                createURLWithPort("/docs"),
                HttpMethod.POST, entity, Doc.class);

        Assert.assertEquals("Incorrect status code", HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Incorrect id", new Integer(1), response.getBody().getId());
        Assert.assertEquals("Incorrect version number", new Integer(1), response.getBody().getVersionNumber());
        Assert.assertEquals("Incorrect text", doc.getText(), response.getBody().getText());
        Assert.assertEquals("Incorrect author id", doc.getAuthorId(), response.getBody().getAuthorId());
    }

    private String createURLWithPort(final String uri) {
        return URL + port + uri;
    }

    @Test
    public void updateDocIT() {

        final Doc doc = new Doc("UPDATED GOOGLE NOTICE BY GERARD MENDES. Please Be Advised !!!", 1);

        final HttpEntity<Doc> entity = new HttpEntity<Doc>(doc, headers);

        final ResponseEntity<Doc> response = restTemplate.exchange(
                createURLWithPort("/docs/1"),
                HttpMethod.POST, entity, Doc.class);

        doc.setId(1);
        doc.setVersionNumber(2);

        Assert.assertEquals("Incorrect status code", HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Incorrect response", doc, response.getBody());
    }
}
