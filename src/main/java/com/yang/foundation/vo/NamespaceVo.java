package com.yang.foundation.vo;

import com.visionet.letsdesk.app.base.vo.BaseVo;

import java.util.Date;

public class NamespaceVo extends BaseVo {

    private String namespace;
    private String appSecret;
    private Date createDate;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
