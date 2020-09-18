package com.example.mall.service.impl;

import com.example.mall.dao.UserMapper;
import com.example.mall.enums.RoleEnum;
import com.example.mall.pojo.User;
import com.example.mall.service.IUserService;
import com.example.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

import static com.example.mall.enums.ResponseEnum.*;

/**
 * 用户模块实现类
 *
 * @Author: iwen大大怪
 * @DateTime: 2020/9/17 16:38
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     *
     * @param user
     */
    @Override
    public ResponseVo register(User user) {
        error();

        // username不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername > 0){
            // throw new RuntimeException("该username已经注册");
            return ResponseVo.error(USERNAME_EXIST);
        }
        // email不能重复
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail > 0){
            // throw new RuntimeException("该email已经注册");
            return ResponseVo.error(EMAIL_EXIST);
        }
        // 默认角色
        user.setRole(RoleEnum.CUSTOMER.getCode());
        // 密码用MD5加密(spring自带)
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        // 写入数据库
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0){
            // throw new RuntimeException("注册失败");
            return ResponseVo.error(ERROR);
        }
        return ResponseVo.success();
    }

    private void error() {
        throw new RuntimeException("意外错误");
    }
}
