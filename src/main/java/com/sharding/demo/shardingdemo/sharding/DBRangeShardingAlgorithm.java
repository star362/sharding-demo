package com.sharding.demo.shardingdemo.sharding;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;

/**
 * <p>
 *  标准分片 单字段
 * </p>
 *
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/6/9 16:03
 */
@Slf4j
public class DBRangeShardingAlgorithm implements StandardShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {

        log.info("===========collection========{}", JSONUtil.toJsonStr(collection));
        log.info("===========preciseShardingValue========{}", preciseShardingValue.getValue());


        return "test_2022_5";
    }

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {

        log.info("======rangeShardingValue=====collection========{}", JSONUtil.toJsonStr(collection));

        log.info("===========rangeShardingValue========{}",rangeShardingValue);

        return ListUtil.toLinkedList("test_2022_5");
    }

    @Override
    public void init() {
        log.info("========DBStandardAlgorithm=========");
    }

    @Override
    public String getType() {
        return "STANDARD_DEMO";
    }
}
