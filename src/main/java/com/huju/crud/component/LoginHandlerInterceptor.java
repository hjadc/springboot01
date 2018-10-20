package com.huju.crud.component;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆拦截器
 * Created by huju on 2018/10/20.
 */
@Slf4j
public class LoginHandlerInterceptor implements HandlerInterceptor {

    /**
     * 目标执行之前检查
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        log.info("************** 拦截器,获取到session: {} **********", JSONObject.toJSONString(loginUser));
        if (null == loginUser) {
            // 未登陆,转发到登陆页面;
            request.setAttribute("msg", "没有权限,请登陆!");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else {
            // 已经登陆,放行
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
