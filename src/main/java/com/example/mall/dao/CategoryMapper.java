package com.example.mall.dao;

import com.example.mall.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * 查询数据库
 *
 * @Author: iwen大大怪
 * @DateTime: 2020/9/15 22:55
 */
public interface CategoryMapper {


    @Select("select * from mall_category where id = #{id}")
    Category findById(@Param("id") Integer id);

    Category queryById(Integer id);
}
