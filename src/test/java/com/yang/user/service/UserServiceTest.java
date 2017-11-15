package com.yang.user.service;

import com.yang.user.dao.UserDao;
import com.yang.user.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by yangp on 2017/11/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void findOne() throws Exception {
        UserEntity userEntity = userService.findOne(3l);
        Assert.assertEquals(new Long(56),userEntity.getAge());
    }

}