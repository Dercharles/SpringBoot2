package com.yang.user.controller;

import com.yang.common.base.controller.BaseController;
import com.yang.user.dao.IRoleDao;
import com.yang.user.entity.RoleEntity;
import com.yang.user.entity.UserEntity;
import com.yang.user.service.UserService;
import com.yang.user.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yangp on 2017/11/14.
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {


    @Autowired
    private UserService userService;
    @Autowired
    private IRoleDao roleDao;

    @GetMapping(value = "/find")
    public List<UserEntity> find(){
        List<UserEntity> userEntityList = userService.finlist();
        return userEntityList;
    }
    @PostMapping(value = "/save")
    @ResponseBody
    public ResponseEntity<?> save(@ModelAttribute UserEntity userEntity){
        userEntity =  userService.userSave(userEntity);
        return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
    }
    @GetMapping(value = "/delete")
    public String delete(@ModelAttribute(value = "id")Long id){
        userService.delete(id);
        return "200";
    }
    @PostMapping(value = "/createUserRole")
    public UserEntity createUserRole(@ModelAttribute("id")UserEntity userEntity, @ModelAttribute("roleId")Long roleId){
        return userService.userRoleSave(userEntity,roleId);
    }

    @PostMapping(value = "/createRole")
    public ResponseEntity<?> createRole(@ModelAttribute("id") RoleEntity roleEntity){
        roleDao.save(roleEntity);
        return new ResponseEntity<Object>(GetSuccMap(),HttpStatus.OK);
    }

    @GetMapping(value = "/getUsreRole")
    public ResponseEntity<?> findUserRole(@RequestParam Long userId){
        RoleVo roleVo = new RoleVo(userService.findOne(userId));
        return new ResponseEntity<Object>(roleVo,HttpStatus.OK);
    }

}
