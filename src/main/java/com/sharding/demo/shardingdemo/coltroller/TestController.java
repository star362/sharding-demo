package com.sharding.demo.shardingdemo.coltroller;

import com.sharding.demo.shardingdemo.service.StarDemoService;
import com.sharding.demo.shardingdemo.service.impl.StarDemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: <br>
 * Create Date: 2022/4/16 下午8:17 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
@RestController
public class TestController {

    @Autowired
    StarDemoServiceImpl starDemoService;



    @GetMapping("a")
    public String a(){
        final Long aLong = starDemoService.getStarDemoDao().selectCount(null);

        return aLong.toString();
    }

    @GetMapping("b")
    public String b(){

        return "success";
    }
}
