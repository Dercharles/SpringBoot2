package com.example.springboot2.yang.common.alipay.entrty;


import com.example.springboot2.yang.common.base.entity.IdEntity;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentBill extends IdEntity {

    private String billNo;              //订单号(yyMMdd+orgId后3位+自增序列2位+随机数2位)
    private BigDecimal accountPrice;    //坐席费用(／坐席／年)
    private Integer accountNum;         //坐席人数
    private Integer accountYear;        //坐席时长
    private BigDecimal sumPrice;        //总额
    private BigDecimal discountPrice;   //折扣后金额
    private Integer orgVersion;         //支付版本：2.标准版 3.高级版
    private String invitationCode;      //邀请码

    private Integer billStatus;         //1:待支付；2:已支付;3:已取消

    private String invoiceType;         //C:普通发票；A:增值税发票
    private String invoiceAddress;      //发票邮寄地址
    private String invoiceTitle;        //发票抬头

    private String statementAccount;        //支付宝对账单

    private Long createBy;
    private Date createDate;
    private Long discountBy;
    private Date discountDate;
    private Date payDate;

    private Long salesId;               //推荐销售ID

    private Long orgId;

    private String buyerEmail;
    private String remark;          //备注

    private Integer isInvoice;


    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public BigDecimal getAccountPrice() {
        return accountPrice;
    }

    public void setAccountPrice(BigDecimal accountPrice) {
        this.accountPrice = accountPrice;
    }

    public Integer getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Integer accountNum) {
        this.accountNum = accountNum;
    }

    public Integer getAccountYear() {
        return accountYear;
    }

    public void setAccountYear(Integer accountYear) {
        this.accountYear = accountYear;
    }

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getOrgVersion() {
        return orgVersion;
    }

    public void setOrgVersion(Integer orgVersion) {
        this.orgVersion = orgVersion;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public Integer getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(Integer billStatus) {
        this.billStatus = billStatus;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(String invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public String getStatementAccount() {
        return statementAccount;
    }

    public void setStatementAccount(String statementAccount) {
        this.statementAccount = statementAccount;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getDiscountBy() {
        return discountBy;
    }

    public void setDiscountBy(Long discountBy) {
        this.discountBy = discountBy;
    }

    public Date getDiscountDate() {
        return discountDate;
    }

    public void setDiscountDate(Date discountDate) {
        this.discountDate = discountDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Long getSalesId() {
        return salesId;
    }

    public void setSalesId(Long salesId) {
        this.salesId = salesId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(Integer isInvoice) {
        this.isInvoice = isInvoice;
    }
}
