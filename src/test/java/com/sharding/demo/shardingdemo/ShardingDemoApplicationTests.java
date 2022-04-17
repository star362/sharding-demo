package com.sharding.demo.shardingdemo;

import com.sharding.demo.shardingdemo.dao.StarDemoDao;
import com.sharding.demo.shardingdemo.dao.TestDao;
import com.sharding.demo.shardingdemo.entity.StarDemoEntity;
import com.sharding.demo.shardingdemo.entity.TestEntity;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ShardingDemoApplicationTests {

    @Autowired
    StarDemoDao starService;

    @Autowired
    TestDao testService;

    @Test
    void contextLoads() {

        final StarDemoEntity build = StarDemoEntity.builder().sex("男").starName("star").createTime(new Date(System.currentTimeMillis())).age(22).remarks("222").build();
//        starService.insert(build);
        starService.saveinfo(build);
        log.info("StarDemoEntity[{}]", build);

    }


    @Test
    void contextLoads2() {
        for (int i = 0; i < 8; i++) {
//            System.out.println(starService.selectCount(null));
            int findcount = starService.findcount();
            log.info("==========[{}]", findcount);
        }
    }

    private static final Logger log = LoggerFactory.getLogger(ShardingDemoApplicationTests.class);

    @Test
    void testServiceselectCount() {

        final Long arg = testService.selectCount(null);
        log.info("=====[{}]", arg);

    }

    @Test
    void testServiceinsert() {

        final TestEntity entity = TestEntity.builder().remark("" + 0).build();
        testService.saveinfo(entity);
        log.info("===插入成功==[{}]", entity);


//        for (int i = 0; i < 10; i++) {
//            final int insert = testService.insert(TestEntity.builder().remark("" + i).build());
//
//        }
//        log.info("=====[{}]", arg);

//        final TestEntity entity = TestEntity.builder().createTime(new Date(System.currentTimeMillis())).remark("" + 0).build();
//        testService.insert(entity);
//        log.info("===插入成功==[{}]", entity);

    }

}
