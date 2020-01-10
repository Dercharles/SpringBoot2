package com.example.springboot2.yang.foundation.entity;

import com.example.springboot2.yang.common.base.entity.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 市／区县
 */
@Entity
@Table(name = "c_city")
public class City extends IdEntity {

    private String cityName;
    private String telephoneAreaCode;
    private Long provinceId;
    private String provinceName;
    private String firstLetter;     //昵称首字母

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTelephoneAreaCode() {
        return telephoneAreaCode;
    }

    public void setTelephoneAreaCode(String telephoneAreaCode) {
        this.telephoneAreaCode = telephoneAreaCode;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }
}
