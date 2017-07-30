package com.kong.qingwei.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kong.qingwei.bean.SysUser;
import com.kong.qingwei.bean.common.Response;
import com.kong.qingwei.bean.common.ReturnCode;
import com.kong.qingwei.bean.common.ReturnMessage;
import com.kong.qingwei.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public static final Logger logger = LoggerFactory.getLogger(SysUserController.class);
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
    public  Response findAllUser(int page, int pageSize)throws Exception{
        logger.error("---------------param= page:" + page + "-----------pageSize:" + pageSize);
        Response response = new Response();
        PageHelper.startPage(page, pageSize);
        List<SysUser> users = sysUserService.queryAll();
        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(users);
        //System.out.println(JSON.toJSONString(pageInfo));
        //调用service方法得到用户列表
        response.setReturnCode(ReturnCode.SUCCESS);
        response.setReturnMessage(ReturnMessage.SUCCESS);
        response.setData(pageInfo);
        return response;
    }

    /**
     * 新增用户
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

    /**
     * 更新用户
     * @param user
     * @return
     */
    @RequestMapping(value="/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public Response updateUser(@RequestBody SysUser user){
        Response response = new Response();
        response.setReturnCode(ReturnCode.SUCCESS);
        response.setReturnMessage(ReturnMessage.UPDATE_SUCCESS);
        int result = sysUserService.updateUser(user);
        return  response;
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @RequestMapping(value="/deleteUser",method = RequestMethod.GET)
    @ResponseBody
    public Response deleteUser(String userId){
        Response response = new Response();
        response.setReturnCode(ReturnCode.SUCCESS);
        response.setReturnMessage(ReturnMessage.DELETE_SUCCESS);
        int result = sysUserService.deleteUser(userId);
        return  response;
    }
}
