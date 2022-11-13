package com.atguigu.system.service;

import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.SysUserQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-13
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 分页查询
     *
     * @param objectPage
     * @param sysUserQueryVo
     * @return {@link IPage}<{@link SysUser}>
     */
    IPage<SysUser> getPage(Page<SysUser> objectPage, SysUserQueryVo sysUserQueryVo);
}
