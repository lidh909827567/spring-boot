package com.dubbo.controller;

import com.alibaba.dubbo.common.json.JSONObject;
import com.dubbo.service.UserDubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lidhk on 2018/9/11.
 *
 * @author lidhk
 */
@Controller
public class UserDubboController {

    @Autowired
    private UserDubboService userDubboService;
    /**
     * 测试 JSON 接口；
     *
     * @param name 名字；
     * @return
     */
    @ResponseBody
    @RequestMapping("/test/{name}")
    public JSONObject testJson(@PathVariable("name") String name) {
        JSONObject jsonObject = new JSONObject();
        String testStr = userDubboService.sayHello(name);
        jsonObject.put("str", testStr);
        return jsonObject;
    }
}
