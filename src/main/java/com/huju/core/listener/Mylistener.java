package com.huju.core.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by huju on 2018/10/21.
 */
@Slf4j
public class Mylistener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("*************** 监听器 contextInitialized...web应用启动了 *************");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("*************** 监听器 contextDestroyed...当前web应用销毁了 *************");
    }
}
