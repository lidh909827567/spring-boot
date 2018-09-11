package com.dubbo.service;


/**
 * Created by lidhk on 2018/9/11.
 *
 * @author lidhk
 */
public class UserDubboServiceImpl implements UserDubboService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}
