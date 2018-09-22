package com.huju.config;

import com.huju.test01.controller.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * Created by huju on 2018/9/16.
 * 1.@Configuration  标注这是一个配置类,相当于之前spring的配置文件
 * 2.@Bean  将方法的返回值添加到容器中,默认的ID就是方法名相当于之前spring的xml里配置的bean
 *
 *
 */

@Configuration // 标注这是一个配置类
public class MyAppConfig {

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

    @Bean
    public HelloService helloService(){
        System.out.println("成功注入了一个bean!");
        return new HelloService();
    }
}
