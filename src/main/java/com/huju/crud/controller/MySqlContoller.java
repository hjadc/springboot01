package com.huju.crud.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by huju on 2018/10/21.
 */
@Slf4j
@Controller
public class MySqlContoller {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/jdbc")
    @ResponseBody
    public String testJDBC(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from kpi_index");
        String s = JSONObject.toJSONString(maps);
        log.info(s);
        return s;
    }
}
