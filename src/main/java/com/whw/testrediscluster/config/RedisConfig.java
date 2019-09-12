package com.whw.testrediscluster.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Arrays;

@Configuration
public class RedisConfig {
    @Autowired
    private ClusterConfigProperties properties;

    @Bean
    public RedisConnectionFactory connectionFactory(){
        System.out.println("加载cluster环境下的redis client配置");
        RedisClusterConfiguration redisClusterConfiguration = (new RedisClusterConfiguration(properties.getNodes()));


//        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(Arrays.asList(
//                "39.107.111.245:6381",
//                "39.107.111.245:6382",
//                "39.107.111.245:6383",
//                "39.107.111.245:6384",
//                "39.107.111.245:6385",
//                "39.107.111.245:6386"
//        ));
        // 自适应集群变化
        return new JedisConnectionFactory(redisClusterConfiguration);
    }


    /**
     * RedisTemplate配置
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 配置redisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
