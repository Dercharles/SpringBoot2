package com.example.springboot2.yang.foundation.repository;

import com.example.springboot2.yang.foundation.entity.City;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.QueryHint;
import java.util.List;

public interface CityDao extends PagingAndSortingRepository<City, Long>, JpaSpecificationExecutor<City> {

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query("select c from City c where c.provinceId=?1 order by c.firstLetter asc")
    List<City> findByProvinceId(Long provinceId);

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    @Query("select c from City c order by c.firstLetter asc")
    List<City> findCity();

    City findByCityName(String name);
}
