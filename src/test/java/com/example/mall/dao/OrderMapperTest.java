package com.example.mall.dao;

import com.example.mall.MallApplicationTests;
import com.example.mall.pojo.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author: iwen大大怪
 * @DateTime: 2020/9/16 2:04
 */
public class OrderMapperTest extends MallApplicationTests {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        Order order = orderMapper.selectByPrimaryKey(1);
        System.out.println(order);
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}