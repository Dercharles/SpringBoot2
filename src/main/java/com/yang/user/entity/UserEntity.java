package com.yang.user.entity;

import com.yang.common.base.entity.IdEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangp on 2017/11/14.
 */
@Entity
@Table(name = "c_user")
public class UserEntity extends IdEntity{

    public UserEntity() {
    }

    private String name;
    private String loginName;
    private String password;

    private Set<RoleEntity> roleEntities = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", roleEntities=" + roleEntities +
                ", id=" + id +
                '}';
    }


    public UserEntity(String name, String loginName, String password, Set<RoleEntity> roleEntities) {
        this.name = name;
        this.loginName = loginName;
        this.password = password;
        this.roleEntities = roleEntities;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "c_user_role", joinColumns = {@JoinColumn(name = "user_id")} , inverseJoinColumns = {@JoinColumn(name = "role_id")})
    public Set<RoleEntity> getRoleEntities() {
        return roleEntities;
    }

    public void setRoleEntities(Set<RoleEntity> roleEntities) {
        this.roleEntities = roleEntities;
    }
}
