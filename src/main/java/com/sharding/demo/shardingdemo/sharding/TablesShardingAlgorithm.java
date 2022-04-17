package com.sharding.demo.shardingdemo.sharding;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.Properties;

/**
 * Description: 分表策略<br>
 * Create Date: 2022/4/16 下午1:50 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
@Component
public class TablesShardingAlgorithm implements StandardShardingAlgorithm<Date> {

    private static final Logger log = LoggerFactory.getLogger(TablesShardingAlgorithm.class);

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Date> preciseShardingValue) {

        log.info("==========");
        throw new RuntimeException("数据库路由错误");
    }

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Date> rangeShardingValue) {


        log.info("==2222========");
        throw new RuntimeException("数据库路由错误");
    }

    @Override
    public void init() {
        log.info("=init=2222========");
    }

    @Override
    public String getType() {
        log.info("==44========");
        return null;
    }

    @Override
    public Properties getProps() {
        log.info("==33========");
        return null;
    }

    @Override
    public void setProps(Properties properties) {
        log.info("==11========");
    }
}
