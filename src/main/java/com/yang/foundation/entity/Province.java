package com.yang.foundation.entity;

import com.yang.common.base.entity.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 省份／直辖市
 */
@Entity
@Table(name = "c_province")
public class Province extends IdEntity {

    private Integer municipality;       //是否直辖市，1：是；0：否
    private String provinceName;
    private String firstLetter;         //名称首字母

    public Integer getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Integer municipality) {
        this.municipality = municipality;
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
