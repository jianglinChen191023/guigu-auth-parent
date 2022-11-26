package com.atguigu.system.service;

import com.atguigu.model.system.SysOperLog;

/**
 * 系统日志 服务接口
 *
 * @author 陈江林
 * @date 2022/11/27 05:27
 */
public interface OperLogService {

    /**
     * 保存系统日志
     *
     * @param sysOperLog 系统日志对象
     */
    void saveSysLog(SysOperLog sysOperLog);

}
