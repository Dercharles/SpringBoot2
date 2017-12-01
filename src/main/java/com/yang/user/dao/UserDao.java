package com.yang.user.dao;

import com.yang.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by yangp on 2017/11/14.
 */

public interface UserDao extends JpaRepository<UserEntity,Long>{
    Object findByName(String username);
}
