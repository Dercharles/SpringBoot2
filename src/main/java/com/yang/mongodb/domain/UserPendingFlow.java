package com.yang.mongodb.domain;

public class UserPendingFlow {
    protected static final long serialVersionUID = 1373760761780840094L;

    private Long userId;
    private Long orgId;
    private String status;      //忙闲状态; B:忙;I:闲
    private Long updateTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
