package com.huju.core;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 捕获全局异常
 * Created by huju on 2018/10/21.
 */
@ControllerAdvice
public class MyExceptionHandler {

    // 定制异常第一种,不管页面还是postman访问,都是返回json数据
/*    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","出錯了!");
        map.put("message",e.getMessage());
        e.printStackTrace();
        return map;
    }*/

    @ExceptionHandler(Exception.class) // 这里也可以捕获指定的异常 Exception.class
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("code","出錯了!");
        map.put("message",e.getMessage());

        // request中放我自己定义的数据
        request.setAttribute("ext",map);
        // 这个状态码现在是写死的,应该可以动态获取
        request.setAttribute("javax.servlet.error.status_code",500);
        e.printStackTrace();
        return "forward:/error";
    }
}
