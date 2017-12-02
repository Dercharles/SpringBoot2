package com.yang.user.vo;

import com.yang.user.entity.RoleEntity;
import com.yang.user.entity.UserEntity;

import java.util.HashSet;
import java.util.Set;

public class RoleVo {
    private Set<RoleEntity> roles = new HashSet<>();

    public RoleVo(UserEntity userEntity) {
        this.roles = userEntity.getRoleEntities();
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }
}
