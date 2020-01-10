package com.example.springboot2.yang.foundation.controller;


import com.example.springboot2.yang.foundation.entity.City;
import com.example.springboot2.yang.foundation.entity.Province;
import com.example.springboot2.yang.foundation.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/mobile/province")
public class CityController {

    @Autowired
    private CityService cityService;


    /**
     * @apiDescription 省份／直辖市列表
     * @api {get} /mobile/province/list /mobile/province/list
     * @apiVersion 2.0.0
     * @apiName provinceList
     * @apiGroup Province&City
     * @apiPermission user
     *
     * @apiSuccess {Long} id PK
     * @apiSuccess {Long} municipality 是否直辖市(1：是；0：否)
     * @apiSuccess {String} provinceName 省份名称
     * @apiSuccess {String} firstLetter 省份名首字母
     *
     * @apiSuccessExample {json} List<Province>
     *      [
     *        {
     *          "id": 1,
     *          "municipality": 1,
     *          "provinceName": "北京市",
     *          "firstLetter": "BJ"
     *        },
     *        {
     *          "id": 8,
     *          "municipality": 1,
     *          "provinceName": "重庆市",
     *          "firstLetter": "CQ"
     *        },
     *        {
     *          "id": 3,
     *          "municipality": 1,
     *          "provinceName": "上海市",
     *          "firstLetter": "SH"
     *        },
     *        {
     *          "id": 2,
     *          "municipality": 1,
     *          "provinceName": "天津市",
     *          "firstLetter": "TJ"
     *        },
     *        {
     *          "id": 6,
     *          "municipality": 0,
     *          "provinceName": "安徽省",
     *          "firstLetter": "AH"
     *        },
     *        {
     *          "id": 9,
     *          "municipality": 0,
     *          "provinceName": "福建省",
     *          "firstLetter": "FJ"
     *        },
     *        {
     *          "id": 11,
     *          "municipality": 0,
     *          "provinceName": "广东省",
     *          "firstLetter": "GD"
     *        },
     *        {
     *          "id": 10,
     *          "municipality": 0,
     *          "provinceName": "甘肃省",
     *          "firstLetter": "GS"
     *        },
     *        {
     *          "id": 28,
     *          "municipality": 0,
     *          "provinceName": "湖南省",
     *          "firstLetter": "HN"
     *        }
     *      ]
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<?> provinceList() {
        return new ResponseEntity<List<Province>>(cityService.findProvinceList(), HttpStatus.OK);
    }


    /**
     * @apiDescription 市／区县列表
     * @api {get} /mobile/province/city/list/:provinceId /mobile/province/city/list/:provinceId
     * @apiVersion 2.0.0
     * @apiName cityList
     * @apiGroup Province&City
     * @apiPermission user
     *
     * @apiParam {Long} provinceId 省份ID(0为全部city)
     *
     * @apiSuccess {Long} id PK
     * @apiSuccess {String} cityName 城市名(模糊查询)
     * @apiSuccess {String} telephoneAreaCode 电话区号
     * @apiSuccess {Long} provinceId 省份Id
     * @apiSuccess {String} provinceName 省份名称
     * @apiSuccess {String} firstLetter 城市名首字母
     *
     * @apiSuccessExample {json} List<City>
     *      [
     *        {
     *          "id": 47,
     *          "cityName": "金山",
     *          "telephoneAreaCode": "021",
     *          "provinceId": 3,
     *          "provinceName": "上海市",
     *          "firstLetter": "JS"
     *        },
     *        {
     *          "id": 46,
     *          "cityName": "闵行",
     *          "telephoneAreaCode": "021",
     *          "provinceId": 3,
     *          "provinceName": "上海市",
     *          "firstLetter": "ZX"
     *        },
     *        {
     *          "id": 45,
     *          "cityName": "徐家汇",
     *          "telephoneAreaCode": "021",
     *          "provinceId": 3,
     *          "provinceName": "上海市",
     *          "firstLetter": "XJH"
     *        },
     *        {
     *          "id": 40,
     *          "cityName": "浦东",
     *          "telephoneAreaCode": "021",
     *          "provinceId": 3,
     *          "provinceName": "上海市",
     *          "firstLetter": "PD"
     *        },
     *        {
     *          "id": 38,
     *          "cityName": "嘉定",
     *          "telephoneAreaCode": "021",
     *          "provinceId": 3,
     *          "provinceName": "上海市",
     *          "firstLetter": "JD"
     *        },
     *        {
     *          "id": 37,
     *          "cityName": "宝山",
     *          "telephoneAreaCode": "021",
     *          "provinceId": 3,
     *          "provinceName": "上海市",
     *          "firstLetter": "BS"
     *        },
     *        {
     *          "id": 36,
     *          "cityName": "上海",
     *          "telephoneAreaCode": "021",
     *          "provinceId": 3,
     *          "provinceName": "上海市",
     *          "firstLetter": "SH"
     *        }
     *      ]
     */
    @RequestMapping(value = "/city/list/{provinceId}",method = RequestMethod.GET)
    public ResponseEntity<?> cityList(@PathVariable Long provinceId) {
        return new ResponseEntity<List<City>>(cityService.findCityList(provinceId), HttpStatus.OK);
    }



