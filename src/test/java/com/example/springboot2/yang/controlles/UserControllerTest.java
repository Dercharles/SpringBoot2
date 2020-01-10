package com.example.springboot2.yang.controlles;

import com.example.springboot2.yang.user.dao.IRoleDao;
import com.example.springboot2.yang.user.dao.IUserDao;
import com.example.springboot2.yang.user.entity.RoleEntity;
import com.example.springboot2.yang.user.entity.UserEntity;
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
    @Autowired
    protected IUserDao IUserDao;
    @Autowired
    protected IRoleDao roleDao;


    @Test
    @Ignore
    public void save() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/user/save")
                .param("name","杨晓鹏")
                .param("loginName","yangxiaopeng")
                .param("password","123456"))
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
    @Ignore
    public void testCreate(){
        UserEntity u1 = IUserDao.findOne(3l);
        UserEntity u2 = IUserDao.findOne(2l);

        RoleEntity r1 = roleDao.findOne(1l);
        RoleEntity r2 = roleDao.findOne(1l);
        RoleEntity r3 = roleDao.findOne(2l);


        u1.getRoleEntities().add(r1);
        u2.getRoleEntities().add(r2);
        u1.getRoleEntities().add(r2);

        IUserDao.save(u1);
        IUserDao.save(u2);

    }



    @Test
    @Ignore
    public void createRole(){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(1l);
        roleEntity.setName("admin");
        roleEntity.setType("A");
        roleEntity.setDefaultUrl("www.javadc.com");
        roleEntity.setPermissions("sub-admin");
        roleEntity.setRoleDesc("系统管理员");


        RoleEntity roleEntity2 = new RoleEntity();
        roleEntity2.setName("subadmin");
        roleEntity2.setType("B");
        roleEntity2.setDefaultUrl("www.javadc.com");
        roleEntity2.setPermissions("sub-admin");
        roleEntity2.setRoleDesc("管理员");

        RoleEntity roleEntity3 = new RoleEntity();
        roleEntity3.setName("Testadmin");
        roleEntity3.setType("T");
        roleEntity3.setDefaultUrl("www.javadc.com");
        roleEntity3.setPermissions("Test-admin");
        roleEntity3.setRoleDesc("系统测试管理员");


        roleDao.save(roleEntity);
        roleDao.save(roleEntity2);
        roleDao.save(roleEntity3);

    }



    @Test
    //@Ignore
    public void createRoleUser() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/user/createUserRole")
//        .param("id","7")
//        .param("roleId","1"))
//                .andExpect(status().isOk());
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/user/createUserRole")
//                .param("id","7")
//                .param("roleId","2"))
//                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.post("/user/createUserRole")
                .param("id","7")
                .param("roleId","3"))
                .andExpect(status().isOk());


    }

    @Test
    public void findRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/getUsreRole?userId=7")).andExpect(status().isOk()).andDo(print());
    }


}
