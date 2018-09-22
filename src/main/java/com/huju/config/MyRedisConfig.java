package com.huju.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * Created by huju on 2018/9/16.
 */

@Configuration // 标注这是一个配置类
public class MyRedisConfig {

    /**
     * 主要修改redis的默认序列化
     * @param redisConnectionFactory
     * @return
     * @throws UnknownHostException
     */
    @Bean
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        // 修改默认序列化   默认用的是JDK的,现在改成json
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}
