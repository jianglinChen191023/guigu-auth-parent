package com.atguigu.system.service;

import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.SysUserQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

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

    /**
     * 根据用户名称获取用户信息
     *
     * @param username 用户名
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> getUserInfo(String username);
}
