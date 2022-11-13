package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.SysUserQueryVo;
import com.atguigu.system.mapper.SysUserMapper;
import com.atguigu.system.service.SysUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-13
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public IPage<SysUser> getPage(Page<SysUser> objectPage, SysUserQueryVo sysUserQueryVo) {
        return baseMapper.selectPage(objectPage, sysUserQueryVo);
    }
}
