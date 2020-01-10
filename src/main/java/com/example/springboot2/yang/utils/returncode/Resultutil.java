package com.example.springboot2.yang.utils.returncode;

/**
 * 返回外层处理
 * Created by yangp on 2017/11/15.
 */
public class Resultutil {
    public static Result success(Object object){
        Result result= new Result();
        result.setCode(200);
        result.setMessge("ok");
        result.setData(object);
        return result;
    }
    public static Result success(){
        return success(null);
    }
    public static Result error(Integer code,String msg){
        Result result= new Result();
        result.setCode(code);
        result.setMessge(msg);
        return result;

    }
}
