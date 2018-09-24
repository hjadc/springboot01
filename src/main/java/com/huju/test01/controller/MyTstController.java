package com.huju.test01.controller;

import com.alibaba.fastjson.JSONObject;
import com.huju.test01.dao.MyTestDao;
import com.huju.test01.domain.KpiIndexDomain;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huju on 2018/9/16.
 */

@Api(description = "普通测试接口")
@Controller
public class MyTstController {
    private static  Logger log = LoggerFactory.getLogger(MyTstController.class);

    @Autowired
    MyTestDao myTestDao;


    @RequestMapping("test01")
    @ResponseBody
    public String test01() {

        System.out.println("进来了!");
        return "Holle Spring Boot";
    }

    @ApiOperation(value = "获取指标接口", notes = "获取接口")
    @ResponseBody
    @RequestMapping(value = "getIndex/{id}",method = {RequestMethod.GET})
    public String getIndex(@PathVariable Long id) {
        KpiIndexDomain indexById = myTestDao.getIndexById(id);
        String s = JSONObject.toJSONString(indexById);
        System.out.println("进来了: " + s);
        log.info("老子是用新日志打印的: " + s);
        return s;
    }
}
