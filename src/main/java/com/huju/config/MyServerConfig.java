package com.huju.config;

import com.huju.core.filter.Myfilter;
import com.huju.core.listener.Mylistener;
import com.huju.core.servlet.Myservlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 注册三大组件
 * Created by huju on 2018/10/21.
 */
@Configuration
public class MyServerConfig {

    /**
     * 注册servlet
     *
     * @return
     */
    @Bean
    @SuppressWarnings("rawtypes")
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean<>(new Myservlet(), "/myServlet");
        return registrationBean;
    }

    /**
     * 注册filter
     *
     * @return
     */
    @Bean
    @SuppressWarnings("rawtypes")
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new Myfilter());
        // 这里可以设置拦截规则
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return registrationBean;
    }

    /**
     * 注册listener
     *
     * @return
     */
    @Bean
    @SuppressWarnings("rawtypes")
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean<Mylistener> registrationBean = new ServletListenerRegistrationBean<>(new Mylistener());
        return registrationBean;
    }
}
