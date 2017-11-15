package com.yang.user.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.thymeleaf.spring4.expression.Mvc;

import static org.junit.Assert.*;

/**
 * Created by yangp on 2017/11/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void find() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/find")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}