    /**
     * @apiDescription 市／区县查询
     * @api {post} /mobile/province/city/search /mobile/province/city/search
     * @apiVersion 2.0.0
     * @apiName citySearch
     * @apiGroup Province&City
     * @apiPermission user
     *
     * @apiParam {String} cityName 城市名(模糊查询)
     * @apiParam {String} telephoneAreaCode 电话区号
     * @apiParam {Long} provinceId 省份Id
     * @apiParam {String} firstLetter 城市名首字母(模糊查询)
     *
     * @apiParamExample {json} 输入:
     *  {
     *    "cityName": "长宁",
     *    "roleDesc": "021",
     *    "provinceId": 3,
     *    "firstLetter":"CN"
     *  }
     *
     * @apiSuccess {Long} id PK
     * @apiSuccess {String} cityName 城市名(模糊查询)
     * @apiSuccess {String} telephoneAreaCode 电话区号
     * @apiSuccess {Long} provinceId 省份Id
     * @apiSuccess {String} provinceName 省份名称
     * @apiSuccess {String} firstLetter 城市名首字母
     *
     * @apiSuccessExample {json} List<City>
     *      [
     *        {
     *          "id": 47,
     *          "cityName": "金山",
     *          "telephoneAreaCode": "021",
     *          "provinceId": 3,
     *          "provinceName": "上海市",
     *          "firstLetter": "JS"
     *        },
     *        {
     *          "id": 46,
     *          "cityName": "闵行",
     *          "telephoneAreaCode": "021",
     *          "provinceId": 3,
     *          "provinceName": "上海市",
     *          "firstLetter": "ZX"
     *        },
     *        {
     *          "id": 45,
     *          "cityName": "徐家汇",
     *          "telephoneAreaCode": "021",
     *          "provinceId": 3,
     *          "provinceName": "上海市",
     *          "firstLetter": "XJH"
     *        },
     *        {
     *          "id": 40,
     *          "cityName": "浦东",
     *          "telephoneAreaCode": "021",
     *          "provinceId": 3,
     *          "provinceName": "上海市",
     *          "firstLetter": "PD"
     *        },
     *        {
     *          "id": 38,
     *          "cityName": "嘉定",
     *          "telephoneAreaCode": "021",
     *          "provinceId": 3,
     *          "provinceName": "上海市",
     *          "firstLetter": "JD"
     *        },
     *        {
     *          "id": 37,
     *          "cityName": "宝山",
     *          "telephoneAreaCode": "021",
     *          "provinceId": 3,
     *          "provinceName": "上海市",
     *          "firstLetter": "BS"
     *        },
     *        {
     *          "id": 36,
     *          "cityName": "上海",
     *          "telephoneAreaCode": "021",
     *          "provinceId": 3,
     *          "provinceName": "上海市",
     *          "firstLetter": "SH"
     *        }
     *      ]
     */
    @RequestMapping(value ="/city/search", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> citySearch(@RequestBody City city) throws Exception {
        return new ResponseEntity<List<City>>(cityService.searchCityList(city), HttpStatus.OK);
    }
}
