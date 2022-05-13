package com.sharding.demo.shardingdemo.service.impl;

import com.sharding.demo.shardingdemo.dao.TestDao;
import com.sharding.demo.shardingdemo.entity.TestEntity;
import com.sharding.demo.shardingdemo.service.TestService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: <br>
 * Create Date: 2022/4/16 下午7:05 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
@Service
@Getter
public class TestSreviceImpl implements TestService {

    @Autowired
    TestDao testDao;

    @Override
    public int saveinfo(TestEntity testEntity) {
        return testDao.saveinfo(testEntity);
    }
}
