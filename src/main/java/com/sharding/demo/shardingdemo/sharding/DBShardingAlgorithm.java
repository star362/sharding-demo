//package com.sharding.demo.shardingdemo.sharding;
//
//import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
//import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
//import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.Collection;
//import java.util.Properties;
//
///**
// * Description: 分库规则<br>
// * Create Date: 2022/4/16 下午1:49 <br>
// *
// * @author wangyu@mvtech.com.cn
// */
//public class DBShardingAlgorithm implements StandardShardingAlgorithm<String> {
//
//    private static final Logger log = LoggerFactory.getLogger(TablesShardingAlgorithm.class);
//
//
//
//    @Override
//    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
//        log.info("=====DBShardingAlgorithm=====");
//        return null;
//    }
//
//    @Override
//    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<String> rangeShardingValue) {
//        log.info("=====DBShardingAlgorithm2=====");
//        return null;
//    }
//
//    @Override
//    public void init() {
//        log.info("=====DBShardingAlgorithm3=====");
//    }
//
//    @Override
//    public String getType() {
//        log.info("=====DBShardingAlgorithm4=====");
//        return null;
//    }
//
//    @Override
//    public Properties getProps() {
//        log.info("=====DBShardingAlgorithm5=====");
//        return null;
//    }
//
//    @Override
//    public void setProps(Properties properties) {
//        log.info("=====DBShardingAlgorithm==6===");
//
//    }
//}
