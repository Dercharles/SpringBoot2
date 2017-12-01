package com.yang.foundation.repository;

import com.yang.foundation.entity.Province;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.QueryHint;
import java.util.List;

public interface ProvinceDao extends CrudRepository<Province,Long> {

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query("select p from Province p order by p.municipality desc,p.firstLetter asc ")
    List<Province> findProvince();

    @Query("select p from Province p where p.provinceName like ?1%")
    Province findByName(String name);
}
