package com.example.springboot2.yang.foundation.service;

import com.example.springboot2.yang.common.base.service.BaseService;
import com.example.springboot2.yang.common.modules.persistence.DynamicSpecifications;
import com.example.springboot2.yang.common.modules.persistence.SearchFilter;
import com.example.springboot2.yang.common.modules.validate.Validator;
import com.example.springboot2.yang.common.utils.PageInfo;
import com.example.springboot2.yang.common.utils.SearchFilterUtil;
import com.example.springboot2.yang.foundation.entity.City;
import com.example.springboot2.yang.foundation.entity.Province;
import com.example.springboot2.yang.foundation.repository.CityDao;
import com.example.springboot2.yang.foundation.repository.ProvinceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CityService extends BaseService {

    @Autowired
    private ProvinceDao provinceDao;
    @Autowired
    private CityDao cityDao;

    public List<Province> findProvinceList(){
        return provinceDao.findProvince();
    }

    public List<City> findCityList(Long provinceId){
        if(Validator.isNull(provinceId)) {
            return cityDao.findCity();
        }else {
            return cityDao.findByProvinceId(provinceId);
        }
    }

    public List<City> searchCityList(City city) throws Exception{
        Map<String, Object> searchParams = SearchFilterUtil.convertBean(city);

        Map<String, SearchFilter> filters = SearchFilterUtil.parse(searchParams);

        if(filters.get("cityName")!=null){
            filters.put("cityName", new SearchFilter("cityName", SearchFilter.Operator.LIKE, filters.get("cityName").value));
        }
        if(filters.get("firstLetter")!=null){
            filters.put("firstLetter", new SearchFilter("firstLetter", SearchFilter.Operator.LIKE, filters.get("firstLetter").value));
        }

        PageInfo pageInfo = new PageInfo(1,1000);
        PageRequest pageRequest = buildPageRequest(pageInfo.getPageNumber(), pageInfo.getPageSize(),pageInfo.getSortColumn());
        return cityDao.findAll(DynamicSpecifications.bySearchFilter(filters.values(), City.class), pageRequest).getContent();
    }

    public Long findProvinceIdByName(String provinceName){
        if(Validator.isNull(provinceName)){
            return null;
        }
        Province province = provinceDao.findByName(provinceName);
        if(province==null){
            return null;
        }
        return province.getId();
    }
    public Long findCityIdByName(String cityName){
        if(Validator.isNull(cityName)){
            return null;
        }
        City city = cityDao.findByCityName(cityName);
        if(city==null){
            return null;
        }
        return city.getId();
    }
}
