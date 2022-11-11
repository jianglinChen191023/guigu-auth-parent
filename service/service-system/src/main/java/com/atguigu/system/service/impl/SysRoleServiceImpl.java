package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.atguigu.system.mapper.SysRoleMapper;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 系统角色 服务实现类
 *
 * @author 陈江林
 * @date 2022/11/10 15:42
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
///    @Override
///    public IPage<SysRole> getPage(Page<SysRole> sysRolePage, SysRoleQueryVo sysRoleQueryVo) {
///        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
///        if (sysRoleQueryVo != null) {
///            String roleName = sysRoleQueryVo.getRoleName();
///            if (StringUtils.isEmpty(roleName)) {
///                wrapper.like(SysRole::getRoleName, roleName);
///            }
///        }
///
///        return baseMapper.selectPage(sysRolePage, wrapper);
///    }

    @Override
    public IPage<SysRole> getPage(Page<SysRole> sysRolePage, SysRoleQueryVo sysRoleQueryVo) {
        return baseMapper.selectPage(sysRolePage, sysRoleQueryVo);
    }
}
