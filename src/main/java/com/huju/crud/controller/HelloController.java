package com.huju.crud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Executor;

/**
 * Created by huju on 2018/10/20.
 */
@Slf4j
@Controller
public class HelloController {

    /**
     * 默认首页
     * @return
     */
    /*@RequestMapping({"/","/index.html"})
    public String index(){
        return "login";
    }*/

    @ResponseBody
    @RequestMapping({"/aa/{id}"})
    public String index(@PathVariable("id") String id){
        if (id.equals("1")) {
            int a = 1/0;
        }
        return "login";
    }
}
