package com.example.mall.dao;

import com.example.mall.MallApplicationTests;
import com.example.mall.pojo.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: iwen大大怪
 * @DateTime: 2020/9/16 1:12
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CategoryMapperTest extends MallApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void findById() {
        Category category = categoryMapper.findById(100001);
        System.out.println(category.toString());
    }

    @Test
    public void queryById() {
        Category category = categoryMapper.queryById(100001);
        System.out.println(category.toString());
    }
}