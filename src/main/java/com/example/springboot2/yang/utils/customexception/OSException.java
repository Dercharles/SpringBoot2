package com.example.springboot2.yang.utils.customexception;

import com.example.springboot2.yang.utils.returncode.ResultEnum;

/**
 * 返回码code处理
 * Created by yangp on 2017/11/15.
 */
public class OSException extends RuntimeException {
    private Integer code;

    public OSException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
