package com.lidh;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lidhk on 2018/7/20.
 *
 * @author lidhk
 */
@Controller
@RequestMapping("/")
public class DefaultView {

    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
