package com.kong.qingwei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kongwc on 2017/7/22.
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public ModelAndView findAllUser()throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
