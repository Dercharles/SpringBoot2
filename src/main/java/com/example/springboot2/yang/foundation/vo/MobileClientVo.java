package com.example.springboot2.yang.foundation.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.example.springboot2.yang.common.base.entity.JsonDateSerializer;
import com.example.springboot2.yang.common.base.vo.BaseVo;

import java.util.Date;


public class MobileClientVo extends BaseVo {

    private String clientName;
    private String clientVersion;
    private String clientSize;
    private String clientType;
    private String clientDesc;
    private Date createDate;

    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public String getClientVersion() {
        return clientVersion;
    }
    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }
    public String getClientSize() {
        return clientSize;
    }
    public void setClientSize(String clientSize) {
        this.clientSize = clientSize;
    }
    public String getClientType() {
        return clientType;
    }
    public void setClientType(String clientType) {
        this.clientType = clientType;
    }
    public String getClientDesc() {
        return clientDesc;
    }
    public void setClientDesc(String clientDesc) {
        this.clientDesc = clientDesc;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }





}
