package com.lidh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lidhk on 2018/7/18.
 *
 * @author lidhk
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping(value = "/login")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index1");

        List<String> userList = new ArrayList<String>();
        userList.add("admin");
        userList.add("user1");
        userList.add("user2");

        modelAndView.addObject("userList", userList);
        return modelAndView;
    }

    @RequestMapping("/mvc2")
    @ResponseBody
    public ModelAndView mvc2() {
        ModelAndView mv = new ModelAndView("demo");
        List<String> userList = new ArrayList<String>();
        userList.add("admin");
        userList.add("user1");
        userList.add("user2");
        mv.addObject("userList", userList);
        return mv;
    }

    @RequestMapping("/bootstrapTest")
    @ResponseBody
    public ModelAndView bootstrapTest() {
        ModelAndView mv = new ModelAndView("bootstrap_test");
        return mv;
    }
}
