package com.yang.user.entity;

import com.yang.commom.IdEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangp on 2017/11/14.
 */
@Entity
@Table(name = "user")
public class UserEntity extends IdEntity{

    private String name;
    private Long age;
    private String cupsize;

    @Transient
    private Set<RoleEntity> roleEntities = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getCupsize() {
        return cupsize;
    }

    public void setCupsize(String cupsize) {
        this.cupsize = cupsize;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cupsize='" + cupsize + '\'' +
                '}';
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",inverseJoinColumns = {@JoinColumn(name = "role_id")}, joinColumns = {@JoinColumn(name = "user_id")})
    public Set<RoleEntity> getRoleEntities() {
        return roleEntities;
    }

    public void setRoleEntities(Set<RoleEntity> roleEntities) {
        this.roleEntities = roleEntities;
    }
}
