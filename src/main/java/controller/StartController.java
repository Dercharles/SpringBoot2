package controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangp on 2017/11/14.
 */
@RestController
public class StartController {
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    @ResponseBody
    public String home(){
        return "你好SpringBoot";
    }
}
