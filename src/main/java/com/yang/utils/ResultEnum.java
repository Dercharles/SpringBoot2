package com.yang.utils;

/**
 * Created by yangp on 2017/11/15.
 */
public enum ResultEnum {
    UNKONW_ERROR(-1,"系统未知属性"),
    SUCCESS(200,"ok"),
    PRIMARY_SHOOL(10001,"参数错误！"),
    MIDDLE_SCHOOL(1006,"长度限制！")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
