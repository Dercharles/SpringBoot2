package com.yang.user.controller;

import com.yang.user.entity.UserEntity;
import com.yang.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yangp on 2017/11/14.
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping(value = "/find")
    public List<UserEntity> find(){
        List<UserEntity> userEntityList = userService.finlist();
        return userEntityList;
    }
    @PostMapping(value = "/save")
    @ResponseBody
    public UserEntity save(@ModelAttribute UserEntity userEntity){
        return userService.userSave(userEntity);
    }
    @GetMapping(value = "/delete")
    public String delete(@ModelAttribute(value = "id")Long id){
        userService.delete(id);
        return "200";
    }
    @PostMapping(value = "/update/{id}")
    public UserEntity update(@ModelAttribute("id") UserEntity userEntity){
        return userService.userSave(userEntity);
    }

}
