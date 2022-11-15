package com.atguigu.system.service;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.AssginRoleVo;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 系统角色 服务接口类
 *
 * @author 陈江林
 * @date 2022/11/10 15:40
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 获取分页数据
     *
     * @param sysRolePage
     * @param sysRoleQueryVo
     * @return {@link IPage}<{@link SysRole}>
     */
    IPage<SysRole> getPage(Page<SysRole> sysRolePage, SysRoleQueryVo sysRoleQueryVo);

    /**
     * 根据用户id获取对应角色
     *
     * @param userId 用户id
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> getRolesByUserId(Long userId);

    /**
     * 给用户分配角色
     *
     * @param assginRoleVo
     */
    void doAssign(AssginRoleVo assginRoleVo);
}
