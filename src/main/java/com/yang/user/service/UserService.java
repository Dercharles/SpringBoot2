package com.yang.user.service;

import com.yang.common.base.service.BaseService;
import com.yang.common.constant.BusinessStatus;
import com.yang.common.modules.validate.Validator;
import com.yang.user.dao.UserDao;
import com.yang.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangp on 2017/11/15.
 */
@Service
public class UserService extends BaseService {

    @Autowired
    private UserDao userDao;


    public List<UserEntity> finlist() {
        return userDao.findAll();
    }

    public void delete(Long id) {
        userDao.delete(id);
    }

    public UserEntity userSave(UserEntity userEntity) {
        if (Validator.isNotNull(userEntity)){
            throwException(BusinessStatus.ERROR,"userEntity is null");
        }
       return userDao.save(userEntity);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    public UserEntity findOne(Long id){
        return userDao.findOne(id);
    }
}
