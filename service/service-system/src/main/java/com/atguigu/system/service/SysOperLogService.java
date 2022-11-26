package com.atguigu.system.service;

import com.atguigu.model.system.SysOperLog;
import com.atguigu.model.vo.SysOperLogQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 系统日志 服务接口
 *
 * @author 陈江林
 * @date 2022/11/27 06:07
 */
public interface SysOperLogService {
    /**
     * 获取分页列表
     *
     * @param page              当前页码
     * @param limit             每页记录数
     * @param sysOperLogQueryVo 系统日志查询条件对象
     * @return {@link IPage}<{@link SysOperLog}>
     */
    IPage<SysOperLog> getPage(Long page, Long limit, SysOperLogQueryVo sysOperLogQueryVo);
}
