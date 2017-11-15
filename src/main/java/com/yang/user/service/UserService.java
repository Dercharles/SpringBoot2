package com.yang.user.service;

import com.yang.user.dao.UserDao;
import com.yang.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangp on 2017/11/15.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public List<UserEntity> finlist() {
        return userDao.findAll();
    }

    public void delete(Long id) {
        userDao.delete(id);
    }

    public void userSave(UserEntity userEntity) {
        userDao.save(userEntity);
    }
}
