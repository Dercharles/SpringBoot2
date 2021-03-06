package com.example.springboot2.yang.user.service;

import com.example.springboot2.yang.common.base.service.BaseService;
import com.example.springboot2.yang.common.constant.BusinessStatus;
import com.example.springboot2.yang.common.modules.validate.Validator;
import com.example.springboot2.yang.user.dao.IRoleDao;
import com.example.springboot2.yang.user.dao.IUserDao;
import com.example.springboot2.yang.user.entity.RoleEntity;
import com.example.springboot2.yang.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangp on 2017/11/15.
 */
@Service
public class UserService extends BaseService {

    @Autowired
    private IUserDao IUserDao;
    @Autowired
    private IRoleDao iRoleDao;


    public List<UserEntity> finlist() {
        return (List<UserEntity>) IUserDao.findAll();
    }

    public void delete(Long id) {
        IUserDao.delete(id);
    }

    public UserEntity userSave(UserEntity userEntity) {
        if (Validator.isNull(userEntity)){
            throwException(BusinessStatus.ERROR,"userEntity is null");
        }
       return IUserDao.save(userEntity);
    }

    public UserEntity userRoleSave(UserEntity userEntity,Long roleId) {
        RoleEntity roleEntity = iRoleDao.findOne(roleId);
        if (Validator.isNull(roleEntity)){
            throwException(BusinessStatus.ERROR,"userEntity is null");
        }
        userEntity.getRoleEntities().add(roleEntity);
        return IUserDao.save(userEntity);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    public UserEntity findOne(Long id){
        return IUserDao.findOne(id);
    }
}
