package com.example.springboot2.yang.common.security.shiro;

import com.example.springboot2.yang.common.constant.SysConstants;
import com.example.springboot2.yang.user.dao.IUserDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private IUserDao IUserDao;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String)SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(SysConstants.CURRENT_USER, IUserDao.findByName(username));
        return true;
    }
}
