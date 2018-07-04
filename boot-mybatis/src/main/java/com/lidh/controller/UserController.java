package com.lidh.controller;

import com.lidh.model.User;
import com.lidh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lidhk on 2018/7/4.
 *
 * @author lidhk
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user) {
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/select", produces = {"application/json;charset=UTF-8"})
    public User select(Integer id) {
        return userService.selectByPrimaryKey(id);
    }
}
