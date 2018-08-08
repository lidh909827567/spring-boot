package com.lidh.service.impl;

import com.lidh.config.DS;
import com.lidh.mapper.UserMapper;
import com.lidh.model.User;
import com.lidh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

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

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @DS("db2")
    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @DS("db2")
    @Override
    public User selectByPrimaryKey(Integer userId) {
        User user=null;
        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        Boolean aBoolean = redisTemplate.hasKey(userId.toString());
        if (aBoolean){
             user = operations.get(userId.toString());
            return user;
        }
//        redisTemplate.opsForList().leftPush("user:userId",JSON.toJSONString(userId));
        //操作字符串.opsForHash();//操作hash.opsForList();//操作list.opsForSet();//操作set.opsForZSet();//操作有序set
//        stringRedisTemplate.opsForValue().set("user:userId","id");
        user = userMapper.selectByPrimaryKey(userId);
        operations.set(userId.toString(),user);
        return user;
    }
}
