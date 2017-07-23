package com.kong.qingwei.controller;

import com.kong.qingwei.bean.SysUser;
import com.kong.qingwei.bean.common.Response;
import com.kong.qingwei.bean.common.ReturnCode;
import com.kong.qingwei.bean.common.ReturnMessage;
import com.kong.qingwei.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

/**
 * Created by kongwc on 2017/7/22.
 */
@Controller
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 跳转到用户管理界面
     * @return
     */
    @RequestMapping("/userList")
    public ModelAndView userList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userList");
        return modelAndView;
    }

    /**
     * 查找所用用户控制器方法
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/findAllUser",method = RequestMethod.GET)
    @ResponseBody
    public  Response findAllUser()throws Exception{
        Response response = new Response();
        //调用service方法得到用户列表
        List<SysUser> users = sysUserService.queryAll();
        response.setReturnCode(ReturnCode.SUCCESS);
        response.setReturnMessage(ReturnMessage.SUCCESS);
        response.setData(users);
        return response;
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    @ResponseBody
    public Response addUser(@RequestBody SysUser user){
        user.setUserId(UUID.randomUUID().toString());
        Response response = new Response();
        response.setReturnCode(ReturnCode.SUCCESS);
        response.setReturnMessage(ReturnMessage.CREATE_SUCCESS);
        int result = sysUserService.addUser(user);
        return  response;
    }
}
