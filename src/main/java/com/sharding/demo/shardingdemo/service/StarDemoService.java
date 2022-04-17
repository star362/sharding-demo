package com.sharding.demo.shardingdemo.service;

import com.sharding.demo.shardingdemo.entity.StarDemoEntity;

/**
 * Description: <br>
 * Create Date: 2022/4/16 下午7:04<br>
 *
 * @author wangyu@mvtech.com.cn
 */
public interface StarDemoService {

    int saveinfo(StarDemoEntity starDemoEntity);

    int findcount();
}
