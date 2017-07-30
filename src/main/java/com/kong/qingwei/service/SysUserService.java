package com.kong.qingwei.service;

import com.kong.qingwei.bean.SysUser;

import java.util.List;

/**
 * Created by kongwc on 2017/7/22.
 */
public interface SysUserService {
    public List<SysUser> queryAll();
    public int addUser(SysUser sysUser);
    public int updateUser(SysUser sysUser);
    public int deleteUser(String userId);

}
