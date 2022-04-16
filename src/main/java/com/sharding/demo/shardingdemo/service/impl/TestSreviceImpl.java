package com.sharding.demo.shardingdemo.service.impl;

import com.sharding.demo.shardingdemo.entity.TestEntity;
import com.sharding.demo.shardingdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: <br>
 * Create Date: 2022/4/16 下午7:05 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
@Service
public class TestSreviceImpl implements TestService {

    @Autowired
    TestService testService;

    @Override
    public int saveinfo(TestEntity testEntity) {
        return testService.saveinfo(testEntity);
    }
}
