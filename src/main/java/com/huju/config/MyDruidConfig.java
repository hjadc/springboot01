package com.huju.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huju on 2018/10/27.
 */
@Slf4j
@Configuration
public class MyDruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource") // 指定加载ymal文件里的哪个前缀开头的配置
    @Bean
    public DataSource druid(){
        log.info("****************** 加载druid数据源 ***************");
        return new DruidDataSource();
    }

    // 配置Druid的监控 可以用图形化来监控sql执行等 http://localhost:8080/druid
    // 1.配置一个管理后台Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        // 设置一些初始化参数  可以参考 ResourceServlet 类
        Map<String,String> initParams = new HashMap<>();
        // 设置登陆名
        initParams.put("loginUsername","admin");
        // 登陆密码
        initParams.put("loginPassword","123456");
        // ""是允许所有人访问,配置localhost就是只允许该ip访问
        initParams.put("allow","");
        // 拒绝谁访问
        initParams.put("deny","192.168.113.128");
        bean.setInitParameters(initParams);

        return bean;
    }

    // 2.配置一个web监控的filter
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        // 指定使用哪个Filter
        bean.setFilter(new WebStatFilter());
        // 设置一些初始化参数  可以参考 WebStatFilter 类
        Map<String,String> initParams = new HashMap<>();
        // 设置哪些请求不拦截
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);

        // 拦截哪些请求  现在是拦截所有的
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }
}
