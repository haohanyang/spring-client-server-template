package com.example.server;

import com.example.common.Todo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SpringServerApplication.class)
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void test_home() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void test_todo_list() throws Exception {
        var mapper = new ObjectMapper();
        var response = mvc.perform(MockMvcRequestBuilders.get("/todo")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        var todos = mapper.readValue(response.getResponse().getContentAsByteArray(), Todo[].class);
        assertEquals(4, todos.length);
    }
}