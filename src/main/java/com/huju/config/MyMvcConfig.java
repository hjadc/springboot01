package com.huju.config;

import com.huju.crud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 扩展springMvc 如果要全面接管还需要加上@EnableWebMvc注解(一般不建议全面接管)
 * Created by huju on 2018/10/14.
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        //浏览器发送 http://localhost:8080/aaaaa 请求来到 success页面
        registry.addViewController("/aaaaa").setViewName("success");
    }

    /**
     * 使用我们自己的语言区域信息解析器
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
