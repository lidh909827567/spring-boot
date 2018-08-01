package com.lidh.service.impl;

import com.lidh.config.DS;
import com.lidh.mapper.UserMapper;
import com.lidh.model.User;
import com.lidh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lidhk on 2018/7/4.
 *
 * @author lidhk
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @DS("db1")
    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @DS("db1")
    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
