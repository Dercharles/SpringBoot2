package com.yang.controller;

import com.yang.entity.userEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yangp on 2017/11/14.
 */
@RestController
@RequestMapping("/user")
public class StartsController {

    @Autowired
    private com.yang.dao.userDao userDao;


    @GetMapping(value = "/find")
    public List<userEntity> home(@RequestParam(value = "id",defaultValue = "900",required = false)Integer idw){
        return girlProperties.getCupsize()+"-----"+idw;
    }
    @PostMapping(value = "/save")
    public String home(@RequestParam(value = "id",defaultValue = "900",required = false)Integer idw){
        return girlProperties.getCupsize()+"-----"+idw;
    }
    @GetMapping(value = "/delete")
    public String home(@RequestParam(value = "id")Long id){
        return ;
    }

}
