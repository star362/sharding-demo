package com.sharding.demo.shardingdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sharding.demo.shardingdemo.entity.TestEntity;

/**
 * Description: <br>
 * Create Date: 2022/4/16 下午7:03<br>
 *
 * @author wangyu@mvtech.com.cn
 */
public interface TestDao extends BaseMapper<TestEntity> {

    int saveinfo(TestEntity testEntity);
}
