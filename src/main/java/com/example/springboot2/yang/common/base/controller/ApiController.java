package com.example.springboot2.yang.common.base.controller;

import com.google.common.collect.Maps;
import com.example.springboot2.yang.common.base.rest.RestException;
import com.example.springboot2.yang.common.constant.BusinessStatus;
import com.example.springboot2.yang.common.constant.MobileKey;
import com.example.springboot2.yang.common.modules.mapper.JsonMapper;
import com.example.springboot2.yang.common.modules.props.PropsKeys;
import com.example.springboot2.yang.common.modules.props.PropsUtil;
import com.example.springboot2.yang.common.modules.string.StringPool;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ApiController {
    protected JsonMapper mapper = new JsonMapper();


    protected static Map<String,String> GetSuccMap(){
        Map<String,String> map = Maps.newHashMap();
        map.put(MobileKey.CODE, BusinessStatus.OK);
        return map;
    }
    protected static Map<String,Object> GetSuccMap(Long id){
        Map<String,Object> map = Maps.newHashMap();
        map.put(MobileKey.CODE, BusinessStatus.OK);
        map.put("id", id);
        return map;
    }

    protected static boolean isAdmin(String namespace){
        if(namespace.startsWith(PropsUtil.getProperty(PropsKeys.NAMESPACE_ADMIN_NAME) + StringPool.PERIOD)){
            return true;
        }else {
            return false;
        }
    }

    protected static String getNamespace(HttpServletRequest request) {
        String namespace = (String)request.getAttribute("namespace");
        if(namespace==null){
            throwException(BusinessStatus.ACCESSDENIED,"namespace is null!");
        }
        return namespace;
    }




    protected static void throwException(String code,String msg) {
        Map<String,String> result = Maps.newHashMap();
        result.put("code", code);
        result.put("msg", msg);
        throw new RestException(result);
    }
}
