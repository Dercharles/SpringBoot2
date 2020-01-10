package com.example.springboot2.yang.user.dao;

import com.example.springboot2.yang.user.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDao extends JpaRepository<RoleEntity,Long> {
}
