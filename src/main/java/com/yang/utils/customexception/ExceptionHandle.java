package com.yang.utils.customexception;

import com.yang.utils.returncode.Result;
import com.yang.utils.returncode.Resultutil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 自定义异常处理
 * Created by yangp on 2017/11/15.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof OSException){
            OSException OSException = (OSException) e;
            return Resultutil.error(OSException.getCode(), OSException.getMessage());
        }else {
            logger.error("【系统异常】 {}",e);
            return Resultutil.error(-1, e.getMessage());
        }
    }

}

