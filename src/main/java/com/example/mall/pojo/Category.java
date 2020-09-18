package com.example.mall.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 创建Category表对应的字段对象
 *
 * @Author: iwen大大怪
 * @DateTime: 2020/9/15 21:04
 */
@Data
public class Category {
    private Integer id;

    private Integer parentId;

    private String name;

    private Boolean status;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;

}
