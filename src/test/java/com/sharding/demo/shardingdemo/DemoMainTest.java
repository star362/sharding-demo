package com.sharding.demo.shardingdemo;

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.ip2region.core.Ip2regionSearcher;
import net.dreamlu.mica.ip2region.core.IpInfo;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Param;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.jooq.impl.DSL.table;


/**
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/4/19 14:14
 * @describe: <br>
 */
@Slf4j
@SpringBootTest
public class DemoMainTest {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Resource
    private DSLContext dsl;

    @Autowired
    private Ip2regionSearcher regionSearcher;


@Test
    public void test(){
    String sqltinfoo = "SELECT id, created_at, created_by, updated_at, updated_by, app_id, device_id, model_id, manufacturer_id, user_id, brand_name, status, expire_date, deleted, status_code, ip_address, sign  FROM " +
            "license_record0 WHERE created_at <= '2022-07-20 07:47:41' limit 1 ";

//    for (int i = 1; i <= sheetnum; i++) {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sqltinfoo);

        maps.parallelStream().forEach(map -> {


            Object ipAddress = map.get("ip_address");
            if (ObjectUtil.isNotNull(ipAddress)) {


                String[] split = ipAddress.toString().split(",");

                IpInfo ipInfo = regionSearcher.btreeSearch(split[0]);
                if (ipInfo != null) {
                    String country = ipInfo.getCountry();
                    if (country != null) {
                        if ("中国".equals(country)) {
                            map.put("sign", "c");
                        } else {
                            map.put("sign", "s");
                        }
                    }
                }
            }
            List<Field<Object>> fields = map.keySet().stream().map(DSL::field).collect(Collectors.toList());
            List<Param<Object>> values = map.values().stream().map(DSL::value).collect(Collectors.toList());
            int execute = dsl.insertInto(table("license_record")).columns(fields).values(values).execute();

            map.put("create_time", map.get("created_at"));
            fields = map.keySet().stream().map(DSL::field).collect(Collectors.toList());
            values = map.values().stream().map(DSL::value).collect(Collectors.toList());
            int execute2 = dsl.insertInto(table("license_handle")).columns(fields).values(values).execute();
            log.info("执行结果 {}==={}", execute, execute2);

        });


//    }
}



}
