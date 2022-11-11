package com.sharding.demo.shardingdemo.coltroller;

import com.sharding.demo.shardingdemo.entity.StarDemoEntity;
import com.sharding.demo.shardingdemo.entity.TestEntity;
import com.sharding.demo.shardingdemo.service.StarDemoService;
import com.sharding.demo.shardingdemo.service.TestService;
import com.sharding.demo.shardingdemo.service.impl.StarDemoServiceImpl;
import com.sharding.demo.shardingdemo.service.impl.TestSreviceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.apache.shardingsphere.transaction.annotation.ShardingSphereTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Description: <br>
 * Create Date: 2022/4/16 下午8:17 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    StarDemoServiceImpl starDemoService;

    @Autowired
    TestSreviceImpl testService;


    @GetMapping("a")
    public String a() {
        final Long aLong = starDemoService.getStarDemoDao().selectCount(null);

        return aLong.toString();
    }

    /**
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @ShardingSphereTransactionType(TransactionType.LOCAL)
    @GetMapping("b")
    public String b() {

        HintManager hintManager = HintManager.getInstance();
        hintManager.setDatabaseShardingValue(0);
        final TestEntity entity = TestEntity.builder()
//                .createTime("2022-05-17 13:13:22")
                .remark("" + 0).build();
        testService.getTestDao().insert(entity);
        log.info("===插入成功==[{}]", entity);
        hintManager.clearShardingValues();
        hintManager.close();


        final StarDemoEntity build = StarDemoEntity.builder()
                .sex("男").starName("star")
                .createTime(new Date(System.currentTimeMillis())).age(22).remarks("222")
                .build();

        starDemoService.saveinfo(build);
        log.info("StarDemoEntity[{}]", build);


        return "success";
    }


}
