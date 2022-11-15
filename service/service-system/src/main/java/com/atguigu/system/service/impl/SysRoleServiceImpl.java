package com.atguigu.system.service.impl;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.system.SysUserRole;
import com.atguigu.model.vo.AssginRoleVo;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.atguigu.system.mapper.SysRoleMapper;
import com.atguigu.system.mapper.SysUserRoleMapper;
import com.atguigu.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public IPage<SysRole> getPage(Page<SysRole> sysRolePage, SysRoleQueryVo sysRoleQueryVo) {
        return baseMapper.selectPage(sysRolePage, sysRoleQueryVo);
    }

    @Override
    public Map<String, Object> getRolesByUserId(Long userId) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("userRoleIds",
                // 根据用户id查询已经分配的角色
                sysUserRoleMapper.selectList(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, userId))
                        // 取出对应的角色id
                        .stream().map(SysUserRole::getRoleId).collect(Collectors.toList()));
        // 获取所有角色
        resultMap.put("allRoles", baseMapper.selectList(null));
        return resultMap;
    }

    @Override
    public void doAssign(AssginRoleVo assginRoleVo) {
        // - 重新分配角色
        // - - 先删除
        sysUserRoleMapper.delete(
                new LambdaQueryWrapper<SysUserRole>()
                        .eq(SysUserRole::getUserId, assginRoleVo.getUserId())
        );
        // - - 重新添加
        assginRoleVo.getRoleIdList().forEach(roleId -> {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(assginRoleVo.getUserId());
            sysUserRole.setRoleId(roleId);
            sysUserRoleMapper.insert(sysUserRole);
        });
    }
}
