package com.sharding.demo.shardingdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.sharding.demo.shardingdemo.dao")
@SpringBootApplication
public class ShardingDemoApplication {

    /*


   #以jar命令启动的java服务只需在启动参数中加入以下参数，单机上有多个服务在启动参数中指定对应服务名称，直接启动就行

-javaagent:/Users/star/Documents/theme/skywalking/skywalking-agent/skywalking-agent.jar -Dskywalking.agent.service_name=sharding-demo -Dskywalking.collector.backend_service=localhost:11800

   */

    public static void main(String[] args) {
        SpringApplication.run(ShardingDemoApplication.class, args);
    }

}
