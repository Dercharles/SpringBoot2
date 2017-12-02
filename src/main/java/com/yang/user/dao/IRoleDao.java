package com.yang.user.dao;

import com.yang.user.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDao extends JpaRepository<RoleEntity,Long> {
}
