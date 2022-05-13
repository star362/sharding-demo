package com.sharding.demo.shardingdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/5/13 13:41
 * @describe: <br>
 */
@Import(cn.hutool.extra.spring.SpringUtil.class)
@Configuration
//@EnableTransactionManagement(proxyTargetClass = true)
public class TransactionConfiguration {
}
