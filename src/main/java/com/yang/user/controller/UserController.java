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
    public String save(@RequestBody UserEntity userEntity){
        userService.userSave(userEntity);
        return "200";
    }
    @GetMapping(value = "/delete")
    public String delete(@RequestParam(value = "id")Long id){
        userService.delete(id);
        return "200";
    }

}
