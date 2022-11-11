package com.sharding.demo.shardingdemo.entity;

//import com.baomidou.mybatisplus.annotation.TableName;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Description: <br>
 * Create Date: 2022/4/16 下午3:30 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
@Builder
@Data
@Alias("test")
@TableName("test")
public class TestEntity {

    @TableId
    private Long id;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    private String remark;
}
