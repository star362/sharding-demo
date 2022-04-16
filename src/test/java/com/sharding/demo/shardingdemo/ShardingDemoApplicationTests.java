package com.sharding.demo.shardingdemo;

import com.sharding.demo.shardingdemo.dao.StarDemoDao;
import com.sharding.demo.shardingdemo.dao.TestDao;
import com.sharding.demo.shardingdemo.entity.StarDemoEntity;
import com.sharding.demo.shardingdemo.entity.TestEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShardingDemoApplicationTests {

    @Autowired
    StarDemoDao starService;

    @Autowired
    TestDao testService;

    @Test
    void contextLoads() {
//        final List<StarDemoEntity> starDemoEntities = starService.selectList(null);
        System.out.println(starService.selectCount(null));
//        starService.insert(StarDemoEntity.builder().id(2L).build());
//        starDemoEntities.forEach(a-> System.out.println(a));
//
//        final List<TestEntity> testEntities = testService.selectList(null);
//        testEntities.forEach(b-> System.out.println(b));
    }


    @Test
    void contextLoads2() {
        for (int i = 0; i < 4; i++) {

            System.out.println(starService.selectCount(null));
        }
    }

}
