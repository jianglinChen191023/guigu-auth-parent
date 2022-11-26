package com.atguigu.system.service;

import com.atguigu.model.system.SysLoginLog;
import com.atguigu.model.vo.SysLoginLogQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 日志登录表 服务接口类
 *
 * @author 陈江林
 * @date 2022/11/27 01:12
 */
public interface SysLoginLogService extends IService<SysLoginLog> {

    /**
     * 分页查询
     *
     * @param pageParam          页面参数
     * @param sysLoginLogQueryVo 系统登录日志查询视图对象
     * @return {@link IPage}<{@link SysLoginLog}>
     */
    IPage<SysLoginLog> getPage(Page<SysLoginLog> pageParam, SysLoginLogQueryVo sysLoginLogQueryVo);

}
