package com.yang.utils.returncode;

/**
 * http data
 * Created by yangp on 2017/11/15.
 */
public class Result<T> {
    private Integer code;
    private String messge;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessge() {
        return messge;
    }

    public void setMessge(String messge) {
        this.messge = messge;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
