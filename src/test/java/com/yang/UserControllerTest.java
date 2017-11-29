package com.yang;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(secure = true)
public class UserControllerTest {

    @Autowired
    protected MockMvc mockMvc;


    @Test
    @Ignore
    public void save() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/user/save").param("name","lisiu"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @Ignore
    public void find() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/delete?id=2")).andExpect(status().isOk());
    }

    @Test
    public void update() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user/update/4")
                .param("age","18")
        .param("cupsize","66")).andDo(print());
    }
}
