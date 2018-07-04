package com.lidh.service.impl;

import com.lidh.mapper.UserMapper;
import com.lidh.model.User;
import com.lidh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lidhk on 2018/7/4.
 *
 * @author lidhk
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
