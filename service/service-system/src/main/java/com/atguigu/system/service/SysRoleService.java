package com.atguigu.system.service;

import com.atguigu.model.system.SysRole;
import com.atguigu.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
