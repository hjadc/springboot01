package com.huju.core;

/**
 * Created by huju on 2018/10/27.
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * 主要是在项目启动时就检查数据连接是否正常,而不是在访问数据库时才发现连接有问题
 */
@Slf4j
@Component
public class ApplicationContextHelper implements ApplicationContextAware {

    @Autowired
    DataSource dataSource;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        try {
            // ===== 在项目初始化bean后检验数据库连接是否
            dataSource.getConnection();
            log.info("*************** 数据源连接成功! **************");
        } catch (Exception e) {
            e.printStackTrace();
            // ===== 当检测数据库连接失败时, 停止项目启动
            System.exit(-1);
        }
    }
}