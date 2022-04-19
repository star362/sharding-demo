package com.sharding.demo.shardingdemo.sharding;

import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;

/**
 * Description: 分表策略 复合分片策略<br>
 * Create Date: 2022/4/16 下午1:50 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class TablesShardingAlgorithm implements ComplexKeysShardingAlgorithm<Date> {

    private static final Logger log = LoggerFactory.getLogger(TablesShardingAlgorithm.class);

    private Properties props = new Properties();

    /**
     * @param collection               表集合
     * @param complexKeysShardingValue 对象
     * @return
     */
    @Override
    public Collection<String> doSharding(Collection<String> collection, ComplexKeysShardingValue<Date> complexKeysShardingValue) {
        System.out.println();
//        collection.forEach(S -> {
//            log.info("=============[{}]", S);
//        });
        //对象
        final Map<String, Collection<Date>> valuesMap = complexKeysShardingValue.getColumnNameAndShardingValuesMap();
        valuesMap.forEach((k, v) -> {
            log.info("====k:[{}]========v=[{}]", k, v);
        });
//        log.info("=============[{}]", valuesMap);
        Collection<String> result = new LinkedList();
        result.add("test_2021_2");
        return result;
    }

    @Override
    public void init() {

    }

    @Override
    public String getType() {
        return "COMP_TEST";
    }

    @Override
    public Properties getProps() {
        return this.props;
    }

    @Override
    public void setProps(Properties props) {
        this.props = props;
    }
}
