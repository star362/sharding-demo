package com.sharding.demo.shardingdemo.entity;

//import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Description: <br>
 * Create Date: 2022/4/16 下午3:30 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
@Data
@TableName("test")
public class TestEntity {

    private Long id;
    private Date createTime;
    private String remark;
}
