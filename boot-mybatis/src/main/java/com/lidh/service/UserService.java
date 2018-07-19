package com.lidh.service;

import com.lidh.model.User;

/**
 * Created by lidhk on 2018/7/4.
 *
 * @author lidhk
 */
public interface UserService {

    int addUser(User user);

    User selectByPrimaryKey(Integer userId);

}
