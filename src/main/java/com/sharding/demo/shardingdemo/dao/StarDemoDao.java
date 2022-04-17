package com.sharding.demo.shardingdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sharding.demo.shardingdemo.entity.StarDemoEntity;
import org.apache.ibatis.annotations.Select;

/**
 * Description: <br>
 * Create Date: 2022/4/16 下午7:03<br>
 *
 * @author wangyu@mvtech.com.cn
 */
public interface StarDemoDao extends BaseMapper<StarDemoEntity> {


    int saveinfo(StarDemoEntity starDemoEntity);

    @Select("select count(1) from star_demo")
    int findcount();
}
