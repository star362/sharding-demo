package com.sharding.demo.shardingdemo.service.impl;

import com.sharding.demo.shardingdemo.dao.StarDemoDao;
import com.sharding.demo.shardingdemo.entity.StarDemoEntity;
import com.sharding.demo.shardingdemo.service.StarDemoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: <br>
 * Create Date: 2022/4/16 下午7:05 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
@Getter
@Service
public class StarDemoServiceImpl implements StarDemoService {

    @Autowired
    StarDemoDao starDemoDao;


    @Override
    public int saveinfo(StarDemoEntity starDemoEntity) {
        return starDemoDao.saveinfo(starDemoEntity);
    }

    @Override
    public int findcount() {
        return starDemoDao.findcount();
    }
}
