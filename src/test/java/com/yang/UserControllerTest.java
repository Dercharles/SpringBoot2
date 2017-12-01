package com.yang;

import com.yang.user.dao.RoleDao;
import com.yang.user.dao.UserDao;
import com.yang.user.entity.RoleEntity;
import com.yang.user.entity.UserEntity;
import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(secure = true)
public class UserControllerTest {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected UserDao userDao;
    @Autowired
    protected RoleDao roleDao;


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
    @Ignore
    public void update() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user/update/4")
                .param("age","18")
        .param("cupsize","66")).andDo(print());
    }

    @Test
    public void testCreate(){
        UserEntity u1 = userDao.findOne(1l);
        UserEntity u2 = userDao.findOne(2l);

        RoleEntity r1 = roleDao.findOne(1l);
        RoleEntity r2 = roleDao.findOne(1l);
        Set<RoleEntity> ro1 = new HashSet<>();
        ro1.add(r1);
        ro1.add(r2);
        Set<RoleEntity> ro2 = new HashSet<>();
        ro2.add(r2);

        u1.setRoleEntities(ro1);
        u2.setRoleEntities(ro2);

        userDao.save(u1);
        userDao.save(u2);
        roleDao.save(r1);
        roleDao.save(r2);
    }

}
