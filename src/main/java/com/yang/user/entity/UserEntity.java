package com.yang.user.entity;

import com.yang.commom.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by yangp on 2017/11/14.
 */
@Entity
@Table(name = "c_user")
public class UserEntity extends IdEntity{

    private String name;
    private Long age;
    private String cupsize;

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
}
