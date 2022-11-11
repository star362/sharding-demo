package com.sharding.demo.shardingdemo.cache;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>
 *
 * </p>
 *
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/7/8 19:02
 */
@Slf4j
public class MybatisRedisCache implements Cache {

    private static RedisTemplate<String, Object> redisTemplate;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    private String id;


    public MybatisRedisCache(String id) {
        if (StrUtil.isEmpty(id)) {
            throw new IllegalArgumentException("cache instances require an id.");
        }
        this.id = id;
        if (redisTemplate == null) {
            redisTemplate = SpringUtil.getBean("redisTemplate");
        }
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        if (!ObjectUtil.isEmpty(value)) {
            redisTemplate.opsForHash().put(id, key.toString(), value);
            log.info("mybatis缓存,{}:[{}]", key, value);
        }
    }

    @Override
    public Object getObject(Object key) {
        if (!ObjectUtil.isEmpty(key)) {
            Object object = redisTemplate.opsForHash().get(id, key.toString());
            log.info("mybatis缓存读取,{}:[{}]", key, object);
            return object;
        }
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        if (!ObjectUtil.isEmpty(key)) {
            redisTemplate.delete(key.toString());
        }
        return null;
    }

    @Override
    public void clear() {
        redisTemplate.delete(id.toString());
    }

    @Override
    public int getSize() {
        return redisTemplate.opsForHash().size(id.toString()).intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

}
