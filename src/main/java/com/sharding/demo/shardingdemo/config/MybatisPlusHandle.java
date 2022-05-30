package com.sharding.demo.shardingdemo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/5/30 17:54
 * @describe: <br>
 */
@Slf4j
@Component
public class MybatisPlusHandle implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入时自动填充...");
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now(ZoneId.of("Asia/Shanghai")));
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now(ZoneId.of("Asia/Shanghai")));
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新时自动填充...");
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now(ZoneId.of("Asia/Shanghai")));
    }
}
