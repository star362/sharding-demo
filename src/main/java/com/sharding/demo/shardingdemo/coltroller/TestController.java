package com.sharding.demo.shardingdemo.coltroller;

import cn.hutool.core.collection.ListUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.sharding.demo.shardingdemo.entity.StarDemoEntity;
import com.sharding.demo.shardingdemo.entity.TestEntity;
import com.sharding.demo.shardingdemo.service.StarDemoService;
import com.sharding.demo.shardingdemo.service.TestService;
import com.sharding.demo.shardingdemo.service.impl.StarDemoServiceImpl;
import com.sharding.demo.shardingdemo.service.impl.TestSreviceImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.apache.shardingsphere.transaction.annotation.ShardingSphereTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.time.LocalDateTime;
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


    @SneakyThrows
    @GetMapping("exportprodsku")
    public void exportprodsku(
            HttpServletResponse response) {


        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

        ExcelWriter build = EasyExcel.write(response.getOutputStream()).autoCloseStream(false).build();
        for (int i = 0; i <= 2000; i++) {
            build.write(ListUtil.of("对象集合"), EasyExcel.writerSheet("模板").build());
        }

        build.close();


        log.info("over===={}", LocalDateTime.now());
    }


}
