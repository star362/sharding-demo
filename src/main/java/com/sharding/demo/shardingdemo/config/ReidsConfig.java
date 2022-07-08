package com.sharding.demo.shardingdemo.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;


/**
 * <p>
 *
 * </p>
 *
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/7/8 16:11
 */
//@Configuration
public class ReidsConfig {


    @Bean("jedisConnectionFactory")
    @Primary
    public JedisConnectionFactory jedisConnectionFactory(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        //redis连接配置
        RedisStandaloneConfiguration redisStandaloneConfiguration=new RedisStandaloneConfiguration();
        //设置连接的ip
        redisStandaloneConfiguration.setHostName("192.168.9.140");
        //设置密码
        redisStandaloneConfiguration.setPassword(RedisPassword.of("123456"));
        //端口号
        redisStandaloneConfiguration.setPort(6379);
        //连接的数据库
        redisStandaloneConfiguration.setDatabase(6);
        //JedisConnectionFactory配置jedisPoolConfig
        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
        //客户端超时时间单位是毫秒
        jedisClientConfiguration.connectTimeout(Duration.ofMillis(5000));
        //连接池
        jedisClientConfiguration.usePooling().poolConfig(jedisPoolConfig);
        //工厂对象
        JedisConnectionFactory factory=new JedisConnectionFactory(redisStandaloneConfiguration,jedisClientConfiguration.build());
        return factory;
    }

    @Bean("redisTemplate")
    @Primary
    public RedisTemplate<String,Object> RedisTemplate(@Qualifier("jedisConnectionFactory") RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
        initRedisTemplate(redisTemplate,redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * @deprecated : 初始化RedisTemplate的配置，配置序列化and工厂
     * @param redisTemplate
     * @return
     */
    public void initRedisTemplate(RedisTemplate<String,Object> redisTemplate, RedisConnectionFactory factory){
        // json 序列化配置，序列化所有对象
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会抛出异常
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        // string 的序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        // key采用String的序列化方式
        redisTemplate.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        //设置连接工厂
        redisTemplate.setConnectionFactory(factory);
    }




}
