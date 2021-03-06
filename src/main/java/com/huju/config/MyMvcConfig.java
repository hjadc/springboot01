package com.huju.config;

import com.huju.crud.component.LoginHandlerInterceptor;
import com.huju.crud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 扩展springMvc 如果要全面接管还需要加上@EnableWebMvc注解(一般不建议全面接管)
 * Created by huju on 2018/10/14.
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    // 有下面的bean的话,就不用配置这个了
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        //浏览器发送 http://localhost:8080/aaaaa 请求来到 success页面
        registry.addViewController("/aaaaa").setViewName("success");
    }


    /**
     * 这个只不过是以内部类的形式来接管,也可以不写这个bean,像上面那样一个一个来重写也行
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurerAdapter() {
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            // 该方法用于添加视图映射
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // super.addInterceptors(registry);
                // /** 拦截所有的,excludePathPatterns排除一部分不拦截
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/login.html","/index.html","/","/user/login","/**/*.css",
                                "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg","/asserts/img/*");
                // 放行swegger-ui"/swagger-ui.html","/swagger-resources/**","classpath:/META-INF/resources/"
            }
        };

        return adapter;
    }

    /**
     * 使用我们自己的语言区域信息解析器
     *
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
