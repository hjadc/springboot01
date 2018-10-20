package com.huju.crud.component;


import org.apache.tomcat.jni.Local;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by huju on 2018/10/20.
 */
public class MyLocaleResolver implements LocaleResolver{
    /**
     * 语言区域信息解析器
     * @param request
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取链接上的参数
        String language = request.getParameter("language");
        // 首先获取系统默认的语言信息
        Locale local = Locale.getDefault();
        // 如果参数上带了,就用参数的
        if (!StringUtils.isEmpty(language)) {
            // 第一个是语言信息,第二个是区域信息
            String[] split = language.split("_");
            local = new Locale(split[0],split[1]);
        }

        return local;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
