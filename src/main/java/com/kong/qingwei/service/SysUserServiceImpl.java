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

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    public int addUser(SysUser sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    /**
     * 修改用户
     * @param sysUser
     * @return
     */
    public int updateUser(SysUser sysUser) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(sysUser.getUserId());
        return sysUserMapper.updateByExampleSelective(sysUser,example);
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    public int deleteUser(String userId) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return sysUserMapper.deleteByExample(example);
    }
}
