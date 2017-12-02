package com.yang.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableList;
import com.yang.common.base.entity.IdEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name = "c_role")
public class RoleEntity extends IdEntity{

    private String name;
    private String roleDesc;
    private String type;
    private String permissions;
    private String defaultUrl;

    public RoleEntity() {
    }


    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getRoleDesc() {
        return roleDesc;
    }


    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }




    public String getDefaultUrl() {
        return defaultUrl;
    }


    public void setDefaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
    }


    @Transient
    @JsonIgnore
    public List<String> getPermissionList() {
        if(permissions == null){
            return null;
        }
        return ImmutableList.copyOf(StringUtils.split(permissions, ","));
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
