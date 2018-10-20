package com.huju.crud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by huju on 2018/10/20.
 */
@Slf4j
@RequestMapping("user")
@Controller
public class LoginController {

    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, String> map, HttpSession session) {
        log.info("*************** 登陆信息,用户名: {},密码: {} **************",username,password);
        if (StringUtils.isEmpty(username)) {
            map.put("msg", "请输入用户名!");
            return "login";
        }
        if (StringUtils.isEmpty(password)) {
            map.put("msg", "请输入用密码!");
            return "login";
        }
        if (!"123456".equals(password)) {
            map.put("msg", "密码错误!");
            return "login";
        }

        // 登陆成功,防止表单重复提交,可以重定向到主页(main.html在视图映射里配置了)
        // return "dashboard";
        log.info("************** 登陆成功,重定向到主页! ************");
        // 登陆成功后,将用户放入session中,防止被拦截器LoginHandlerInterceptor拦截
        session.setAttribute("loginUser",username);
        return "redirect:/main.html";

    }
}
