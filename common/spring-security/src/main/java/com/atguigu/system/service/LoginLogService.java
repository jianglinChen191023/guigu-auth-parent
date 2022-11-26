package com.atguigu.system.service;

/**
 * 登录日志 服务接口类
 *
 * @author 陈江林
 * @date 2022/11/26 10:55
 */
public interface LoginLogService {

    /**
     * 保存登录日志
     *
     * @param username 用户名
     * @param status   状态
     * @param ipaddr   ip地址
     * @param message  消息
     */
    void saveLoginLog(String username, Integer status, String ipaddr, String message);

}
