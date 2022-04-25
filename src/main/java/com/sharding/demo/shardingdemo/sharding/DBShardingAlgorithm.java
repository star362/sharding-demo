package com.sharding.demo.shardingdemo.sharding;

import org.apache.shardingsphere.sharding.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.hint.HintShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

/**
 * Description: 强制分片<br>
 * Create Date: 2022/4/16 下午1:49 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class DBShardingAlgorithm implements HintShardingAlgorithm<String> {

    private static final Logger log = LoggerFactory.getLogger(TablesShardingAlgorithm.class);


    @Override
    public Collection<String> doSharding(Collection<String> collection, HintShardingValue<String> hintShardingValue) {

        Collection<String> values = hintShardingValue.getValues();
        log.info("=======lic-c-0=====lic-c-1==========", values);



        return Arrays.asList("lic-c-"+values.toArray()[0]);
    }

    @Override
    public void init() {

    }

    @Override
    public String getType() {
        return "HINT_TEST";
    }
}
