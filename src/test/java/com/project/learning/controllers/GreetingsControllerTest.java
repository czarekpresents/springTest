package com.project.learning.controllers;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldReturnDefaultHelloGreetings() throws Exception {
        //Given
        final String EXPECTED_GREETINGS = "Hello WORLD!";

        //When
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/greetings/hello")
                .accept(MediaType.APPLICATION_JSON);

        //Then
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(EXPECTED_GREETINGS)));
    }

    @Test
    void shouldReturnHelloGreetingsWithName() throws Exception {
        //Given
        final String EXPECTED_GREETINGS = "Hello AREK!";

        //When
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/greetings/hello?name=arek")
                .accept(MediaType.APPLICATION_JSON);

        //Then
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(EXPECTED_GREETINGS)));
    }

    @Test
    void shouldReturnDefaultHelloGreetingsWithUnsupportedParameter() throws Exception {
        //Given
        final String EXPECTED_GREETINGS = "Hello WORLD!";

        //When
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/greetings/hello?test=arek")
                .accept(MediaType.APPLICATION_JSON);

        //Then
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(EXPECTED_GREETINGS)));
    }

    @Test
    void shouldReturnGoodbyeGreetingsWithName() throws Exception {
        //Given
        final String EXPECTED_GREETINGS = "Goodbye AREK!";

        //When
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/greetings/bye?name=arek")
                .accept(MediaType.APPLICATION_JSON);

        //Then
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(EXPECTED_GREETINGS)));
    }

    @Test
    void shouldReturn404StatusForNotSupportedEndpoint() throws Exception {
        //Given

        //When
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/test")
                .accept(MediaType.APPLICATION_JSON);

        //Then
        mvc.perform(request)
                .andExpect(status().isNotFound());
    }

}
