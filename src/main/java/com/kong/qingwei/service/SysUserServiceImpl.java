package com.kong.qingwei.service;

import com.kong.qingwei.bean.SysUser;
import com.kong.qingwei.bean.SysUserExample;
import com.kong.qingwei.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kongwc on 2017/7/22.
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询所有用户
     * @return
     */
    public List<SysUser> queryAll() {
        SysUserExample example = new SysUserExample();
        return sysUserMapper.selectByExample(example);
    }
}
