package com.huju.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注意,如果在yml里配置了读取哪个配置文件的话(mybatis.config-location),该类会失效
 * Created by huju on 2018/10/27.
 */
@Configuration
public class MyBatisConfig {

    /**
     * 自定义MyBatis的配置规则
     * @return
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                // 开启MyBatis的驼峰命名
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
