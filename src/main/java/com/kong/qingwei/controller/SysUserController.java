package com.kong.qingwei.controller;

import com.kong.qingwei.bean.SysUser;
import com.kong.qingwei.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by kongwc on 2017/7/22.
 */
@Controller
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    /**
     * 查找所用用户控制器方法
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAllUser")
    public ModelAndView findAllUser()throws Exception{
        ModelAndView modelAndView = new ModelAndView();

        //调用service方法得到用户列表
        List<SysUser> users = sysUserService.queryAll();
        //将得到的用户列表内容添加到ModelAndView中
        modelAndView.addObject("users",users);
        //设置响应的jsp视图
        modelAndView.setViewName("userList");

        return modelAndView;
    }

}
