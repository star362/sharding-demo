package com.sharding.demo.shardingdemo.entity;

//import com.baomidou.mybatisplus.annotation.TableName;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Description: <br>
 * Create Date: 2022/4/16 下午3:28 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
@Data
@Builder
@TableName("star_demo")
public class StarDemoEntity {
    @TableId
    private Long id;
    private Date createTime;
    private String remarks;
    private String starName;
    private String sex;
    private Integer age;
}
